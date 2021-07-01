package something.lambda.old.stream;

/** Created by YuChen on 2017/11/22 0022 */
public class DefaultInterface {

  private interface Java8DefaultInterface {

    default String notRequired() {
      return "不必强制实现";
    }

    /** 可以声明静态方法 */
    static void sys() {
      System.out.println("---------");
    }
  }

  private static class A implements Java8DefaultInterface {}

  private static class B implements Java8DefaultInterface {
    @Override
    public String notRequired() {
      return null;
    }
  }
}
