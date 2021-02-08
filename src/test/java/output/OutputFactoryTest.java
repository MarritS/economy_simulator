package output;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import UI.OutputUI;

public class OutputFactoryTest {
	
	@Test
	void noNullTest() {
		assert(OutputFactory.getOutput() != null);
	}
	
	@Test
	void setOutputTest() {
		OutputMock output = new OutputMock(); 
		OutputFactory.setOutput(output);
		
		Output outputReceived = OutputFactory.getOutput(); 
		assertTrue(outputReceived instanceof OutputMock);
	}
	
	class OutputMock extends Output {

		@Override
		public void print(String text) {
			//Intentionally left blank
		}
	}
}
