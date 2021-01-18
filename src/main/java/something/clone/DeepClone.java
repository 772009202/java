package something.clone;

/** Created by YuChen on 2017/9/22 0022 深复制 解决浅复制复制地址的问题，在重写clone返回值的时候要把不需要深复制的属性浅复制。 */
public class DeepClone implements Cloneable {

  private Char chr = new Char();
  private String a;

  public void setA(String string) {
    this.a = string;
  }

  public void setChr(Char chr) {
    this.chr = chr;
  }

  /**
   * 实现接口并重写clone方法（协同返回）
   *
   * @return
   * @throws CloneNotSupportedException
   */
  @Override
  protected DeepClone clone() throws CloneNotSupportedException {
    DeepClone deepClone = (DeepClone) super.clone();
    deepClone.chr = chr.clone(); // 这里可以有用new代替 但是属性就不会产生复制
    return deepClone;
  }

  public static void main(String[] args) {
    DeepClone q1 = new DeepClone();
    //	 	Char chr = new Char();
    q1.setA("start");
    //	 	q1.setChr(chr);

    DeepClone q2 = null;
    try {
      q2 = q1.clone();
    } catch (CloneNotSupportedException e) {
      e.printStackTrace();
    }

    System.out.println(q1.a + q1.chr.getChr());
    System.out.println(q2.a + q2.chr.getChr());

    //		chr.setChr("change");
    q1.chr.setChr("change");
    System.out.println(q1.a + q1.chr.getChr());
    System.out.println(q2.a + q2.chr.getChr());
  }
}

class Char implements Cloneable {
  private String chr = "start";

  public void setChr(String string) {
    this.chr = string;
  }

  public String getChr() {
    return this.chr;
  }

  @Override
  protected Char clone() throws CloneNotSupportedException {
    return (Char) super.clone();
  }
}
