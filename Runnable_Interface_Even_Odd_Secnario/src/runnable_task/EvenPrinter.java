package runnable_task;

import java.util.stream.IntStream;
                    //Runnable Interface
public class EvenPrinter implements Runnable {
	
	private int start;
	private int end;
	
	public EvenPrinter(int start, int end) {
		super();
		this.start = start;
		this.end = end;
		System.out.println(" Constr invoked by "+ Thread.currentThread().getName());
	}


	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " Started ");
	
		try {
			//Instream----range-----Filter-----ForEach
			IntStream.range(start,end)
			.filter(i-> i%2 == 0)
			.forEach(i -> System.out.println(Thread.currentThread().getName() + " printed even number"+ i));
		}
		catch(Exception e) {
			System.out.println(Thread.currentThread().getName() + " got exc  "+ e);
		}
		System.out.println(Thread.currentThread().getName() + " over  ");
	}

}
