package UI;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import output.Output;

public class OutputUI extends Output {
	TextArea textfield; 

	public OutputUI(TextArea output) {
		assert(output!=null); 
		this.textfield = output; 
	}
	@Override
	public void print(String text) {
		textfield.appendText(text);
		textfield.appendText("\n");
	}

}
