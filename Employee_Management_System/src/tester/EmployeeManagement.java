package tester;

import static utils.EmployeeValidationRules.validateAllInputs;
import static utils.IOUtils.restoreEmpDetails;
//import static utils.EmployeeUtils.populateList;
import static utils.IOUtils.storeEmpDetails;
import static utils.EmployeeUtils.populateMap;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.app.Employee;

import custom_exception.EmployeeHandlingException;

public class EmployeeManagement {

	public static void main(String[] args)throws EmployeeHandlingException, ClassNotFoundException, IOException  {
		// TODO Auto-generated method stub

		try (Scanner sc = new Scanner(System.in)) {
			System.out.println(" enter the filename");
			String  filename=sc.next();
			
			Map<String, Employee> emMap=new HashMap<>();
			
			emMap=populateMap();
			storeEmpDetails(filename,emMap);
			System.out.println(" restored " );
			
			 emMap= restoreEmpDetails(filename);
			
		
		//	Map<String, Employee> em= null;
		    boolean exit=false;

		    while(!exit) {
			System.out.println("1. Hire new emp");
			System.out.println("2. List all emp details");
		
			System.out.println("3. Delete emp details");
			System.out.println("4. Sort emps as per join date n display the same.");
			
			System.out.println("0. Exit");
			System.out.println(" enter the choice ");

			try{
				switch(sc.nextInt()) {

				case 1:// add employee	
					System.out.println(" id, firstname, lastname,dept, doj");
             //(String id, String firstname, String lastname, String dept, String doj,Map<String,Employee> empMap
					Employee validEmp=validateAllInputs(sc.next(),sc.next(),sc.next(),sc.next(),sc.next(),emMap);
					emMap.put(validEmp.getId(), validEmp);
							
					System.out.println("emp details added....");
					storeEmpDetails(sc.nextLine(),emMap);
				break;
				
				case 2://List all emp details
					System.out.println(" List all emp details ");
					emMap.forEach((k,v)->System.out.println(v));
					break;
					

					
				case 3://4. Delete emp details"
					System.out.println(" enter the id to delete employee details");
					String str=sc.next();
					emMap.values().removeIf(e -> e.getId()==str);
					emMap.values().forEach(e -> System.out.println(e));
					
					break;
					
				case 4://Sort emps as per join date n display the same.
				System.out.println("enter the joining date of empolyee");
			  		emMap.values().stream()
			  		.sorted((e1,e2)->e1.getDoj().compareTo(e2.getDoj()))
                    .forEach(e-> System.out.println(e));

				case 0:
					exit=true;
					break;
		
				}
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}

			
		    }

		}

	}

}
