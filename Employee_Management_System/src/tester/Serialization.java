//package tester;
//
//import static utils.EmployeeUtils.populateList;
//import static utils.IOUtils.storeEmpDetails;
//import java.util.Map;
//import java.util.Scanner;
//
//import com.app.Employee;
//
//public class Serialization {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		
//		try(Scanner sc=new Scanner(System.in))
//		{
//			Map<String,Employee> empMap=populateList();
//			System.out.println("Enter the file name");
//			storeEmpDetails(sc.nextLine(),empMap);
//			System.out.println(" Employee details stored !!!");
//			
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
//		System.out.println(" main function over  ::");
//
//	}
//
//}
