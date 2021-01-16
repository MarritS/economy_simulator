package population;

import java.util.List;

public class Population {
	PopulationFactory populationFactory;
	
	public Population(PopulationFactory populationFactory) {
		this.populationFactory = populationFactory; 
	}
	
	public void performRoles() {
		List<Person> population = populationFactory.getPopulation(); 
		for (Person person : population) {
			person.performRoles();
		}
	}

}
