package something;

/**
 * Created by YuChen on 2017/9/19 0019
 * java中的值传递和引用传递：值传递基本类型(String有类似的感觉)
 * 引用传递参数是对象，引用传递只对对象负责
 */
public class Transmit {

	public static void main(String[] args) {
		A a = new A();
		change(a);
		System.out.println(a.a);

		int num = 0;
		change2(num);
		System.out.println(num);

	}

	static void change(A a) {
		a.a = "b";
		a = new A();
	}

	static void change2(int num) {
		num = 10;
	}
}

class A {
	public String a = "a";
}

