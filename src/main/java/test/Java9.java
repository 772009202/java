package test;

/**
 * Created by YuChen on 2017/12/20 0020
 */
public class Java9 {

	private A a = new A();
	private static int num = 3;

	public static void main(String[] args) {
	 	System.out.println(num);
	}

}

class A {
	private String a = "a";
	{
		System.out.println("A实例块");
	}
}
