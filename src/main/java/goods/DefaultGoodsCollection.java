package goods;

public class DefaultGoodsCollection extends GoodsCollection {
	String[] names = {"A", "B", "C", "D", "E" }; 
	public DefaultGoodsCollection() {
		for (String name: names) {
			createGood(name);
		}
	}

}
