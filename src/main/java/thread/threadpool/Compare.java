package thread.threadpool;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by YuChen on 2017/12/13 0013
 * 使用线程池效率要好点 这个
 */
public class Compare {

	static class PoolExecutor {
		public void sys(Integer count) {
			long startTime = System.currentTimeMillis();
			final List<Integer> list = new LinkedList<Integer>();
			ThreadPoolExecutor tp = new ThreadPoolExecutor(1, 1,
					60, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(count));
			final Random random = new Random();

			synchronized (count) {
				for (int i=0; i< count; i++){
					tp.execute(() ->{
						list.add(random.nextInt());
					});
				}
				tp.shutdown();
				try {
					tp.awaitTermination(1, TimeUnit.DAYS);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			System.out.println(System.currentTimeMillis() - startTime);
			System.out.println(list.size());
		}
	}

	static class NotPoolExecutor {

		public void sys (Integer count) {
			long startTime = System.currentTimeMillis();
			final List<Integer> list = new LinkedList<Integer>();
			final Random random = new Random();

			synchronized (count) {
				for (int i=0; i<count; i++) {
					Thread t1 = new Thread(() -> {
						list.add(random.nextInt());
					});
					t1.start();
					try {
						t1.join();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}

			System.out.println(System.currentTimeMillis() - startTime);
			System.out.println(list.size());
		}
	}

	public static void main(String[] args) {
	 	NotPoolExecutor t1 = new NotPoolExecutor();
	 	PoolExecutor t2 = new PoolExecutor();
	 	Integer num = 10;
	 	t1.sys(num); // 75 10
	 	t2.sys(num); // 5 10
	}
}
