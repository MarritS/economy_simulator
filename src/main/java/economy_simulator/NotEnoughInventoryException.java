package economy_simulator;

@SuppressWarnings("serial")
public class NotEnoughInventoryException extends Exception {
	NotEnoughInventoryException(String message) {
		super(message); 
	}
}
