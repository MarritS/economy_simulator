package population;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import goods.Good;


public class Person {
	List<Role> roles = new ArrayList<>(); 
	Map<Good, Integer> inventory = new HashMap<>(); 
	public double money; 
	private final int id; 
	
	public Person(int id, double initMoneyAmount) {
		this.id= id; 
		this.money = initMoneyAmount; 
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

	public double moneyInWallet() {
		return money; 
	}

	public void moneyChanged(double amount) {
		money = money + amount; 
	}
}
