package thread.thir;

/**
 * Created by YuChen on 2017/10/11 0011
 * 生产者和消费者模式 -> 由notify和wait衍生而来的
 */
public class PandC {

	public static void main(String[] args) {
		String str = new String("flag");
		Thread1 thread1 = new Thread1(new P(str));
		Thread2 thread2 = new Thread2(new C(str));
		thread1.start();
		thread2.start();
	}
	static class Thread1 extends Thread {
		private P p;
		Thread1 (P p) {
			this.p = p;
		}

		@Override
		public void run() {
			super.run();
			try {
				while (true) {
					p.change();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	static class Thread2 extends Thread {
		private C c;
		Thread2 (C c) {
			this.c = c;
		}

		@Override
		public void run() {
			super.run();
			try {
				while (true) {
					c.change();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 生产者
	 */
	static class P {
		private String lock;
		P (String string) {
			this.lock = string;
		}

		void change () throws InterruptedException {
			synchronized (lock) {
				if (!R.value.equals("")) {
					lock.wait();
				}

				R.value = Thread.currentThread().getName() + " " + System.currentTimeMillis();
				System.out.println(R.value);
				lock.notify();
			}
		}
	}

	/**
	 * 消费者
	 */
	static class C {
		private String lock;
		C (String string) {
			this.lock = string;
		}

		void change () throws InterruptedException {
			synchronized (lock) {
				if (R.value.equals("")) {
					lock.wait();
				}

				R.value = "";
				System.out.println(Thread.currentThread().getName());
				lock.notify();
			}
		}
	}

	/**
	 * 数据存储
	 */
	static class R {
		public static String value = "";
	}
}
