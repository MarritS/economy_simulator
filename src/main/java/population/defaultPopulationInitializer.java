package population;

import java.util.ArrayList;
import java.util.List;

import Producer.Producer;
import Producer.ProducerProfile;
import consumer.Consumer;
import consumer.ConsumerProfile;
import economy_simulator.Market;
import goods.GoodFactory;

public class defaultPopulationInitializer extends PopulationInitializer {
	
	Market market; 
	
	public defaultPopulationInitializer(int numPeople, Market market) {
		super(numPeople);
		this.market = market; 
	}

	@Override
	protected List<Person> initialize(GoodFactory goodFactory) {
		List<Person> population = new ArrayList<>(); 
		for (int i = 0; i<numPeople; i++) {
			Person person = createPerson(goodFactory, i); 
			population.add(person); 
		}
		return population; 
	}
	
	private Person createPerson(GoodFactory goodFactory, int id) {
		Person person = new Person(id); 
		
		ConsumerProfile consumerProfile = new ConsumerProfile(goodFactory); 
		Role roleConsumer = new Consumer(consumerProfile, id, market); 
		person.addRole(roleConsumer);
		
		ProducerProfile producerProfile = new ProducerProfile(goodFactory); 
		Role roleProducer = new Producer(producerProfile, id);
		person.addRole(roleProducer);
		
		return person; 
	}

}
