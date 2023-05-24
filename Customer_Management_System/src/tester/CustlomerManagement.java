package tester;

import static utils.CustomerUtils.populateMap;
import static utils.CustomerValidationRules.validateAllInputs;
import static utils.IOUtils.restoreCustDetails;
import static utils.IOUtils.storeCustDetails;
import static utils.CustomerValidationRules.customerLogin;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.app.Customer;

import custom_exception.CustomerHandlingException;

public class CustlomerManagement {

	public static void main(String[] args) throws FileNotFoundException, IOException, CustomerHandlingException, ClassNotFoundException {
		// TODO Auto-generated method stub
		try(Scanner sc=new Scanner(System.in))
		{
			System.out.println(" enter the filename ");
			String filename=sc.next();
			int ch = 0;
			
			Map<Integer,Customer> custMap=new HashMap<>();
			custMap =populateMap();
				
				
			storeCustDetails(filename,custMap);
			
			System.out.println(" customer details are stored " );
			custMap=restoreCustDetails(filename);
			boolean exit=false;
			
			while(!exit)
			{	System.out.println("1.Sign Up            2. Sign In       3.Display All ");
			System.out.println("4.Change Passward    5.sorting acsending as per email");
			System.out.println(" 6..sort as per dob   ");
				
				System.out.println(" enter your choice :");
				try {
					
					switch(sc.nextInt()) {
					// id, String firstname, String lastname, String email, String passward, LocalDate dob
					case 1: //  sign up
						System.out.println("  enter the customer details : id,    firstname,  lastname,  email, passward,  dob plan");
						Customer validCustomer=validateAllInputs(sc.nextInt(),sc.next(),sc.next(),
								sc.next(),sc.next(),sc.next(),sc.next(),custMap);
						custMap.put(validCustomer.getId(), validCustomer);
						
						System.out.println(" customer is registed  ");
						break;
						
						
					case 2://  sign in
						System.out.println(" enter the id and passward");
						validCustomer=customerLogin(sc.nextInt(),sc.next(),custMap);
						System.out.println(validCustomer);
						
					break;
					
					case 3://  display
						System.out.println(" show all details ");
						custMap.forEach((k,v)->System.out.println(v));
						break;
						
					case 4://  change passward
				System.out.println(" enter the id  old passwd new paawd");
						validCustomer=customerLogin(sc.nextInt(),sc.next(),custMap);
								validCustomer.setPassward(sc.next());
								System.out.println(" new passward have set");
						break;
						
						
					case 5: //sorting acsending as per email
						
						System.out.println(" -------");
						System.out.println(" after the sorting as per email");
						custMap.values()
						.stream()
						.sorted((c1,c2)->c1.getEmail().compareTo(c2.getEmail()))
						.forEach(s->System.out.println(s));		

						break;
						
					case 6://.sort as per dob 
						System.out.println(" after the sorting as per dob ");
						custMap.values().stream().sorted((c1,c2)->c1.getDob().compareTo(c2.getDob()))
						.forEach(c-> System.out.println(c));
						break;
												
					case 0:
						exit=true;
						break;				
					}
					
				}
				catch(Exception e) {
					e.printStackTrace();
					sc.nextLine();
				}										
			}
		}

	}
}
