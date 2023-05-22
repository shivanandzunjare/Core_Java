package thrd_unsafe_coll;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ThreadUnsafeCollections {
	public static void main(String[] args) throws Exception {
		//modern API are thread unsafe
		List<Integer> list = new ArrayList<>(100);//indirect reference 
		IntStream.range(1, 10001).forEach(list::add);//method reference //i-> list.add(i)
		// Thread(Runnable instance,String name)
		
		Thread reader = new Thread(() -> {   //begining 
			synchronized (list) {
				list.forEach(i -> System.out.println("r " + i));// forEach : for-each : implicit Iterator(fail-fast)
			
			}
		}, "t1");
	//--->	//only one runnable instance 
		Thread writer = new Thread(() -> {
			synchronized (list) {
				IntStream.range(101, 201).forEach(list::add);
			}
			
		}, "t2");
		reader.start();//
		Thread.sleep(10);
		writer.start();
		reader.join();
		writer.join();
		System.out.println("main over...");
	}
}