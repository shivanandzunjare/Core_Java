package custom_exception;

@SuppressWarnings("serial")
public class CustomerHandlingException extends Exception {
	public  CustomerHandlingException (String errmsg) {
		super(errmsg);
	}

}
