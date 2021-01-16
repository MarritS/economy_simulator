package population;

import java.util.ArrayList;
import java.util.List;

import Producer.Producer;
import Producer.ProducerProfile;
import consumer.Consumer;
import consumer.ConsumerProfile;
import goods.GoodFactory;

public class defaultPopulationInitializer extends PopulationInitializer {
	
	public defaultPopulationInitializer(int numPeople) {
		super(numPeople);
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
		Role roleConsumer = new Consumer(consumerProfile, id); 
		person.addRole(roleConsumer);
		
		ProducerProfile producerProfile = new ProducerProfile(goodFactory); 
		Role roleProducer = new Producer(producerProfile, id);
		person.addRole(roleProducer);
		
		return person; 
	}

}
