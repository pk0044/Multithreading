import java.util.Random;

public class ImplementRunnableInterface implements Runnable{

	@Override
	public void run() {
		Random randomNums = new Random();
		for(int i=0; i<10; i++) {
			System.out.println("[ImplementRunnableInterface] " + "random numbers :: " + randomNums.nextInt());
		}
	}

}
