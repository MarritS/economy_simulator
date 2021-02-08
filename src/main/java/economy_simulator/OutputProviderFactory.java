package economy_simulator;

public class OutputProviderFactory {
	static Output output;

	public static void setOutput(Output out) {
		assert (out != null);
		output = out;
	}

	public static Output getOutput() {
		if (output == null) {
			return new OutputConsole();
		} else {
			return output;
		}
	}
}
