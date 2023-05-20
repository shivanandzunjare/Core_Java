package utils;

import java.time.LocalDate;
import java.time.Period;
import java.util.Map;

import com.app.Student;
import com.app.Subject;

import custom_exception.StudentHandlingException;
public class StudentValidationRules {
	//roll_no, String firstname, String lastname, LocalDate dob, Subject sub, int gpa )
	
	
	//static method for validating all inputs
	public static Student validateAllInputs( int roll_no, String firstname, String lastname, 
			String dob, String  sub, double gpa ,Map<Integer,Student> stuMap ) throws StudentHandlingException {
		
		LocalDate date= parseAndValidateDob(dob);
		
		Subject subname=parseAndvalidateSubject(sub);
		
		return new Student( roll_no, firstname,lastname, date,  subname,  gpa );
	}
	
	//static method for validate dob parsing 
	public static LocalDate parseAndValidateDob(String  date) throws StudentHandlingException {
		LocalDate dob=LocalDate.parse(date);
		
		int ageInYears=Period.between(dob,LocalDate.now()).getYears();
		
		if (ageInYears < 30 && ageInYears > 22)
			return dob;
		throw new StudentHandlingException(" your are not applicable for CDAC XXX");
		
	}
	
	//add static method for check vaidate subject
	public static Subject parseAndvalidateSubject( String subname) throws StudentHandlingException {
		return Subject.valueOf(subname.toUpperCase());
		
	}


}
