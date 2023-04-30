package speed;

import java.util.Scanner;
import  static util.Validate.validateSpeed;
public class TestException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try(Scanner sc=new Scanner(System.in)) {  //Here we throw the Exception
	//	Scanner sc=new Scanner(System.in);
		
		System.out.println("enter your speed");
		validateSpeed(sc.nextInt());             //Function call for validateSpeed
		System.out.println("end of try block ");
		
		}
		catch(SpeedOutOfRangeException s)  //catch block for SpeedOutOfRangeException
		{
			//System.out.println(s);
			
			//System.out.println(s.getMessage());
			s.printStackTrace();
			System.out.println(" End  main Function....");
		}
		
		

	}

}
