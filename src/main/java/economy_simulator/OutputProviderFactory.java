package economy_simulator;

public class OutputProviderFactory {
	static Output output;

	public static void setOutput(Output out) {
		assert (out != null);
		output = out;
	}
	
	public static Output getOutput() {
		assert(output!=null); 
		return output; 
	}
}
