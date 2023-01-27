package Threading.Executor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		/*
		ExecutorService es = Executors.newFixedThreadPool(10);
		
		for(int i=0;i<1000;i++) {
			NumberPrinter np = new NumberPrinter(i);
			es.submit(np);
		} 
		es.shutdown();// not sequential execution of threads 
//		*/
		
		ExecutorService esForCall = Executors.newCachedThreadPool();
		List<Future<String>> futureOutput = new ArrayList<Future<String>>();
		for(int i=0;i<100;i++) {
			NumberPrinterCall npc = new NumberPrinterCall(i);
			Future<String> future = esForCall.submit(npc);
			futureOutput.add(future);
		}

		//futureOutput printing
		for(int i=0;i<futureOutput.size();i++) {
			Future<String> op = futureOutput.get(i);
			String res = op.get();
			System.out.println("Printing from main: "+res);
		} // this gives the output in sequential manner
	}

}
