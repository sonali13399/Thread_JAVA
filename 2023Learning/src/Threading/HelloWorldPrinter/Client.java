package Threading.HelloWorldPrinter;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HelloWorldPrinter hwp = new HelloWorldPrinter();
		Thread t1 = new Thread(hwp);
		t1.run();
		t1.start();

		Thread t2 = new Thread(hwp);
		t2.run();
		t2.start();
		
		//t1.start() && t2.start() --> multithreading
	}

}
