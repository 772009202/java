package effectivejava.firchapter.finalize;

/**
 * 测试通过，会被回收
 *
 * Created by YuChen on 2017/9/12 0012
 */
public class FinalizeTest {

	public static void main(String[] args) {
		for (int i=0; i<10000000; i++) {
			A a = new A();
			try {
				System.out.println(i);
				a.finalize();
				a.toString();
				if (i%100000 == 0) {
					Thread.sleep(1000);
				}
			} catch (Throwable throwable) {
				throwable.printStackTrace();
			}
		}
	}
}

class A {

/*	A (int i) {
		String a = i + "";
		System.out.println(a);
	}*/

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("正在被回收");
	}
}
