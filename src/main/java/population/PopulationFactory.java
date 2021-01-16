package population;

import java.util.List;

import goods.GoodFactory;

public class PopulationFactory {
	private final List<Person> population; 
	
	public PopulationFactory(PopulationInitializer initializer, GoodFactory goodFactory) {
		population = initializer.initialize(goodFactory);
	}
	
	public List<Person> getPopulation() {
		return population; 
	}
}
