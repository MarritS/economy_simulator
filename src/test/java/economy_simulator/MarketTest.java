package economy_simulator;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import goods.DefaultGoodsCollection;
import goods.Good;
import goods.GoodFactory;

public class MarketTest {

	private Market market;
	Good good;

	@BeforeEach
	void setUp() {
		GoodFactory goodFactory = new GoodFactory(new DefaultGoodsCollection());
		Market.initialize(goodFactory);
		market = Market.getInstance();
		good = goodFactory.getGood("A");
		//The test assumes that the quantity at the beginning of the test is at least 5. 
		assertTrue(market.getQuantityGood(good)>=5);
	}
	

	@Test
	void testSubtractFromGoodNormal() {
		int quantBefore = market.getQuantityGood(good);
		try {
			market.subtractFromGood(good, 5);
			int quantAfter = market.getQuantityGood(good);
			assertEquals(quantBefore-quantAfter, 5);
		} catch (NotEnoughInventoryException e) {
			fail(); 
		}
	}
	
	@Test
	void testSubtractFromGoodJustEnough() {
		int quantBefore = market.getQuantityGood(good);
		try {
			market.subtractFromGood(good, quantBefore);
			int quantAfter = market.getQuantityGood(good);
			assertEquals(quantAfter, 0); 
		} catch(NotEnoughInventoryException e) {
			fail(); 
		}
	}
	
	@Test
	void testSubtractFromGoodExceptionInsufficient() {
		int quantBefore = market.getQuantityGood(good);
		try {
			int quantityToSubtract = quantBefore + 1; 
			market.subtractFromGood(good, quantityToSubtract);
			fail();
		} catch(NotEnoughInventoryException e) {
			
		}
	}
	


}
