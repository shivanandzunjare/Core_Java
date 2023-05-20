package utils;
import java.util.ArrayList;
import java.util.List;
import com.app.core.Customer;
import com.app.core.CustomerPlan;

import java.time.LocalDate;

import utils.CustomerValidationRules;


import custom_exception.CustomerHandlingException;
import static utils.CustomerValidationRules.validateAllInputs;

public class CustomerUtil {
	
	//static method to return populated list (hard coded data
	
	
//	            (String first_name, String last_name, String email,
//		             	double registrationAmount, LocalDate dob, CustomerPlan plan, List<Customer> cust)

	public static List<Customer> populateCust(){
		try {   //:first_name,last_name, email,reg.Amount,dob,plan)"
			ArrayList<Customer> customerlist =new ArrayList<>();  //SILVER(1000),GOLD(2000),DIAMOND(5000),PLATINUM (10000);
			
		//	:first_name,last_name, email,passward, reg.Amount,dob(dd-MM-yyyy), serviceplan)"
			customerlist.add(
					validateAllInputs("Kiran", "Seth", "kiran@gmail.com", "3456", 2000, "1989-12-20", "gold", customerlist));
			customerlist.add(
					validateAllInputs("Rama", "Kher", "rama@gmail.com", "12345", 1000, "1989-11-20", "silver", customerlist));
			customerlist.add(validateAllInputs("Shubham", "Vaidya", "shubham@gmail.com", "2345", 2000, "1997-11-21", "gold",
					customerlist));
			customerlist.add(validateAllInputs("Meera", "Savant", "meera@gmail.com", "2445", 5000, "1989-06-20", "diamond",
					customerlist));
			customerlist.add(
					validateAllInputs("Mihir", "Rao", "mihir@gmail.com", "2245", 2000, "1999-11-24", "gold", customerlist));
			customerlist.add(validateAllInputs("Kunal", "Singh", "kunal@gmail.com", "2845", 10000, "1998-01-25", "platinum",
					customerlist));
			
			
			
			
			return customerlist;
		}
		catch(Exception e) {
			e.printStackTrace();
			//System.out.println(e);
		}
		return null;
		
	}

	
}
