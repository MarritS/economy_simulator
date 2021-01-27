package consumer;

import java.util.ArrayList;
import java.util.List;

import goods.Good;
import goods.GoodFactory;
import population.RoleProfile;

/***
 * 
 * @author Marrit Schellekens
 * Contains consumption profile for one consumer. 
 */
public class ConsumerProfile implements RoleProfile {
	//TODO: Change to map
	protected List<ConsumerGoodProfile> consumptionProfile = new ArrayList<>(); 
	
	public ConsumerProfile(GoodFactory goodFactory) {
		List<Good> goods = goodFactory.returnAllGoods(); 
		for (Good good : goods) {
			ConsumerGoodProfile goodProfile = new ConsumerGoodProfile(good, 10, 0);
			consumptionProfile.add(goodProfile); 
		}
	}
	
	//TODO: Rewrite with stream
	protected List<Good> returnAllConsumedGood() {
		List<Good> goods = new ArrayList<>();
		for (ConsumerGoodProfile consumerGoodProfile : consumptionProfile) {
			goods.add(consumerGoodProfile.getGood());
		}
		return goods; 
	}
	
	protected void setConsumptionForGood(Good good, int consumption) {
		for (ConsumerGoodProfile consumerGoodProfile : consumptionProfile) {
			if (consumerGoodProfile.getGood().equals(good)) {
				consumerGoodProfile.setConsumption(consumption);
			}
		}
	}
	
	protected int consumptionForGood(Good good) {
		for (ConsumerGoodProfile consumerGoodProfile : consumptionProfile) {
			if (consumerGoodProfile.getGood().equals(good)) {
				return consumerGoodProfile.getConsumption(); 
			}
		}
		return 0; 
	}
	
}
