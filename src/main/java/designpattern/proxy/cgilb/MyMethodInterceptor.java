package designpattern.proxy.cgilb;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author Administrator
 * @date 2020-02-19
 */
public class MyMethodInterceptor implements MethodInterceptor {
  public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy)
      throws Throwable {
    System.out.println("<<<<日志开始");
    // 注意这里的方法调用，不是用反射哦！！！
    Object object = methodProxy.invokeSuper(o, objects);
    System.out.println("<<<<日志结束");
    return object;
  }
}
