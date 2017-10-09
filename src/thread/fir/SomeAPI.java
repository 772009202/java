package thread.fir;

/**
 * Created by YuChen on 2017/9/30 0030
 *
 * 1.getId 获取线程的唯一标志
 * 2.中断线程:interrupt()
 *
 */
public class SomeAPI {

	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread2();
		System.out.println(thread.isAlive()); //false 未启动不算
		thread.start();
		System.out.println(thread.isAlive()); //true

		Thread thread1 = new Thread2();
		System.out.println(thread1.isAlive()); //false
		thread1.start();
		Thread.sleep(1000); //这里其实是主线程沉睡，而thread1已经执行完了，因此下面是false
		System.out.println(thread1.isAlive()); //false
	}

}
class Thread2 extends Thread {
/*	private int i = 0;*/
	@Override
	public void run() {
		super.run();
/*		for (; i<100; i++) {
			System.out.println(i);
		}*/
	}
}
/*
* 1.stop作废的api，不安全。
*
* */