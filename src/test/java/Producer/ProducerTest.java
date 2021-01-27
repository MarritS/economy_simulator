package Producer;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Producer.Producer;
import consumer.ConsumerGoodProfile;
import consumer.ConsumerProfile;
import economy_simulator.Market;
import goods.DefaultGoodsCollection;
import goods.Good;
import goods.GoodFactory;

public class ProducerTest {
	Producer producer; 
	Market market; 
	final int PRODUCTION = 7; 
	
	Good good; 
	
	@BeforeEach
	void setup() {
		GoodFactory goodFactory = new GoodFactory(new DefaultGoodsCollection());
		ProducerProfile producerProfile = new MockProductionProfile(goodFactory); 
		producer = new Producer(producerProfile, 0);
		good = goodFactory.getGood("C");
		Market.initialize(goodFactory);
		market = Market.getInstance(); 
	}
	
	@Test
	void testProduceGood() {
		int quantAtFirst = market.getQuantityGood(good);
		producer.performRole();
		int quantAfterConsumption = market.getQuantityGood(good);
		assertEquals(quantAfterConsumption - quantAtFirst, PRODUCTION);
	}
	
	/**
	 * This consumptionprofile assures a consumption of 5 for good A.
	 * 
	 * @author Marrit Schellekens
	 *
	 */
	private class MockProductionProfile extends ProducerProfile {

		public MockProductionProfile(GoodFactory goodFactory) {
			super(goodFactory);
			Good good = goodFactory.getGood("C");
			this.setProductionForGood(good, PRODUCTION);
		}

	}

}
