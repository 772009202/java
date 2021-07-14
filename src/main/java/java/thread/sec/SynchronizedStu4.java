package java.thread.sec;

/** Created by YuChen on 2017/10/10 0010 */
public class SynchronizedStu4 {

  private static final String myLock = "myLock";

  private static int i = 0;

  /** 下面这两种使用方式 锁住的都是class对象 用法和synchronized(this)一样 */
  public static synchronized void sys() {
    System.out.println("A");
  }

  public void sys2() {
    synchronized (SynchronizedStu4.class) {
      System.out.println("B");
    }
  }

  public static void test() {
    synchronized (myLock) {
      for (int i = 0; i < 500; i++) {
        System.out.println(i);
      }
    }
  }

  public static synchronized void test2() throws InterruptedException {
    for (int i = 0; i < 500; i++) {
      Thread.sleep(1);
      System.out.println(i);
    }
  }
}

class Print {

  public static void main(String[] args) {
    Thread t1 =
        new Thread(
            () -> {
              SynchronizedStu4.test();
            });
    Thread t2 =
        new Thread(
            () -> {
              SynchronizedStu4.test();
            });
    t1.start();
    t2.start();

    //		Thread t3 = new Thread(() -> {SynchronizedStu4.test2();});
    //		Thread t4 = new Thread(() -> {SynchronizedStu4.test2();});
    //		t3.start();
    //		t4.start();
  }
}
