package Threading.MergeSort;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		System.out.println("MERGE SORT");
		List<Integer> input = List.of(1,4,3,9,5,2,0);
		ExecutorService execService =Executors.newCachedThreadPool();
		MergeSorter m1=new MergeSorter(input,execService);
		Future<List<Integer>> future = execService.submit(m1);
		List<Integer> result = future.get();
		System.out.println(result);
		execService.shutdown();
	}

}
