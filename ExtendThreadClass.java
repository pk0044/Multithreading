import java.util.Random;

public class ExtendThreadClass extends Thread{

	@Override
	public void run() {
		Random randomNum = new Random();
		for(int i=0; i<10; i++) {
			System.out.println("[ExtendThreadClass] random numbers :: " + randomNum.nextInt());
		}
	}
	
}
