package thread.fir;

/**
 * Created by YuChen on 2017/9/30 0030
 */
public class ThreadDemo implements Runnable{
	@Override
	public void run() {
		for (int i=0; i<1000; i++) {
			System.out.println(i);
		}
	}
}
