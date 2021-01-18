package designpattern.proxy.jdk.proxy;

import designpattern.proxy.OrderService;
import designpattern.proxy.jdk.impl.OrderServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理模式：jdk动态代理 由InvocationHandler去重写需要代理的内容 <br>
 * 其实ProxyInvocationHandler更像是一个代理方法类 在Proxy.newProxyInstance去生成代理类去构建我们的代理类
 *
 * @author Administrator
 * @date 2020-02-19
 */
public class ProxyInvocationHandler implements InvocationHandler {

  /** 被代理的对象 */
  private OrderService target;

  public ProxyInvocationHandler(OrderService target) {
    this.target = target;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    System.out.println("<<<<日志开始了啊");
    Object object = method.invoke(target, args); // java反射机制去调用方法
    System.out.println("<<<<日志结束了啊");
    return object;
  }

  public OrderService getProxyObject() {
    return (OrderService)
        Proxy.newProxyInstance(
            target.getClass().getClassLoader(),
            target.getClass().getInterfaces(),
            new ProxyInvocationHandler(target));
  }

  public static void main(String[] args) throws Throwable {
    System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
    ProxyInvocationHandler proxy = new ProxyInvocationHandler(new OrderServiceImpl());
    OrderService proxyObject = proxy.getProxyObject();
    proxyObject.service();
  }
}
