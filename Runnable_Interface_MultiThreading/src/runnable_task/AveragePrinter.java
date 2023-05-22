package runnable_task;

import java.util.stream.IntStream;
            //Runnable   Interface 
public class AveragePrinter implements Runnable {
	private int start;
	private int end;
	
	public AveragePrinter(int start, int end) {
		super();
		this.start = start;
		this.end = end;
		System.out.println(" Constr invoked by "+ Thread.currentThread().getName());//main thread 5-> priority , main group name  
	}


	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " Started ");
	
		try {
		// Instream ---- range----- average----orElseThrow
			double avg =IntStream.range(start, end)
					.average()
					.orElseThrow();//return the value or throws NoSuchException
					
		System.out.println(" Average of range "+ avg+" printed by " + Thread.currentThread().getName() );

		}
		catch(Exception e) {
			System.out.println(Thread.currentThread().getName() + " got exc  "+ e);
		}
		System.out.println(Thread.currentThread().getName() + " over  ");
	}


}
