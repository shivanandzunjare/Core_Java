package custom_exception;
@SuppressWarnings("serial")

   //custom exception for  handling vehicle exception
public class VehicleHandlingException  extends Exception{
	
	public VehicleHandlingException (String ermsg) {  //Parameterized constructor----------
		super(ermsg);
	}

}
