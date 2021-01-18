package designpattern.proxy.myself.poxy;

import designpattern.proxy.OrderService;
import designpattern.proxy.jdk.impl.OrderServiceImpl;
import designpattern.proxy.myself.Invocation.MyInvocation;
import designpattern.proxy.myself.Invocation.impl.MyInvocationImpl;

/**
 * 模拟jdk动态代理生成的类 其实这就是反射去操作<br>
 * jdk动态代理底层：<br>
 * 1.$Poxy0.java去拼接出来 2.利用java compiler去编译 3.classloader去加载<br>
 * 也就是它的Proxy.newProxyInstance()过程
 *
 * @author Administrator
 * @date 2020-02-20
 */
public class $Poxy0 implements OrderService {
  private MyInvocation h;

  public $Poxy0(MyInvocation h) {
    this.h = h;
  }

  @Override
  public void service() throws Throwable {
    this.h.invoke(this, OrderService.class.getMethod("service"), null);
  }

  public static void main(String[] args) throws Throwable {
    OrderService orderService = new $Poxy0(new MyInvocationImpl(new OrderServiceImpl()));
    orderService.service();
  }
}
