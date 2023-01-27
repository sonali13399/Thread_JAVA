package Threading.Executor;

import java.util.concurrent.Callable;

public class NumberPrinterCall implements Callable {

	int numToPrint;
	public NumberPrinterCall(int num) {
		this.numToPrint=num;
	}
	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		String s = numToPrint+"Thread from callable. Thread name : "+Thread.currentThread().getName();
		return s;
	}

}
