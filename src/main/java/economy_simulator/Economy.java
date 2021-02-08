package economy_simulator;

import java.util.ArrayList;
import java.util.List;

import goods.DefaultGoodsCollection;
import goods.GoodFactory;
import population.Population;
import population.PopulationFactory;
import population.defaultPopulationInitializer;

public class Economy {
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
	
	public static void startSim() {
		setup();
		for(int i = 0; i<timeToSimulate; i++) {
			population.performRoles();
		}
	}
	
	private static void setup() {
		goodFactory = new GoodFactory(new DefaultGoodsCollection());
		market = Market.initialize(goodFactory);
		population = createPopulation(market); 
		
	}
	
	private static Population createPopulation(Market market) {
		PopulationFactory populationFactory = new PopulationFactory(new defaultPopulationInitializer(numOfPeople, market), goodFactory); 
		Population population = new Population(populationFactory); 
		return population; 
	}
	

}
