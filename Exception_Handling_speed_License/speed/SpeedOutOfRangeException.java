package speed;

@SuppressWarnings(" serial")
public class SpeedOutOfRangeException extends Exception {            //Class of  InvalidLicenseException
	public SpeedOutOfRangeException( String ermsg)            //Parameterized Constructor
	{
		super (ermsg);    //Send Message To Throwable Exception
	}

}
