package lambda;

import java.util.Arrays;
import java.util.List;

/**
 * Created by YuChen on 2017/11/22 0022
 */
public class ClosureStu {

	private static final int num = 1;

	public static void main(String[] args) {
		/**
		 * 例子
		 */
		List array = Arrays.asList("a", "b");
		array.forEach(e -> System.out.println(e));
		array.forEach(e -> {
			System.out.println(e);
		});

		/**
		 * 线程
		 */
		Runnable a = ()-> System.out.println("你好");
		new Thread(ClosureStu::runableImpl).start();

		/**
		 * 自定义
		 */
		newInterfaceImpl((e) -> {
			System.out.println("自定义");
			System.out.println(e + ClosureStu.num);
		});

		newInterfaceImpl(ClosureStu::sysImpl);

	}

	public static void runableImpl () {
		System.out.println("线程方法引用");
	}

	public static void sysImpl(int var) {
		System.out.println("自定义的方法引用");
	}

	/**
	 * 函数接口的引用
	 * @param newInterface
	 */
	public static void newInterfaceImpl (NewInterface newInterface) {
		newInterface.sys(2);
	}

	/**
	 * 自定义的函数接口
	 */
	@FunctionalInterface
	private interface NewInterface{
		void sys(int var);
		default void another() { }
	}

}
