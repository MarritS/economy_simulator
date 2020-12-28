package exercise_planner;

import java.util.ArrayList;
import java.util.List;

public class Exercise {
	List<Integer> numPerformed = new ArrayList<>(); 
	String name;
	
	Exercise(String name) {
		this.name = name; 
	}
	
	public String getName() {
		return new String(name);
	}


	public void addTrainingSession(int numPerformedDuringSession) {
		numPerformed.add(numPerformedDuringSession);
	}
	
	public List<Integer> getNumPerformed() {
		List<Integer> deepCopy = new ArrayList<>();
		for (int num : numPerformed) {
			deepCopy.add(num);
		}
		return deepCopy; 
	}
}
