package thread.four;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by YuChen on 2017/10/13 0013
 *
 * 利用condition有效的唤醒指定的线程
 *
 * condition.await() 相当object的wait()  它释放lock的锁进入waiting状态
 * condition.signal() 相当于object的notify() 它唤醒lock下waiting状态并且condition.await()的线程
 */
public class ConditionStu {
	public static void main(String[] args) throws InterruptedException {
		Service service = new Service();
		Thread1 t1 = new Thread1(service);
		Thread2 t2 = new Thread2(service);

		t1.start();
		t2.start();
		Thread.sleep(1000);
		service.signal();
	}

	static class Thread1 extends Thread {
		private Service service;
		Thread1 (Service service) {
			this.service = service;
		}

		@Override
		public void run() {
			super.run();
			try {
				service.change1();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	static class Thread2 extends Thread {
		private Service service;
		Thread2 (Service service) {
			this.service = service;
		}

		@Override
		public void run() {
			super.run();
			try {
				service.change2();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	static class Service {
		private Lock lock = new ReentrantLock();
		private Condition condition1 = lock.newCondition();
		private Condition condition2 = lock.newCondition();

		void change1 () throws InterruptedException {
			System.out.println("-----1开始执行");
			lock.lock();
			condition1.await();
			System.out.println("-----1执行完毕");
			lock.unlock();
		}

		void change2 () throws InterruptedException {
			System.out.println("------2开始执行");
			lock.lock();
			condition2.await();
			System.out.println("------2执行完毕");
			lock.unlock();
		}

		void signal () throws InterruptedException {
			lock.lock();
			condition1.signal(); //唤醒
			System.out.println("------开始唤醒1");
			lock.unlock(); //释放锁后下一线程开始
			Thread.sleep(1000);
			System.out.println("------唤醒完毕");
		}
	}
}
