package Producer;

import java.util.List;

import economy_simulator.Market;
import goods.Good;
import output.Output;
import output.OutputFactory;
import population.Person;
import population.Role;

public class Producer extends Role {
	
	Output output = OutputFactory.getOutput();
	Person person; 

	public Producer(ProducerProfile profile, int id, Person person) {
		super(id);
		this.profile = profile; 
		this.person = person; 
	}
	

	@Override
	public void performRole() {
		produce();
	}
	
	private void produce() {
		List<Good> goods = ((ProducerProfile) profile).returnAllProducedGood();
		for (Good good : goods) {
			produceGood(good);
		}
	}
	
	private void produceGood(Good good) {
		String name = good.getName();
		int numProduced = ((ProducerProfile) profile).productionForGood(good);
		if (numProduced > 0) {
			Market market = Market.getInstance();
				double price = market.requestPriceGood(good);
				market.addToGood(good, numProduced);
				person.moneyChanged(price * numProduced);
				String message = String.format("Consumer %d has produced %d of %s", id, numProduced, name);
				output.print(message);
		}
	}
	
	

}
