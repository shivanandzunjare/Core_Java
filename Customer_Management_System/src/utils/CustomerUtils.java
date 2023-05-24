package utils;
import static utils.CustomerValidationRules.validateAllInputs;
import java.util.HashMap;
import java.util.Map;

import com.app.Customer;
import com.app.CustomerPlan;

import custom_exception.CustomerHandlingException;

public class CustomerUtils {
	
	public static Map<Integer,Customer> populateMap() throws CustomerHandlingException
	{
		//int id, String firstname, String lastname, String email, String passward, LocalDate dob,
//		CustomerPlan plan) {
		Map<Integer,Customer> custMap=new HashMap<>();
		
		custMap.put( 1, validateAllInputs(1,"Shiva","Zunjare","shiva@gmail.com","sz@1","2000-01-01","gold",custMap));
		custMap.put( 2, validateAllInputs(2,"shirish","patil","s@gmail.com","sp@2","1996-10-15","SILVER",custMap));
		custMap.put( 3, validateAllInputs(3,"Abhi","Pujari","a@gmail.com","ap@3","2000-09-01","PLATINUM",custMap));
		custMap.put( 4, validateAllInputs(4,"Shubham","Kamble","sk@gmail.com","sk@4","1998-01-01","gold",custMap));
		custMap.put( 5, validateAllInputs(5,"Anish","Raccha","ar@gmail.com","ar@5","2000-05-10","GOLD",custMap));
		
		
		return custMap;
	}

}
