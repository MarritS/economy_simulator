package Producer;

import java.util.ArrayList;
import java.util.List;

import goods.Good;
import goods.GoodFactory;
import population.RoleProfile;

public class ProducerProfile implements RoleProfile {
	List<ProducerGoodProfile> productionProfile = new ArrayList<>(); 
	
	public ProducerProfile(GoodFactory goodFactory) {
		List<Good> goods = goodFactory.returnAllGoods(); 
		for (Good good : goods) {
			ProducerGoodProfile goodProfile = new ProducerGoodProfile(good, 10, 0);
			productionProfile.add(goodProfile); 
		}
	}
	
	//TODO: Rewrite with stream
	protected List<Good> returnAllProducedGood() {
		List<Good> goods = new ArrayList<>();
		for (ProducerGoodProfile producerGoodProfile : productionProfile) {
			goods.add(producerGoodProfile.getGood());
		}
		return goods; 
	}
	
	protected int productionForGood(Good good) {
		for (ProducerGoodProfile producerGoodProfile : productionProfile) {
			if (producerGoodProfile.getGood().equals(good)) {
				return producerGoodProfile.getProduction(); 
			}
		}
		return 0; 
	}
	
	protected void setProductionForGood(Good good, int production) {
		for (ProducerGoodProfile producerGoodProfile : productionProfile) {
			if (producerGoodProfile.getGood().equals(good)) {
				producerGoodProfile.setProduction(production);
			}
		}
	}
	
}
