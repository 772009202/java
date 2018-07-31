package javamode.proxy;

import net.sf.cglib.proxy.*;

import java.lang.reflect.Method;

/**
 * @description: cglib动态代理
 * @author: YuChen
 * @create: 2018-07-31
 **/
public class SayHelloCglibProxy<T> implements MethodInterceptor {

    private T t;

    public T getInstance(T t) {
        this.t = t;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.t.getClass());
        enhancer.setCallbacks(new Callback[]{this, new StaticValue()});
        enhancer.setCallbackFilter((e) -> {
            if("sayHello".equals(e.getName())) {
                return 0;
            } else {
                return 1;
            }
        });
        return (T) enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("代理前");
        methodProxy.invokeSuper(o, objects);
        System.out.println("代理后");
        return null;
    }

    public static void main(String[] args) {
        SayHelloImpl sayHello = new SayHelloImpl();
        SayHelloCglibProxy<SayHelloImpl> sayHelloCglibProxy = new SayHelloCglibProxy();
        SayHelloImpl sayHelloProxy = sayHelloCglibProxy.getInstance(sayHello);
        sayHelloProxy.sayHello();
        sayHelloProxy.change();
//        CallbackFilter
    }
}

class StaticValue implements FixedValue {

    @Override
    public Object loadObject() throws Exception {
        System.out.println("你好呀");
        return "StaticValue";
    }
}