package thread.thir;

/**
 * Created by YuChen on 2017/10/12 0012
 *
 * join和sleep的区别 join需要锁  ->以下一般来讲会出现3种结果 1先得锁 end和2随机地锁的概率最大
 */
public class JoinStu {

	public static void main(String[] args) throws InterruptedException {
		Thread1 thread1 = new Thread1();
		Thread2 thread2 = new Thread2(thread1);
		thread1.start();
		thread2.start();
		thread1.join(3000);
		System.out.println("------main end");
	}

	static class Thread1 extends Thread {
		@Override
		public void run() {
			super.run();
			try {
				sys();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		synchronized void sys () throws InterruptedException {
			System.out.println("------ 1开始");
			Thread.sleep(5000);
			System.out.println("-------1结束");
		}
	}

	static class Thread2 extends Thread {
		private Thread1 thread1;

		Thread2 (Thread1 thread1) {
			this.thread1 = thread1;
		}

		@Override
		public void run() {
			super.run();
			synchronized (thread1) {
				System.out.println("------2开始");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("------2结束");
			}
		}
	}
}
