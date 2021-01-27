package consumer;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import consumer.Consumer;
import consumer.ConsumerGoodProfile;
import consumer.ConsumerProfile;
import economy_simulator.Market;
import goods.DefaultGoodsCollection;
import goods.Good;
import goods.GoodFactory;

public class ConsumerTest {

	private Consumer consumer;
	private Market market;
	Good good;
	final int CONSUMPTION = 4; 

	@BeforeEach
	void setUp() {
		GoodFactory goodFactory = new GoodFactory(new DefaultGoodsCollection());
		ConsumerProfile consumerProfile = new MockConsumptionProfile(goodFactory);
		Market.initialize(goodFactory);
		market = Market.getInstance();
		good = goodFactory.getGood("A");
		// The test assumes that the market initializes with at least 5 of the product
		// we'll use to test
		int quantAtFirst = market.getQuantityGood(good);
		assertTrue(quantAtFirst >= 5);

		consumer = new Consumer(consumerProfile, 0, market);
	}

	@Test
	void testConsumeGood() {
		int quantAtFirst = market.getQuantityGood(good);
		consumer.performRole();
		int quantAfterConsumption = market.getQuantityGood(good);
		assertEquals(quantAtFirst - quantAfterConsumption, CONSUMPTION);
	}
	
	@Test 
	void testConsumeGoodTooMuch() {
		int quantAtFirst = market.getQuantityGood(good);
		while(quantAtFirst>=CONSUMPTION) {
			consumer.performRole();
			quantAtFirst = market.getQuantityGood(good);
		}
		int quantAtSecond = market.getQuantityGood(good);
		consumer.performRole();
		int quantAtLast = market.getQuantityGood(good);
		assertEquals(quantAtSecond, quantAtLast); 
	}

	/**
	 * This consumptionprofile assures a consumption of 5 for good A.
	 * 
	 * @author Marrit Schellekens
	 *
	 */
	private class MockConsumptionProfile extends ConsumerProfile {

		public MockConsumptionProfile(GoodFactory goodFactory) {
			super(goodFactory);
			resetConsumptionProfileToTestParams();
			Good good = goodFactory.getGood("A");
			this.setConsumptionForGood(good, CONSUMPTION);
		}

		public void resetConsumptionProfileToTestParams() {
			for (ConsumerGoodProfile consumerGoodProfile : consumptionProfile) {
				consumerGoodProfile.setConsumption(0);
			}
		}

	}

}
