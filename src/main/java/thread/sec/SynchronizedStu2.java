package thread.sec;

/**
 * Created by YuChen on 2017/10/9 0009
 * synchronized同步块 一半异步一半同步
 */
public class SynchronizedStu2 {

	public static void main(String[] args) {
	 	MyObject2 myObject = new MyObject2();
	 	Thread1 thread1 = new Thread1(myObject);
	 	Thread2 thread2 = new Thread2(myObject);
	 	thread1.start();
	 	thread2.start();
	}

	static class MyObject2 {
		void sys() {
			System.out.println("task begin" + Thread.currentThread().getName());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			/**
			 * 同步块的优势
			 * 但是上锁的同步块和同步方法依旧将被上锁
			 *
			 * 同步快若锁的是实例变量和参数由于监视的对象的不同 另一线程调用syn同步方法会形成异步
			 */
			synchronized (this) {
				System.out.println("task 执行中" + Thread.currentThread().getName());
			}

			System.out.println("task 执行完毕" + Thread.currentThread().getName());
		}
	}
	static class Thread1 extends Thread {
		private MyObject2 myObject;
		Thread1 (MyObject2 myObject) {
			this.myObject = myObject;
		}

		@Override
		public void run() {
			super.run();
			myObject.sys();
		}
	}

	static class Thread2 extends Thread {
		private MyObject2 myObject;
		Thread2 (MyObject2 myObject) {
			this.myObject = myObject;
		}

		@Override
		public void run() {
			super.run();
			myObject.sys();
		}
	}
}



