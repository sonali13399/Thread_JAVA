package Threading.MergeSort;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
public class MergeSorter implements Callable<List<Integer>> {

	List<Integer> toBeSorted;
	ExecutorService execService;
	public MergeSorter(List<Integer> input,ExecutorService execService) {
		this.toBeSorted=input;
		this.execService=execService;
	}
	@Override
	public List<Integer> call() throws Exception {
		// TODO Auto-generated method stub
		if(toBeSorted.size()<=1) {
			return toBeSorted;
		}
		int mid = toBeSorted.size()/2;
		List<Integer> leftInteger = new ArrayList<>();
		for(int i=0;i<mid;i++) {
			leftInteger.add(toBeSorted.get(i));
		}
		List<Integer> rightInteger = new ArrayList<>();
		for(int i=mid;i<toBeSorted.size();i++) {
			rightInteger.add(toBeSorted.get(i));
		}
		System.out.println("Printing from callable : "+Thread.currentThread().getName());
		MergeSorter left = new MergeSorter(leftInteger,execService);
		MergeSorter right = new MergeSorter(rightInteger,execService);
		
		Future<List<Integer>> futureLeft = execService.submit(left);
		Future<List<Integer>> futureRight = execService.submit(right);
		
		List<Integer> leftSorted =futureLeft.get();
		List<Integer> rightSorted = futureRight.get();
		int i = 0,j = 0;
		List<Integer> sorted = new ArrayList<>();
		while(i<leftSorted.size() && j<rightSorted.size()) {
			if(leftSorted.get(i)<rightSorted.get(j)) {
				sorted.add(leftSorted.get(i));i++;
			}else {
				sorted.add(rightSorted.get(j));j++;
			}
		}
		while(i<leftSorted.size()) {
			sorted.add(leftSorted.get(i));i++;
		}
		while(j<rightSorted.size()) {
			sorted.add(rightSorted.get(j));j++;
		}
		return sorted;
	}

}
