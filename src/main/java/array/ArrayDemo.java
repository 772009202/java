package array;

/**
 * 数组的协变
 *
 * @author YuChen
 * @date 2018-12-12
 */
public class ArrayDemo {

  public static void main(String[] args) {
    A[] a = new B[10];
    a[0] = new C();
    System.out.println(123);
  }
}

class A {}

class B extends A {}

class C extends A {}
