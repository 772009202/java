package javamode.proxy;

/**
 * Created by YuChen on 2017/9/14 0014
 */
public class Test {

	public static void main(String[] args) {
		SayHello sayHello = new SayHelloImpl();
		SayHelloProxy proxy = new SayHelloProxy(sayHello);
		SayHello sayHello1 = (SayHello) proxy.getProxyInstance();
		sayHello1.sayHello();
	}
}
