package algorithm.recursion;

/**
 * Created by YuChen on 2018/3/28 0028
 *
 * <p>问题：兔子没三个月生一次,生一次两个 问第N个月一个有多少兔子？
 */
public class Rabbit {

  public int getRabbitNum(int n) {
    int times = n / 3;
    return getNum(times);
  }

  private int getNum(int m) {
    if (m == 0) return 1;
    if (m == 1) return 3;
    m--;
    return 3 * getNum(m);
  }

  public int getRabbitNum2(int n) {
    int times = n / 3;
    return getNum(times, 1, 1);
  }

  private int getNum(int m, int count, int result) {
    if (m == 0) return 1;
    if (m == count) return 3 * result;
    count++;
    return getNum(m, count, result * 3);
  }

  public static void main(String[] args) {
    Rabbit rabbit = new Rabbit();
    for (int i = 3; i < 28; i += 3) {
      System.out.println(rabbit.getRabbitNum(i));
    }

    //		System.out.println(rabbit.getRabbitNum2(45));
  }
}
