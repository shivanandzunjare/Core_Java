package utils;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.app.core.Color;
import com.app.core.Vehicle;

import custom_exception.VehicleHandlingException;

public class ValidationRules {
	
	//static method for validating all inputs parameter
	public static Vehicle validateAllInputs(String chasisNo, String vehicleColor, double basePrice, String manufactureDate, String company,List<Vehicle> vehicles )throws VehicleHandlingException{
		
		checkForDuplicate(chasisNo,vehicles);
		
		Color clr=parseAndValidateColor(vehicleColor);
		
		double netprice=basePrice + clr.getColorCost();
		
		LocalDate validDate=parseAndValidateDate(manufactureDate);
		return new Vehicle(chasisNo,clr,netprice,validDate,company);
	}
	
	//static method for validating enum color 
	public static Color parseAndValidateColor(String clr) {
		return Color.valueOf(clr.toUpperCase());
	}
	
	//static method for parsing date and date is only from starting of year
	public static LocalDate parseAndValidateDate(String date)throws VehicleHandlingException{
		LocalDate d1=LocalDate.parse(date);
		LocalDate beginyear=LocalDate.of(LocalDate.now().getYear(),1,1);
		if(d1.isAfter(beginyear))
			return d1;
	       throw new VehicleHandlingException("\"Vehicle manufacture date must be after 1st Jan of the curnt year\" ");
	}
	
	
	////static method for checking duplicate vehicle using chasisNo
	public static void checkForDuplicate(String newchasisNo, List<Vehicle> vehicles) throws VehicleHandlingException{
		Vehicle newVehicle=new Vehicle(newchasisNo);
				for (Vehicle v: vehicles)
					if(v!=null)
						if(v.equals(newchasisNo))
							throw new VehicleHandlingException(" duplicate chasisNo");
		System.out.println("NO duplicate chasis no");
	}
	

}
