package javamode.proxy;

/**
 * Created by YuChen on 2017/9/14 0014
 */
public class SayHelloImpl implements SayHello{

	@Override
	public void sayHello() {
		System.out.println("接口你好啊");
	}

	public void change() {
		System.out.println("我一点都不好的哦");
	}

}
