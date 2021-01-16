package goods;

import java.util.ArrayList;
import java.util.List;

public class GoodsCollection {
	List<Good> goods= new ArrayList<>();
	
	
	/**
	 * Returns the good if present in collection, otherwise returns null
	 * @param name
	 * @return
	 */
	protected Good getGood(String name) {
		assert(name != null);
		for (Good good : goods) {
			if (good.getName().equals(name)) {
				return good; 
			} 
		}
		return null; 
	}
	
	protected List<Good> getAllGoods() {
		return goods; 
	}
	
	/**
	 * Returns true if good exists, otherwise returns false. 
	 * @param name
	 * @return
	 */
	protected boolean goodExists(String name) {
		Good good = getGood(name); 
		if (good == null) {
			return false;
		} else {
			return true; 
		}
				
	}
	
	/**
	 * Adds a good to the collection if the name doesn't exist already, otherwise does nothing
	 * @param name
	 */
	protected void createGood(String name) {
		if (!goodExists(name)) {
			Good good = new Good(name); 
			goods.add(good); 
		}
	}
	
	
}
