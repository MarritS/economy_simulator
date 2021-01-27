package goods;

import java.util.List;

/**
 * Holds and creates the various goods that exist
 * @param Name
 */
public class GoodFactory {
	private final GoodsCollection goodsCollection;
	
	public GoodFactory(GoodsCollection goodsCollection) {
		this.goodsCollection = goodsCollection; 
	}
	
	public List<Good> returnAllGoods() {
		return goodsCollection.getAllGoods(); 
	}
	
	public Good getGood(String name) {
		return goodsCollection.getGood(name);
	}
	

	public void addToGood(Good good, int numProduced) {
		
	}
	
}
