package thread.sec;

/**
 * Created by YuChen on 2017/10/10 0010
 */
public class SynchronizedStu4 {

	/**
	 * 下面这两种使用方式 锁住的都是class对象 用法和synchronized(this)一样
	 */
	public synchronized static void sys() {
		System.out.println("A");
	}

	public void sys2() {
		synchronized (SynchronizedStu4.class) {
			System.out.println("B");
		}
	}
}
