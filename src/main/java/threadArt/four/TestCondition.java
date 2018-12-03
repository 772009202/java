package threadArt.four;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by YuChen on 2018/1/17 0017
 */
public class TestCondition {

	static Lock lock = new ReentrantLock();

	static Condition condition = lock.newCondition();

	public static void main(String[] args) {
		new Thread(() -> {

			lock.lock();

			try {
				System.out.println("---------A开始了");
				condition.await();
				System.out.println("----------A中间了");
				Thread.sleep(1000);
				System.out.println("----------A结束了");
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {

				lock.unlock();
			}
		}).start();

		new Thread(() -> {

			lock.lock();

			try {
				System.out.println("----------B开始了");
				condition.signal();
				Thread.sleep(1000);
				System.out.println("----------B结束了");
			} catch (Exception e) {
			    e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}).start();

		new Thread(() -> {
			lock.lock();
			System.out.println("-----C开始了");
			lock.unlock();
		}).start();
	}
}
