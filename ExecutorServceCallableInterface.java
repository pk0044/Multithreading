import java.util.concurrent.Callable;

public class ExecutorServceCallableInterface implements Callable<Integer>{
	int objectNum;
	public ExecutorServceCallableInterface(int objectNum) {
		this.objectNum = objectNum;
	}
	@Override
	public Integer call() throws Exception {
		Thread.sleep(1000);
		System.out.println("[ExecutorServceCallableInterface][" + this.objectNum + "] object number :: " + this.objectNum);
		return objectNum * 2;
	}
	
}
