package consumer;

import java.util.Random;

import goods.Good;

/**
 * Contains consumption profile for one good, for one consumer.
 * @author Marrit Schellekens
 *
 */
public class ConsumerGoodProfile {
	private final Good good; 
	private int consPerTU; 
	
	protected ConsumerGoodProfile(Good good, int max, int min) {
		this.good = good; 
        consPerTU =  getRandomConsumption(max, min);
	}
	
	/**
	 * Return a random integer that indicates the consumption per time unit.
	 * Uses a uniformly distributed value.  
	 * @param max maximum number that can be returned
	 * @param min minimum number that can be returned
	 */
	private int getRandomConsumption(int max, int min) {
		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
	
	protected Good getGood() {
		return good; 
	}
	
	public void setConsumption(int consumption) {
		assert(consumption >= 0);
		this.consPerTU = consumption; 
	}

	public int getConsumption() {
		return consPerTU; 
	}
}
