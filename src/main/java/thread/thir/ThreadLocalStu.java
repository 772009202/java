package thread.thir;

/**
 * Created by YuChen on 2017/10/12 0012
 *
 * ThreadLocal具有数据的隔离性
 * InheritableThreadLocal:可以让子线程从父线程中获得值
 */
public class ThreadLocalStu {

	public static void main(String[] args) throws InterruptedException {
		Thread1 thread1 = new Thread1();
		thread1.start();
		Thread.sleep(3000);
		if (Store.str.get() == null) {
			Store.str.set("main");
		}
		System.out.println(Store.str.get());
	}

	static class Thread1 extends Thread {
		@Override
		public void run() {
			super.run();
			if (Store.str.get() == null) {
				Store.str.set("thread1");
			}
			System.out.println(Store.str.get());
		}
	}

	static class Store {
		volatile public static ThreadLocal<String> str = new ThreadLocal<String>();
	}

}
