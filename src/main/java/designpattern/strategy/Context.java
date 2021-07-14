package designpattern.strategy;

/**
 * 容器
 *
 * @author chenyu
 * @date 2021-07-13
 */
public class Context {

  private MethodStrategyService strategyService = null;

  /**
   * 采用这种类似工厂模式，可以减小客户端的压力（类似Test类，只需要知道规则即可）
   *
   * @param strategyClassName
   */
  public Context(String strategyClassName) {
    try {
      Class clazz = Class.forName(strategyClassName);
      strategyService = (MethodStrategyService) clazz.newInstance();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InstantiationException e) {
      e.printStackTrace();
    }
  }

  public void strategy() {
    strategyService.println();
  }
}
