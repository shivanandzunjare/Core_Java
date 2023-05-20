package tester;

import java.time.LocalDate;

import com.app.core.Color;
import com.app.core.Vehicle;

public class TestEquals2 {

	public static void main(String[] args) {
	
		// Equal method 
		// ( chasisNo,vehicleColor, basePrice,manufactureDate,company")
				Object  v1 =new Vehicle("adc-123",Color.BLACK,10000.00,LocalDate.parse("2023-02-02"),"Tata");
				Object v2 =new Vehicle("adc-123",Color.BLACK,10000.00,LocalDate.parse("2023-02-02"),"Tata");
				
		System.out.println(v1.equals(v2)); //t //here equality of PID(PK) with chasisNo
				//reference equaity replace with Promary Key i.e ChasisNO
		
		System.out.println(v1==v2);  //f  
		System.out.println(v1.hashCode()  + " "+ v2.hashCode());


	}

}
