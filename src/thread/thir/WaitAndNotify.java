package thread.thir;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YuChen on 2017/10/11 0011
 * wait和notify的例子：必须有拿到对象锁
 */
public class WaitAndNotify {

	public static void main(String[] args) throws InterruptedException {
		List<String> list = new ArrayList<>();
		Add add = new Add(list);
		Remove remove1 = new Remove(list);
		Remove remove2 = new Remove(list);
		remove1.start();
		remove2.start();
		Thread.sleep(2000);
		add.start();
	}

	static class Add extends Thread {
		private List<String> list;
		private String flag = "true";
		Add(List<String> list) {
			this.list = list;
		}
		@Override
		public void run() {
			super.run();
			synchronized (flag) {
				flag.notifyAll();
				list.add("a");
			}
		}
	}

	static class Remove extends Thread{
		private List<String> list;
		private String flag = "true";
		Remove(List<String> list) {
			this.list = list;
		}
		@Override
		public void run() {
			super.run();
			synchronized (flag) {
				while (list.size() == 0) {  //while的作用。虽然这里线程永远不会停止，只是个例子。
					try {
						System.out.println(Thread.currentThread().getName() + "开始执行");
						flag.wait();
						System.out.println(Thread.currentThread().getName() + "执行完");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				list.remove(0);
			}
		}
	}
}
