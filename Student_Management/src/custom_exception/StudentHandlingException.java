package custom_exception;

@SuppressWarnings("serial ")

// custom exception 
public class StudentHandlingException extends Exception {
	
	public StudentHandlingException (String errmsg) {
		super(errmsg);
	}

}
