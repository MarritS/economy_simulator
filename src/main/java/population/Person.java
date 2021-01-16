package population;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import goods.Good;


public class Person {
	List<Role> roles = new ArrayList<>(); 
	Map<Good, Integer> inventory = new HashMap<>(); 
	private final int id; 
	
	Person(int id) {
		this.id= id; 
	}
	
	public void addRole(Role role) {
		assert(role != null); 
		roles.add(role);
	}
	
	public void performRoles() {
		for (Role role : roles) {
			role.performRole();
		}
	}
}
