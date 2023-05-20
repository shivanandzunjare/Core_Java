package tester;
import java.util.Scanner;
import com.app.core.Customer;
import com.app.core.CustomerPlan;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Comparator;
import java.util.Collections;
import java.time.LocalDate;
//import custom_ordering.CustomerEmailComparator;

//import static utils.CustomerUtil.populateCust;
import utils.CustomerValidationRules.*;
import static utils.CustomerValidationRules.validateAllInputs;
import static utils.CustomerValidationRules.customerLogin;
import custom_exception.CustomerHandlingException;

import static utils.CustomerUtil.populateCust;

public class TestCustomerManagement {

	public static void main(String[] args) throws CustomerHandlingException {
		// TODO Auto-generated method stub
		
		try(Scanner sc=new Scanner(System.in)){
			
			//Customer [] cust =new Customer [sc.nextInt()];
			List<Customer> customerlist=populateCust();
		// List<Customer> customerlist=new ArrayList<>();
			boolean exit=false;
			
			while(!exit) {
			
				System.out.println("1.Sign Up            2. Sign In       3.Display All ");
				System.out.println("4.Change Passward    5.unsubscribe customer");
				System.out.println(" 6.ascending order as per email  7.sort as per dob and reg amount  ");
				System.out.println("0.exit");
				System.out.println("enter the option ");
				try {
				switch(sc.nextInt()) {
				
				case 1:  //sign up
					System.out.println("enter the customer :first_name,last_name, email,passward, reg.Amount,dob(yyyy-mm-dd), serviceplan)");

						
				Customer validCustomer=validateAllInputs(sc.next(),sc.next(),sc.next(),sc.next(),sc.nextDouble(),sc.next(),sc.next(),customerlist);
				customerlist.add(validCustomer);
				System.out.println(" customer registered");
				
				break;
				
				case 2:  //sign in 
					System.out.println("enter the email and passward");
					validCustomer =customerLogin(sc.next(),sc.next(),customerlist);
					//search cust by email
					System.out.println(validCustomer);
					System.out.println(" sign up !!!!!!!");
                     break;

				case 3:// show all details
					System.out.println(" customer details");
//					for (Customer c : customerlist )
//						System.out.println(c);
					customerlist.forEach(p-> System.out.println(p));
					break;
					
					
				case 4://change passward
					System.out.println("enter the email , old passward and new passward");
					validCustomer= customerLogin(sc.next(),sc.next(),customerlist);
				
					validCustomer.setPassward(sc.next());
					break;
					
				case 5://unsubscribe customer
					System.out.println("enter the email");
					int index=customerlist.indexOf(new Customer(sc.next()));
					if(index ==-1)
						throw new CustomerHandlingException(" customer not found ");
					System.out.println("removed "+ customerlist.remove(index));
					
					break;
				case 6://ascending order as per email
				Collections.sort(customerlist);
				System.out.println(" after the sorting by email customer details are ");
				customerlist.forEach(p-> System.out.println(p));
				
				break;
				case 7:  //sort as per dob and reg amount
					Collections.sort(customerlist,new Comparator<Customer>() {
						@Override
						public int compare(Customer c1, Customer c2) {
							int retVal=c1.getDob().compareTo(c2.getDob());
							
							if (retVal ==0 ) {
//								if(c1.getRegistrationAmount()< c2.getRegistrationAmount() )
//									return -1;
//								if(c1.getRegistrationAmount() == c2.getRegistrationAmount() )
//									return 0;
//								return 1;
								
								// we can use compareTo on primitive data type using Wrapper class
							((Double)c1.getRegistrationAmount()).compareTo(c1.getRegistrationAmount());
							}
							return retVal;
						}
					});
					System.out.println(" after the sorting by sort as per dob and reg amount customer details are ");
					customerlist.forEach(p-> System.out.println(p));
					
					break;
				case 0:
					exit =true;
					break;
				
				}
				
			}
			catch(Exception e) {
			e.printStackTrace();
			sc.nextLine();
			}
					
		}//sc.close()
		
	}


	
}

}
