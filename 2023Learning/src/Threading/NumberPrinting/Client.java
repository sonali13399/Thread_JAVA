package Threading.NumberPrinting;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Number Printer");
		
		for(int i=1;i<=100;i++) {
			NumberPrinter np = new NumberPrinter(i);
			Thread t = new Thread(np);
			t.start(); //uses 100 diff thread for execution//executes randomly not sequential order
//			t.run(); -- uses main thread for all 100
		}
	}

}
