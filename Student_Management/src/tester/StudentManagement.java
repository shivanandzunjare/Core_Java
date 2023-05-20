package tester;

import static utils.IOUtils.restoreStuDetails;
import static utils.IOUtils.storeStuDetails;
import static utils.StudentCollectionUtils.populateMap;
import static utils.StudentValidationRules.validateAllInputs;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.app.Student;
import com.app.Subject;

import custom_exception.StudentHandlingException;

public class StudentManagement {

	public static void main(String[] args) throws FileNotFoundException, IOException, StudentHandlingException {
		System.out.println("------------");
		try(Scanner sc=new Scanner(System.in)){
			
			System.out.println(" enter the file name");
			String filename=sc.next();
			int ch=0;
			Map<Integer,Student> stuMap=new HashMap<>();
		
//			stuMap= populateMap();
//			storeStuDetails(filename,stuMap);
//			System.out.println(" students details are stored ");
			
			stuMap=restoreStuDetails(filename);
			
			boolean exit=false;
			
			while(!exit) {
				System.out.println("1. Add Students ");
				System.out.println("2. show students");
				System.out.println("3. Delete emp details as per dob");
				System.out.println("4. sort as per dob   ");
				System.out.println("5. Sort asecnding  as per gpa ");
				System.out.println(" enter your choice");
				
				try {
				switch(sc.nextInt()) {
				
				case 1://Add student
					////roll_no, String firstname, String lastname, LocalDate dob, Subject sub, int gpa )
					System.out.println( " roll_no, Strin firstname,lastname,dob, subject, gpa, " );
            Student validStudent=validateAllInputs(sc.nextInt(),sc.next(),sc.next(),sc.next(),
            		sc.next(),sc.nextDouble(),stuMap);
				stuMap.put(validStudent.getRoll_no(),validStudent);
				
				System.out.println(" student is added ");
				break;
				
				case 2:// show students
					System.out.println("  show all  students Details");
					stuMap.forEach((k,v)->System.out.println(v));
				
					break;
					
				case 3:// delete  as per dob
					
					System.out.println(" enter the dob to delete ");
					LocalDate date =LocalDate.parse(sc.next());
					stuMap.values().removeIf(e->e.getDob().equals(date));
					System.out.println(" after the deletion list is ---");
					stuMap.forEach((k,v)->System.out.println(v));
					
					break;
				case 4:// sort as per dob
					System.out.println(" sorted as per dob ");
					stuMap.values().stream()
					.sorted((s1,s2)->s1.getDob().compareTo(s2.getDob()))
					.forEach((s->System.out.println(s)));
					break;
					
					case 5://ascen as per gpa
						System.out.println("  sorted  as per gpa ");
						stuMap.values().stream()
						.sorted((s1,s2)->((Double)s1.getGpa()).compareTo(s2.getGpa()))
						.forEach(s->System.out.println(s));
						
						break;	
				case 0:
					
					exit=true;
					break;
			
				}
				
				}catch(Exception e) {
					e.printStackTrace();
				}
				
			}
				
		}

	}

}
