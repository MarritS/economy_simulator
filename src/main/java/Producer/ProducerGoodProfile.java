package Producer;

import java.util.Random;

import goods.Good;

public class ProducerGoodProfile {
	private final Good good; 
	private int prodPerTU; 
	
	ProducerGoodProfile(Good good, int max, int min) {
		this.good = good; 
        prodPerTU =  getRandomProduction(max, min);
	}
	
	private int getRandomProduction(int max, int min) {
		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
	
	protected Good getGood() {
		return good; 
	}
	
	protected void setProduction(int production) {
		assert(production >= 0);
		this.prodPerTU = production; 
	}

	public int getProduction() {
		return prodPerTU; 
	}
}
