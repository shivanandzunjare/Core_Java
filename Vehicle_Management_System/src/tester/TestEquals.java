package tester;
import com.app.core.*;
import java.time.LocalDate;
public class TestEquals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// ( chasisNo,vehicleColor, basePrice,manufactureDate,company")
		Vehicle v1 =new Vehicle("adc-123",Color.BLACK,10000.00,LocalDate.parse("2023-02-02"),"Tata");
		Vehicle v2 =new Vehicle("adc-123",Color.BLACK,10000.00,LocalDate.parse("2023-02-02"),"Tata");
		
		System.out.println(v1.equals(v2));  //f  //due to reference equality
		System.out.println(v1==v2);  //f  
		System.out.println(v1.hashCode()  + " "+ v2.hashCode());

	}

}
