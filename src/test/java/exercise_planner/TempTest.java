package exercise_planner;

import static org.junit.jupiter.api.Assertions.fail;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.jupiter.api.Test;

class TempTest {

	@Test
	void test() {
		Temp temp = new Temp(); 
		
		int result = temp.sum(5, 4);
		
		assertThat(result, equalTo(9));
	}

}
