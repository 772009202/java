package designpattern.proxy.cgilb;

import designpattern.proxy.jdk.impl.OrderServiceImpl;
import net.sf.cglib.proxy.Enhancer;

/**
 * cglib更像是继承的方式去构造(asm字节码技术)新的类
 *
 * @author Administrator
 * @date 2020-02-19
 */
public class Client {
  public static void main(String[] args) {
    Enhancer enhancer = new Enhancer();
    enhancer.setSuperclass(OrderServiceImpl.class);
    enhancer.setCallback(new MyMethodInterceptor());
    OrderServiceImpl orderService = (OrderServiceImpl) enhancer.create();
    orderService.service();
    orderService.demo();
  }
}
