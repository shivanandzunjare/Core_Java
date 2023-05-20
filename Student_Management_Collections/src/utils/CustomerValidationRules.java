package utils;

//import java.text.IllegalArgumentException;
import custom_exception.CustomerHandlingException;
import com.app.core.Customer;
import com.app.core.CustomerPlan;
import java.util.List;
import java.time.LocalDate;
import java.time.Period;
import java.text.ParseException;



public class CustomerValidationRules {

	// add static method to invoke all validation rules
	
//	(String first_name,     String last_name,     String email,     String passward,
//	double registrationAmount,                   LocalDate dob,           CustomerPlan plan

	public static Customer validateAllInputs(String first_name, String last_name, String email,String passward, 
			double registrationAmount, String dob,String  plan,  List<Customer> customerlist)
			throws CustomerHandlingException {
		
		checkForDuplicate(customerlist,email);
		CustomerPlan customerPlan=parseValidatePlanAndRegAmount(registrationAmount,plan);
		LocalDate  validDob= validateDob(dob);
		

      	return new Customer(first_name, last_name,email, passward,registrationAmount, validDob,  customerPlan);

	}
	// add static method to check for duplicate

	public static void checkForDuplicate(List<Customer> customerlist, String newEmail)
			throws CustomerHandlingException {

		Customer newcustomer = new Customer(newEmail);
		if (customerlist.contains(newcustomer))
			throw new CustomerHandlingException(" Email is duplicate ");
		System.out.println("no duplicate  email found....");

	}

	

	// add static method for customer's age validation
	public static LocalDate validateDob(String dob) throws CustomerHandlingException {
		LocalDate date = LocalDate.parse(dob);

		int ageinyears = Period.between(date,LocalDate.now()).getYears();
		
		if (ageinyears > 21)
			return date;
		throw new CustomerHandlingException(" invalid age");
	}



	public static CustomerPlan  parseValidatePlanAndRegAmount(double registrationAmount,String planname )
			 throws IllegalArgumentException, CustomerHandlingException {

	 CustomerPlan customerPlan =  CustomerPlan.valueOf(planname.toUpperCase()) ;
	 if (customerPlan.getCharges() != registrationAmount)
		 throw new CustomerHandlingException("Invalid reg amount for the chosen plan!!!!!");
		return customerPlan;
	}	 
	
	//add static method for customer login
	public static Customer customerLogin(String email,String passward, List<Customer> custList)
			throws CustomerHandlingException{
		
		int index =custList.indexOf(new Customer(email));
		if (index == -1)
			throw new CustomerHandlingException("Invalid Email , login failed!!!!");
		
		Customer validCustomer = custList.get(index);
		if(! validCustomer.getPassward().equals(passward))

			throw new CustomerHandlingException("Invalid paassswd , login failed!!!!");
		return validCustomer;
		
	
	}

}
