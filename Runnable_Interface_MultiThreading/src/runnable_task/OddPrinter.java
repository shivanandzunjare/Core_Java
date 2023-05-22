package runnable_task;

import java.util.stream.IntStream;

public class OddPrinter implements Runnable {
	private int start;
	private int end;
	
	public OddPrinter(int start, int end) {
		super();
		this.start = start;
		this.end = end;
		System.out.println(" Constr invoked by "+ Thread.currentThread().getName());
	}

	@Override
  public void run() {
		System.out.println(Thread.currentThread().getName() + " Started ");
	
		try {
			   //IntStream --range --filter--forEach
			IntStream.range(start,end)
			.filter(i-> i%2 != 0)
			.forEach(i -> System.out.println(Thread.currentThread().getName() + " printed odd number"+ i));
	
			
		}
		catch(Exception e) {
			System.out.println(Thread.currentThread().getName() + " got exc  "+ e);
		}
		System.out.println(Thread.currentThread().getName() + " over  ");
	}


}
