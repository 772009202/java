package algorithm.recursion;

/**
 * Created by YuChen on 2018/3/28 0028
 *
 * <p>阶乘
 */
public class Factorial {

  public int getCount(int n) {
    if (n == 1) return 1;
    return n * getCount(--n);
  }

  public static void main(String[] args) {
    Factorial factorial = new Factorial();

    for (int i = 1; i < 10; i++) {
      System.out.println(factorial.getCount(i));
    }
    //	 	System.out.println(factorial.getCount(5,1));
  }

  public int getCount(int n, int count) {
    if (n == 1) return count;
    count *= n;
    n--;
    return getCount(n, count);
  }
}
