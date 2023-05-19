package utils;
import java.time.LocalDate;
import java.time.Period;
import java.util.Map;

import com.app.Departments;
import com.app.Employee;

import custom_exception.EmployeeHandlingException;
public class EmployeeValidationRules {
	
	 //Company is only 3 years old. (so think of a validation rule on joining date)
	
	public static Employee validateAllInputs(String id, String firstname, String lastname, String dept, String doj,Map<String,Employee> empMap)throws EmployeeHandlingException {
		
		 Departments deptnm=parseAndValidateDepartment(dept);
		 checkForDuplicate(empMap,id);
		 LocalDate date=validateDate(doj);
		 
		return new Employee (id ,  firstname,  lastname,deptnm,date);
	}
	
	public static String  checkForDuplicate(Map<String, Employee> emps,String id) throws  EmployeeHandlingException 
	{
	
		if(emps.containsKey(id))
			throw new  EmployeeHandlingException(" duplicate empid!!!!!!!!!!");
				return id;
			}
	

	
	public static LocalDate validateDate(String date) throws EmployeeHandlingException 
	{
	
		LocalDate joindate=LocalDate.parse(date);
		int time=Period.between(joindate, LocalDate.now()).getYears();
		if(time <3)
			return ( joindate );
		throw new  EmployeeHandlingException(" company is more than 3 years old !!!!!");
	}
	
	
		public static Departments parseAndValidateDepartment(String deptnm)throws EmployeeHandlingException
		{
			return Departments.valueOf(deptnm.toUpperCase());
		}
	

}
