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
        enhancer.setCallbacks(new Callback[]{this, NoOp.INSTANCE});
        enhancer.setCallbackFilter((e) -> {
            if("sayHello".equals(e.getName())) {
                return 1;
            } else {
                return 0;
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
