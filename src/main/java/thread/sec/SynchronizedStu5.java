package thread.sec;

/**
 * Created by YuChen on 2017/10/10 0010
 */
public class SynchronizedStu5 {

	/**
	 * 关于常量池(字符串)的锁要注意直接引用和new String("")的不同
	 * @param string
	 */
	public void sys(String string) throws InterruptedException {

		synchronized(string) {
			System.out.println(string);
			Thread.sleep(2000);
		}
		//这里形式意思下
		synchronized (new String()) {

		}
	}
}
