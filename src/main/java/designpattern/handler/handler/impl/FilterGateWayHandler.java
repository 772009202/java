package designpattern.handler.handler.impl;

import designpattern.handler.handler.GateWayHandler;

/**
 * @author Administrator
 * @date 2020-02-18
 */
public class FilterGateWayHandler extends GateWayHandler {

  @Override
  public void service() {
    System.out.println("这是过滤网关");
    nextService();
  }
}
