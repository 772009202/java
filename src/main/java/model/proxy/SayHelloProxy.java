package model.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理模式
 * Created by YuChen on 2017/9/14 0014
 */
public class SayHelloProxy implements InvocationHandler{

	private SayHello sayHello;

	public SayHelloProxy(SayHello sayHello) {
		this.sayHello = sayHello;
	}

	public Object getProxyInstance() {
		return Proxy.newProxyInstance(sayHello.getClass().getClassLoader(),
				sayHello.getClass().getInterfaces(), this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("代理前");
		this.sayHello.sayHello();
		System.out.println("代理后");

		return method.invoke(this.sayHello, args);
	}

}
