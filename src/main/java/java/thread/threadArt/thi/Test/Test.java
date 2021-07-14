package java.thread.threadArt.thi.Test;

/** Created by YuChen on 2018/1/5 0005 测试重排序带来的影响，但是没看见效果 */
public class Test {

  int i = 0;

  boolean flag = false;

  public void read() {
    i = 10;
    flag = true; // 上下两步不一定按顺序 不存在数据的依赖性
    // 10又不一定立刻刷到主内存中
  }

  public void write() {
    for (; ; ) {
      if (flag) {
        i = i * i;
        System.out.println(i);
        break;
      }
    }
  }

  public static void main(String[] args) {
    Test test = new Test();

    new Thread(
            () -> {
              test.write();
            })
        .start();

    new Thread(
            () -> {
              test.read();
            })
        .start();
  }
}
