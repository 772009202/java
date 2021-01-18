package designpattern.handler.handler.impl;

import designpattern.handler.handler.GateWayHandler;

/**
 * @author Administrator
 * @date 2020-02-18
 */
public class SessionGateWayHandler extends GateWayHandler {
  @Override
  public void service() {
    System.out.println("这是会话网关");
    nextService();
  }
}
