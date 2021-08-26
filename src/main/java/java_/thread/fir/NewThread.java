package java_.thread.fir;

/** Created by YuChen on 2017/9/30 0030 创建线程的两种方式： 继承重写run 接口实现run */
public class NewThread {
  public static void main(String[] args) {

    Thread thread1 = new Thread1();
    Thread thread2 =
        new Thread(
            new Runnable() {
              private int i = 100;

              @Override
              public void run() {
                for (; i < 200; i++) {
                  System.out.println(i);
                }
              }
            });
    // start启动异步  run是同步
    //	 	thread1.start();
    //	 	thread2.start();

    thread1.run();
    thread2.run();
  }
}

class Thread1 extends Thread {
  private int i = 0;

  @Override
  public void run() {
    super.run();
    for (; i < 100; i++) {
      System.out.println(i);
    }
  }
}
