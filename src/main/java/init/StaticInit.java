package init;

/**
 * Created by YuChen on 2017/12/27 0027
 *
 * 调用了父类的字段  父类一定被初始化
 */
public class StaticInit {
	public static void main(String[] args) {
		/*System.out.println(A2.str);*/
		C c = new C();
		System.out.println(c.setStr() == c);

		System.out.println(new Object().a);
	}
}

class A1 {
	static {
		System.out.println("--A1");
	}
	protected static String str = "str";
}

class A2 extends A1 {
	static {
		System.out.println("---A2");
	}
}

class B {
	private static final String str = new String("abc");
	private static final C c = new C();

	{
		/*c = c.setStr();*/  //不知道是不是因为运行期才知道setStr的结果的原因
	}
}

class C {

	String str = "str";

	public C setStr () {
		this.str = "str2";
		return this;
	}

	public static void returnNewC(C c) {

	}
}

class Object {
	final String a = "a";
}