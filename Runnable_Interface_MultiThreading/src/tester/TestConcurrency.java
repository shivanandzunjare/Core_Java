package tester;
import java.util.Scanner;
//
import runnable_task.AveragePrinter;
import runnable_task.EvenPrinter;
import runnable_task.OddPrinter;

public class TestConcurrency {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try(Scanner sc=new Scanner(System.in)){
			
			System.out.println(" enter the range : begin and end ");
			int start =sc.nextInt();
			int end=sc.nextInt();
			//create task and attach thread to task and start thread 
			//imple Runnable Thread (Runnable task, String nm)
			
			Thread t1=new Thread(new EvenPrinter(start,end)," Even ");
			Thread t2=new Thread(new OddPrinter(start,end), "odd ");	
			Thread t3=new Thread(new AveragePrinter(start,end));
			//Start the thread 
			t1.start();
			t2.start();
			t3.start();
			System.out.println(" main waiting for child threads to compllete  excu");	
			t1.join();
			t2.join();
			t3.join();
	}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println(" main over  ");

}
}
