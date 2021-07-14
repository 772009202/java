package java.thread.four;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by YuChen on 2017/10/13 0013
 *
 * <p>Lock接口的使用 这里效果其实有点像wait和notify的使用
 */
public class LockStu {

  public static void main(String[] args) {
    Thread1 t1 = new Thread1();
    Thread1 t2 = new Thread1();
    Thread1 t3 = new Thread1();
    t1.start();
    t2.start();
    t3.start();
  }

  static class Thread1 extends Thread {
    public static Lock lock = new ReentrantLock(); // false：不公平锁 true：公平锁 根据请求的顺序获得锁，反之。

    @Override
    public void run() {
      super.run();
      lock.lock(); // 拿到对象锁
      for (int i = 0; i < 5; i++) {
        System.out.println(Thread.currentThread().getName() + i);
      }
      lock.unlock(); // 释放锁
    }
  }
}
