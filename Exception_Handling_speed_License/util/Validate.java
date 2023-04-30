package util;
import speed.InvalidLicenseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import speed.SpeedOutOfRangeException;

import java.io.InvalidClassException;
import java.text.ParseException;

public class Validate {   
	public static final int MAX_SPEED;
	public  static final int MIN_SPEED;
	
	public static SimpleDateFormat sdf;
	static {
		MAX_SPEED=120;
		MIN_SPEED=80;
		sdf=new SimpleDateFormat("dd-MM-yyyy");
	}
	
	
	//static method to validate speed
	public static void 	validateSpeed(int speed) throws SpeedOutOfRangeException {
		if(speed<MIN_SPEED)
           throw new SpeedOutOfRangeException(" speed is too slow, increase speed ");
		
		if(speed > MAX_SPEED)
	           throw new SpeedOutOfRangeException(" speed is very high, slow down");
		
		System.out.println(" Your  speed is within range  !! Happy Journey ");
		
	
	}
	
	//static method for checking driving License is Expire or not ??
	public static Date checkLic(String exp) throws ParseException,InvalidLicenseException{
		
		Date expdate=sdf.parse(exp);
		Date today=new Date();
		
		if(expdate.after(today))  
		{
			throw new InvalidLicenseException(" Renew your license ");

		}
		System.out.println("Your License Expire on ");
		return expdate;
	}

}
