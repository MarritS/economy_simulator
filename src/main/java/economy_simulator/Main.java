package economy_simulator;

import goods.DefaultGoodsCollection;
import goods.GoodFactory;
import population.Population;
import population.PopulationFactory;
import population.defaultPopulationInitializer;

public class Main {
	private final static int numOfPeople = 5; 
	private final static int timeToSimulate = 10; 
	
	private static GoodFactory goodFactory; 
	private static Population population; 
	private static Market market; 

	public static void main(String[] args) {
		setup();
		for(int i = 0; i<timeToSimulate; i++) {
			population.performRoles();
		}
		
	}
	
	private static void setup() {
		goodFactory = new GoodFactory(new DefaultGoodsCollection());
		population = createPopulation(); 
		market = Market.initialize(goodFactory);
	}
	
	private static Population createPopulation() {
		PopulationFactory populationFactory = new PopulationFactory(new defaultPopulationInitializer(numOfPeople), goodFactory); 
		Population population = new Population(populationFactory); 
		return population; 
	}
	

}
