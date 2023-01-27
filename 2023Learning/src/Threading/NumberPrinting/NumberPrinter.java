package Threading.NumberPrinting;

public class NumberPrinter implements Runnable{

	int numToPrint;
	public NumberPrinter(int num) {
		this.numToPrint=num;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(numToPrint+" "+Thread.currentThread().getName());
	}

		
}
