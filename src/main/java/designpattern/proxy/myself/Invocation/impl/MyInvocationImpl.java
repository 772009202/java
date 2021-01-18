package designpattern.proxy.myself.Invocation.impl;

import designpattern.proxy.OrderService;
import designpattern.proxy.myself.Invocation.MyInvocation;

import java.lang.reflect.Method;

/**
 * @author Administrator
 * @date 2020-02-20
 */
public class MyInvocationImpl implements MyInvocation {

  private OrderService target;

  public MyInvocationImpl(OrderService target) {
    this.target = target;
  }

  /**
   * @param proxy 代理类
   * @param method 目标对象方法
   * @param args
   * @return
   * @throws Throwable
   */
  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    System.out.println("<<<<日志开始");
    Object object = method.invoke(target, args);
    System.out.println("<<<<日志结束");
    return object;
  }
}
