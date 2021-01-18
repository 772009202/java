package designpattern.handler.handler;

/**
 * @author Administrator
 * @create 2020/2/18
 */
public abstract class GateWayHandler {
  /** 责任链下一个handler */
  protected GateWayHandler nextGateWayHandler;

  public void setNextGateWayHandler(GateWayHandler nextGateWayHandler) {
    this.nextGateWayHandler = nextGateWayHandler;
  }

  public abstract void service();

  public void nextService() {
    if (nextGateWayHandler != null) {
      nextGateWayHandler.service();
    }
  }
}
