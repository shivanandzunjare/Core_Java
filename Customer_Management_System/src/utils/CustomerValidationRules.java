package utils;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Map;

import com.app.Customer;
import com.app.CustomerPlan;

import custom_exception.CustomerHandlingException;
import custom_exception.CustomerHandlingException;

public class CustomerValidationRules {
	
	private static final int id = 0;


	public static Customer validateAllInputs(int id, String firstname, String lastname, String email, String passward, String dob,
			String plan,Map<Integer,Customer> custMap) throws CustomerHandlingException {
		
		LocalDate date= parseAndValidateDate(dob);
		CustomerPlan plnm=parseAndValidatePlan(plan);
		checkForValidate(custMap,id);
		
		return new Customer(id, firstname,  lastname, email, passward, date,plnm);
	}
	
	public static void checkForValidate(Map<Integer,Customer> custMap,int id)throws CustomerHandlingException 
	{
		if(custMap.containsKey(id))
			throw new CustomerHandlingException (" duplicate id here !!!!!!!!!!!1111");
		
	}
	
	// static method for parse validate date 
	public static LocalDate parseAndValidateDate(String date) throws CustomerHandlingException  
	{
		LocalDate dob=LocalDate.parse(date);
		int ageInYears=Period.between(dob, LocalDate.now()).getYears();
		
		//also check age for givaen date 
		if(ageInYears < 18 )
			throw new CustomerHandlingException(" not allowed !!!!!!");
		return dob;
	}
	
	//static method for validate  customer plans 
	public static CustomerPlan parseAndValidatePlan(String plnm)
	{
		return CustomerPlan.valueOf(plnm.toUpperCase());
	}
	
	
	@SuppressWarnings({ "unchecked", "unlikely-arg-type" })
	public static Customer customerLogin(int id,String passward, Map<Integer,Customer> custMap)
			throws CustomerHandlingException {
		

		if(custMap.containsKey(id)) 
			
			custMap.get(id);
			
		Customer validCustomer=custMap.get(id);
			
			if(!validCustomer.getPassward().equals(passward)) 

		
			throw new CustomerHandlingException("invalid pasward login falied");		
		
		return validCustomer ;
	}
	
}
