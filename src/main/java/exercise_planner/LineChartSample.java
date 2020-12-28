package exercise_planner;

import java.util.List;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class LineChartSample extends Application {
	
	public static Exercise exercise; 
	
    @Override public void start(Stage stage) {
        stage.setTitle("Line Chart Sample");
        
        //defining the axes
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Number of Month");
        yAxis.setLabel("Number of reps per session");
        
        //creating the chart
        final LineChart<Number,Number> lineChart = 
                new LineChart<Number,Number>(xAxis,yAxis);
                
        lineChart.setTitle(exercise.getName());
        
        //defining a series
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        List<Integer> numbers = exercise.getNumPerformed();
        int counter = 0; 
        for (int x : numbers) {
        	series.getData().add(new XYChart.Data<Number, Number>(counter, x));
        	counter++;
        }
        
        Scene scene  = new Scene(lineChart,800,600);
        lineChart.getData().add(series);
       
        stage.setScene(scene);
        stage.show();
    }
    
    
 
    public static void main(String[] args) {
    	//Creating some demo data
    	exercise = new Exercise("pushup");
    	for (int i=0; i<10; i++) {
    		int number = (int) Math.pow(2, i); 
    		exercise.addTrainingSession(number);
    	}
    	
        launch(args);
    }
    
}