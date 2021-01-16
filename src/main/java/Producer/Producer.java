package Producer;

import java.util.List;

import economy_simulator.Market;
import goods.Good;
import population.Role;

public class Producer extends Role {

	public Producer(ProducerProfile profile, int id) {
		super(id);
		this.profile = profile; 
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
				market.addToGood(good, numProduced);
				String message = String.format("Consumer %d has produced %d of %s", id, numProduced, name);
				System.out.println(message);
		}
	}

}
