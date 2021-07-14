package designpattern.strategy.impl;

import designpattern.strategy.MethodStrategyService;

/**
 * @author chenyu
 * @date 2021-07-13
 */
public class MethodStrategyImplA implements MethodStrategyService {
  @Override
  public void println() {
    System.out.println("策略A");
  }
}
