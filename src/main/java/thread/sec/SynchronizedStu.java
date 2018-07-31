package thread.sec;

/**
 * Created by YuChen on 2017/10/9 0009
 * synchronized修饰方法
 * 锁的是对象 thread1获得对象锁 thread2访问上锁方法都要等thread1释放锁
 */
public class SynchronizedStu {
	public static void main(String[] args) {

		MyObject myObject = new MyObject();
	 	Thread1 thread1 = new Thread1(myObject);
	 	Thread2 thread2 = new Thread2(myObject);
	 	thread1.start();
	 	thread2.start();
	}
}

class MyObject {
	private int i = 0;

	synchronized void change(int num) {
		this.i = num;
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(this.i);
	}

	synchronized void change2(int num) {
		this.i = num;
		System.out.println(this.i);
	}
}

class Thread1 extends Thread {

	private MyObject myObject;

	Thread1(MyObject myObject) {
		this.myObject = myObject;
	}

	@Override
	public void run() {
		super.run();
		myObject.change(1);
	}
}

class Thread2 extends Thread {

	private MyObject myObject;

	Thread2(MyObject myObject) {
		this.myObject = myObject;
	}

	@Override
	public void run() {
		super.run();
		myObject.change2(2);
	}
}