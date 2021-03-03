package Producer;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import economy_simulator.Market;
import goods.DefaultGoodsCollection;
import goods.Good;
import goods.GoodFactory;
import population.Person;

public class ProducerTest {
	Producer producer; 
	Market market; 
	Person person;
	final int PRODUCTION = 7; 
	
	Good good; 
	
	@BeforeEach
	void setup() {
		GoodFactory goodFactory = new GoodFactory(new DefaultGoodsCollection());
		ProducerProfile producerProfile = new MockProductionProfile(goodFactory); 
		person = new Person(0, 0);
		producer = new Producer(producerProfile, 0, person);
		good = goodFactory.getGood("C");
		Market.initialize(goodFactory);
		market = Market.getInstance(); 
	}
	
	@Test
	void testProduceGood() {
		double price = market.requestPriceGood(good);
		int quantAtFirst = market.getQuantityGood(good);
		double moneyAtFirst = person.moneyInWallet();
		producer.performRole();
		int quantAfterConsumption = market.getQuantityGood(good);
		double moneyAfterProduction = person.moneyInWallet();
		assertEquals(quantAfterConsumption - quantAtFirst, PRODUCTION);
		assertEquals(moneyAtFirst + (price*PRODUCTION), moneyAfterProduction, 0.00001);
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
			resetConsumptionProfileToTestParams();
			Good good = goodFactory.getGood("C");
			this.setProductionForGood(good, PRODUCTION);
		}
		
		public void resetConsumptionProfileToTestParams() {
			for (ProducerGoodProfile producerGoodProfile : productionProfile) {
				producerGoodProfile.setProduction(0);
			}
		}

	}

}
