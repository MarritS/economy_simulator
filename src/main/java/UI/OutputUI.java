package UI;

import economy_simulator.Output;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class OutputUI extends Output {
	TextArea textfield; 

	OutputUI(TextArea output) {
		assert(output!=null); 
		this.textfield = output; 
	}
	@Override
	public void print(String text) {
		textfield.appendText(text);
		textfield.appendText("\n");
	}

}
