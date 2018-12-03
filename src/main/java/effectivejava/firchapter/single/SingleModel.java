package effectivejava.firchapter.single;

import java.util.Random;

/**
 * Created by YuChen on 2017/12/20 0020
 * 单例模式
 * 饿汉模式 final修饰 第一次加载到内存中就已经确定了
 * 			由于final的修饰缺点也是可以看出来的，加载的时间过早
 *
 * 枚举？
 */
public class SingleModel {

	private static String a = null;

	public static synchronized String getA() { //效率极低
		if (a == null) {
			a = new String(String.valueOf(new Random().nextInt()));
		}
		return a;
	}
}

class SingleModel2 {  //这是比较好的一个单例模式

	private static volatile String  a = null; //这里为啥用volatile 不是因为可见性 而是禁止指令重排序优化

	public static String getA() {
		if (a == null) {
			synchronized (SingleModel.class) {
				if (a == null) {
					a = new String(String.valueOf(new Random().nextInt()));
				}
			}
		}
		return a;
	}
}

class SingleModel3 {  //静态内部类

	private static class SingletonHolder {
		private static final SingleModel3 INSTANCE = new SingleModel3();
	}
	private SingleModel3 (){}
	public static final SingleModel3 getInstance() {
		return SingletonHolder.INSTANCE;
	}

}


class Test {

	public static void main(String[] args) {
		new Thread(() -> {
			System.out.println(SingleModel.getA());
		}).start();
		new Thread(() -> {
			System.out.println(SingleModel.getA());
		}).start();
	}
}
