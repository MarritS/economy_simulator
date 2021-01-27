package consumer;

import java.util.List;

import economy_simulator.Market;
import economy_simulator.NotEnoughInventoryException;
import goods.Good;
import population.Role;

public class Consumer extends Role {

	Market market; 
	
	public Consumer(ConsumerProfile profile, int id, Market market) {
		super(id); 
		this.market = market; 
		this.profile = profile;
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
		int numConsumed = ((ConsumerProfile) profile).consumptionForGood(good);
		if (numConsumed > 0) {
			try {
				market.subtractFromGood(good, numConsumed);
				String message = String.format("Consumer %d has consumed %d of %s", id, numConsumed, name);
				System.out.println(message);
			} catch (NotEnoughInventoryException e) {
				String message = String.format(
						"Consumer %d wanted to consume %d of %s, but there was not enough to satisfy the desire", id,
						numConsumed, name);
				System.out.println(message);
			}
		}

	}
}
