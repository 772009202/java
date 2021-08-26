package java_.thread.six;

/** Created by YuChen on 2017/10/13 0013 DCL 双重检查模式满足饿汉模式 */
public class DCL {

  private static volatile DCL dcl = null;

  private DCL() {}

  public static DCL getBean() {
    if (dcl == null) {
      synchronized (DCL.class) {
        if (dcl == null) dcl = new DCL();
      }
    }
    return dcl;
  }
}

class Test {

  public static void main(String[] args) {
    int i = 0;
    while (i < 20) {
      new Thread(
              () -> {
                DCL dcl = DCL.getBean();
                System.out.println(dcl.hashCode());
              })
          .start();
      i++;
    }
  }
}
