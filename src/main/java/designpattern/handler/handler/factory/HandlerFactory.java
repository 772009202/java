package designpattern.handler.handler.factory;

import designpattern.handler.handler.impl.BlackGateWayHandler;
import designpattern.handler.handler.impl.FilterGateWayHandler;
import designpattern.handler.handler.impl.SessionGateWayHandler;

/**
 * @author Administrator
 * @date 2020-02-18
 */
public class HandlerFactory {

  //  public void Handler() {
  //    BlackGateWayHandler blackGateWayHandler = new BlackGateWayHandler();
  //    blackGateWayHandler.service();
  //    FilterGateWayHandler filterGateWayHandler = new FilterGateWayHandler();
  //    blackGateWayHandler.setNextGateWayHandler(filterGateWayHandler);
  //    filterGateWayHandler.service();
  //    SessionGateWayHandler sessionGateWayHandler = new SessionGateWayHandler();
  //    filterGateWayHandler.setNextGateWayHandler(sessionGateWayHandler);
  //    sessionGateWayHandler.service();
  //  }

  public static void main(String[] args) {
    BlackGateWayHandler blackGateWayHandler = new BlackGateWayHandler();
    FilterGateWayHandler filterGateWayHandler = new FilterGateWayHandler();
    blackGateWayHandler.setNextGateWayHandler(filterGateWayHandler);
    SessionGateWayHandler sessionGateWayHandler = new SessionGateWayHandler();
    filterGateWayHandler.setNextGateWayHandler(sessionGateWayHandler);
    blackGateWayHandler.service();
  }
}
