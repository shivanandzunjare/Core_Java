package utils;

import static com.app.Subject.DBT;
import static com.app.Subject.JAVA;
import static java.time.LocalDate.parse;
import static utils.StudentValidationRules.validateAllInputs;
import static utils.StudentValidationRules.parseAndvalidateSubject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.app.Student;

import custom_exception.StudentHandlingException;

public class StudentCollectionUtils {
	
//roll_no, String firstname, String lastname, LocalDate dob, Subject sub, int gpa, 
	
	
	public static Map<Integer, Student> populateMap() throws StudentHandlingException
	{
		Map<Integer,Student> stuMap=new HashMap<>();
		
		stuMap.put(11,validateAllInputs(11,"Shubham"," Kamble","1998-10-08","JAVA",8.2,stuMap));
		stuMap.put(12,validateAllInputs (12,"Shiva"," Zunjare","2000-01-01","DBT",7.9 ,stuMap ));
		stuMap.put(13,validateAllInputs (13,"Abhi"," Pujari","2000-04-02","REACT",9.6 ,stuMap ));
		stuMap.put(14,validateAllInputs (14,"Shirish"," Tambade","1998-11-11","DSA",8.9 ,stuMap ));
		stuMap.put(15,validateAllInputs (15,"Rohit"," Narvade","1996-10-10","OS",9.2 ,stuMap ));
		
	
		return stuMap;
	}
	 
	
	
}
