package thread.sec;

/**
 * Created by YuChen on 2017/10/10 0010
 * 此例可能出现死循环
 * volatile强制到公共堆栈中取得值，而不是线程的私有栈中。
 * 最大的缺点是不支持操作的原子性!!!!
 *
 * 只在线程加载变量时获取公共内存中的最新值，又因为赋值等不具有操作的原子性，就会出现 1+ 1+  = 1+的效果
 *
 */
public class Volatile {

	public static void main(String[] args) throws InterruptedException {
		Service service = new Service();
		new Thread(service).start();
		Thread.sleep(2000);
		service.setFlag(false);
	}

}
class Service implements Runnable {

	private boolean flag = true;

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	@Override
	public void run() {
		while(flag == true) {
			System.out.println(Thread.currentThread().getName() + "restart");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}