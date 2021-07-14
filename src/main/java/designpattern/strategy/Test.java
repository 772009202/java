package designpattern.strategy;

/**
 * @author chenyu
 * @date 2021-07-13
 */
public class Test {

  @org.junit.Test
  public void test1() {
    Context contextA = new Context("designpattern.strategy.impl.MethodStrategyImplA");
    contextA.strategy();

    Context contextB = new Context("designpattern.strategy.impl.MethodStrategyImplB");
    contextB.strategy();
  }
}
