package Threading.HelloWorldPrinter;

public class HelloWorldPrinter implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Hello world from current class. thread name : "+Thread.currentThread().getName());
	}

}
