package population;

import java.util.List;

import goods.GoodFactory;

public abstract class PopulationInitializer {
	protected final int numPeople;
	
	PopulationInitializer(int numPeople) {
		this.numPeople = numPeople; 
	}
	
	
	protected abstract List<Person> initialize(GoodFactory goodFactory); 
}
