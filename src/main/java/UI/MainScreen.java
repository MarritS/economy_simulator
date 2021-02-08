package UI;

import economy_simulator.Economy;
import economy_simulator.OutputProviderFactory;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class MainScreen extends Application {
	static TextArea output = new TextArea();
	
	@Override
	public void start(Stage primaryStage) {
		OutputUI outputUI = new OutputUI(output); 
		OutputProviderFactory.setOutput(outputUI);
		
		primaryStage.setTitle("JavaFX Welcome");
		Button btn = new Button();
		btn.setText("Run simulation");
		btn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Economy.startSim();
			}
		});		

		FlowPane root = new FlowPane();
		root.setOrientation(Orientation.VERTICAL);
		root.getChildren().add(btn);
		root.getChildren().add(output); 
		primaryStage.setScene(new Scene(root, 300, 250));

		primaryStage.show();
	}
	
	public static void write(String text) {
		output.appendText(text);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
