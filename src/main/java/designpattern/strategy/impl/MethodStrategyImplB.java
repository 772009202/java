package designpattern.strategy.impl;

import designpattern.strategy.MethodStrategyService;

/**
 * @author chenyu
 * @date 2021-07-13
 */
public class MethodStrategyImplB implements MethodStrategyService {
  @Override
  public void println() {
    System.out.println("策略B");
  }
}
