package utils;

import static utils.EmployeeValidationRules.validateAllInputs;


import java.util.HashMap;
import java.util.Map;
import static utils.EmployeeUtils.populateMap;
import com.app.Employee;

import custom_exception.EmployeeHandlingException;
public class EmployeeUtils {

              //Emp details : id(string), first name , last name , 
	//dept(enum : RND,HR,SALES,FINANCE,PRODUCTION), joining date(LocalDate)
	
	public static Map<String, Employee> populateMap() throws EmployeeHandlingException{
		Map<String ,Employee> empMap=new HashMap<>();
		empMap.put("abc",validateAllInputs("abc"," Shiva","Zunjare","RND","2023-05-05",empMap));
		
		empMap.put("def",validateAllInputs("def","Shubham"," Kamble","RND","2022-08-11",empMap));
		
		empMap.put("klm",validateAllInputs ("klm","Abhi"," Pujari","PRODUCTION","2021-06-25",empMap ));
		empMap.put("pqr",validateAllInputs ("pqr","Shirish"," Tambade","FINANCE","2023-11-11",empMap ));
		empMap.put("xyz",validateAllInputs ("xyz","Rohit"," Narvade","FINANCE","2021-10-10",empMap ));
		return empMap;
	}

}
