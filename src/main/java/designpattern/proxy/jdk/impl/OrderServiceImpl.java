package designpattern.proxy.jdk.impl;

import designpattern.proxy.OrderService;

/**
 * @author Administrator
 * @date 2020-02-19
 */
public class OrderServiceImpl implements OrderService {

  /** 业务 */
  public void service() {
    System.out.println("这是被代理类的业务逻辑。。。");
  }

  public void demo() {
    System.out.println("这是另一个业务。。。");
  }
}
