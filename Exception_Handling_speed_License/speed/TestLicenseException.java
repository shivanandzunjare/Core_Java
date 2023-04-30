package speed;
import java.util.Scanner;
import static util.Validate.*;
public class TestLicenseException {
	
	public static void main(String [] args) throws SpeedOutOfRangeException,InvalidLicenseException  {
		
		try(Scanner sc=new Scanner(System.in))
		{
			System.out.println("enter the current speed");
			validateSpeed(sc.nextInt());
			System.out.println("------------------");
			System.out.println("enter the expiry date of your Driving License: dd-MM-yyyy");
			
			System.out.println( checkLic(sc.next()));   //Here we throw exception to check DrivingLicense
			//checklic(sc.next());
			
			System.out.println("end of try Block  ");
		}
				
		catch(Exception e) {                      //Catch block for Exception
			System.out.println(e.getMessage());
			System.out.println(" End Of Main Function  ");
		}
		
	}

}
