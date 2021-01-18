package designpattern.proxy.myself.Invocation;

import java.lang.reflect.Method;

/**
 * 模拟jdk动态代理接口
 *
 * @author Administrator
 * @create 2020/2/20
 */
public interface MyInvocation {
  Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
}
