package burger.exception;

public class BurgerException extends Exception{
	private static long SerialVersonUID = 20190207L;
	
	public BurgerException(String message) {
		super(message);
	}
}
