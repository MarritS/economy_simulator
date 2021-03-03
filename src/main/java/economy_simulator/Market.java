package economy_simulator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import goods.Good;
import goods.GoodFactory;

public class Market {
	static Market market;
	GoodFactory goodFactory;
	Map<Good, Integer> inventory = new HashMap<>();
	Map<Good, Double> priceLevel = new HashMap<>();
	
	private Market(GoodFactory goodFactory) {
		this.goodFactory = goodFactory; 
		List<Good> goods = goodFactory.returnAllGoods();
		for (Good good : goods) {
			inventory.put(good, 10);
			priceLevel.put(good, 5.0);
		}
	}
	
	public static Market initialize(GoodFactory goodFactory) {
		market = new Market(goodFactory); 
		return market; 
	}
	
	public static Market getInstance() {
		if (market == null) {
			assert(false); 
		} 
		return market; 
	}
	
	public void addToGood(Good good, int numProduced) {
		int storage = inventory.get(good);
		storage = storage + numProduced; 
		inventory.put(good, storage);
	}
	
	public int getQuantityGood(Good good) {
		return inventory.get(good);
	}
	
	public double requestPriceGood(Good good) {
		return priceLevel.get(good);
	}
	
	public void subtractFromGood(Good good, int numConsumed) throws NotEnoughInventoryException {
		int storage = inventory.get(good);
		if (storage < numConsumed) { 
			throw new NotEnoughInventoryException("Not enough inventory to service request"); 
		} else {
			storage = storage - numConsumed; 
			inventory.put(good,  storage); 
		}
	}
	
}
