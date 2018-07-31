package thread.fir;

/**
 * Created by YuChen on 2017/9/30 0030
 * 查看线程的调用顺序
 */
public class Order {
	public static void main(String[] args) {
	 	A a = new A();
	 	a.setName("A");
	 	a.start();
	}
}

class A extends Thread {
	A() {
		System.out.println("----A constructor start");
		System.out.println(Thread.currentThread().getName());  // main
		System.out.println("----A constructor end");
	}
	@Override
	public void run() {
		super.run();
		System.out.println("----A thread start");
		System.out.println(Thread.currentThread().getName()); //A
		System.out.println("----A thread end");
	}
}