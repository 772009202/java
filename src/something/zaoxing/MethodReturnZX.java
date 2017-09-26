package something.zaoxing;

/**
 * Created by YuChen on 2017/9/25 0025
 * 关于返回值的造型：验证自己的猜测   变成了造型的问题了
 */
public class MethodReturnZX{

	static class ExtendMethod{
		public  A get(A obj) {
			return obj;
		}
	}

	public static void main(String[] args) {
	 	ExtendMethod test = new ExtendMethod();
	 	B b = new B();
	 	A a2 = test.get(b);
	 	a2.setA("a");
	 	System.out.println(a2.getA()); // b
		B b2 = (B) test.get(b);
		b2.setA("a");
		System.out.println(b2.getA());

		A f1 = new B();
		A f2 = new A();
		f1 = f2;

	}
}
class A {
	private String a = "a";

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}
}

class B extends A {
	@Override
	public String getA() {
		return super.getA();
	}

	@Override
	public void setA(String a) {
		super.setA("b");
	}
}