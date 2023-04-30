package speed;
@SuppressWarnings(" serial")
public class InvalidLicenseException extends Exception {  //Class of  InvalidLicenseException
	
	public InvalidLicenseException(String ermsg) {   //Parameterized Constructor
		super (ermsg);  //Send Message To Throwable Exception
	}

}
