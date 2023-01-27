package Threading.Executor;

public class NumberPrinter implements Runnable {
	int numToPrint;
	public NumberPrinter(int num) {
		this.numToPrint=num;
	}
	
	@Override
	public void run() {
		System.out.println(numToPrint+"Printing from runnable. Thread name : "+Thread.currentThread().getName());
	}
}
