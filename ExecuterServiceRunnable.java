import java.util.Random;

public class ExecuterServiceRunnable implements Runnable{

	int objectNum;
	
	public ExecuterServiceRunnable(int objectNum) {
		this.objectNum = objectNum;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Random randomNums = new Random();
		System.out.println("[ExecuterServiceRunnable]" + "[" + this.objectNum + "]random numbers :: " + randomNums.nextInt());
	}
	
}
