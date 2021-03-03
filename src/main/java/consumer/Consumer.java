package consumer;

import java.util.List;

import economy_simulator.Market;
import economy_simulator.NotEnoughInventoryException;
import goods.Good;
import output.Output;
import output.OutputFactory;
import population.Person;
import population.Role;

public class Consumer extends Role {

	Market market; 
	Output output = OutputFactory.getOutput();
	Person person; 
	
	public Consumer(ConsumerProfile profile, int id, Market market, Person person) {
		super(id); 
		this.market = market; 
		this.profile = profile;
		this.person = person; 
	}
	
	

	@Override
	public void performRole() {
		consume();
	}

	private void consume() {
		List<Good> goods = ((ConsumerProfile) profile).returnAllConsumedGood();
		for (Good good : goods) {
			consumeGood(good);
		}
	}

	private void consumeGood(Good good) {
		String name = good.getName();
		double price = market.requestPriceGood(good);
		
		if (person.moneyInWallet() < price) {
			String message = String.format("Consumer %d does not have enough money to buy the desired number of product %s", id, name);
			output.print(message);
			return; 
		} 
		
		int numConsumed = ((ConsumerProfile) profile).consumptionForGood(good);
		if (numConsumed > 0) {
			try {
				market.subtractFromGood(good, numConsumed);
				person.moneyChanged(-1*price);
				String message = String.format("Consumer %d has consumed %d of %s", id, numConsumed, name);
				output.print(message);
			} catch (NotEnoughInventoryException e) {
				String message = String.format(
						"Consumer %d wanted to consume %d of %s, but there was not enough to satisfy the desire", id,
						numConsumed, name);
				output.print(message);
			}
		}

	}
}
