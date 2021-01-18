package something.clone;

/** Created by YuChen on 2017/9/22 0022 简而言之：再浅复制对象的时候，属性被深复制，也就是复制后的对象 属性复制的是地址 注意：string的特殊性。 */
public class ShallowClone implements Cloneable {

  private String str = "a";

  private A a2;

  public void setStr(String string) {
    this.str = string;
  }

  public void setA2(A a2) {
    this.a2 = a2;
  }

  @Override
  protected ShallowClone clone() throws CloneNotSupportedException {
    ShallowClone shallowClone = null;
    try {
      shallowClone = (ShallowClone) super.clone(); // 这里捕获异常是因为父类没有实现Cloneable接口会抛出异常
      // 增加程序的准确性 当然object就算了 这里只是例子
    } catch (CloneNotSupportedException e) {
      e.printStackTrace();
    }
    return shallowClone;
  }

  public static void main(String[] args) {
    ShallowClone sc1 = new ShallowClone();
    A a = new A();
    sc1.setA2(a);
    ShallowClone sc2 = null;
    try {
      sc2 = sc1.clone();
    } catch (CloneNotSupportedException e) {
      e.printStackTrace();
    }
    a.setA("b");
    sc1.setStr("b");
    System.out.println(sc1.a2.getA());
    System.out.println(sc2.a2.getA());
    System.out.println(sc1.str);
    System.out.println(sc2.str);
  }
}

class A {
  private String a = "a";

  public String getA() {
    return a;
  }

  public void setA(String a) {
    this.a = a;
  }
}
