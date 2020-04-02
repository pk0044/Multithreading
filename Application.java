import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Application {

	public static void main(String[] args) {
		ExtendThreadClass threadUsingThread = new ExtendThreadClass();
		// spawning new thread using a class which extends thread class
		threadUsingThread.start();
		
		//  spawning other thread using a class which implements Runnable Interfce
		Thread th = new Thread(new ImplementRunnableInterface());
		th.start();
		
		// Executer Servive with runnable interface
		ExecutorService es = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		System.out.println("[Application] Number of cores :: " + Runtime.getRuntime().availableProcessors());
		for(int i=0; i<10; i++) {
			ExecuterServiceRunnable task = new ExecuterServiceRunnable(i);
			es.execute(task);
		}
		
		es.shutdown();
		
		// Executor service with Callable interface
		ExecutorService es1 = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		List<Future> futureList = new ArrayList<Future>();
		for(int i=0; i<10; i++) {
			Future<Integer> future = es1.submit(new ExecutorServceCallableInterface(i));
			futureList.add(future);
		}
		
		for(int i=0; i<10; i++) {
			try {
				System.out.println("[Application][ExecutorServceCallableInterface] return value :: " + futureList.get(i).get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
		
		es1.shutdown();
		
		// main thread of execution
		Random randomNums = new Random();
		for(int i=0; i<10; i++) {
			System.out.println("[Application] random nums :: " + randomNums.nextInt());
		}
		
	}

}
