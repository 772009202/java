package java.thread.threadArt.four;

import java.util.concurrent.locks.Lock;

/** Created by YuChen on 2018/1/10 0010 */
public class Test {

  private static volatile boolean flag = true;

  private static Lock lock = new MyAbstractQueuedSynchronizer();

  public static void main(String[] args) {
    new Thread(
            () -> {
              while (true) {
                lock.lock();

                try {
                  if (flag) {
                    flag = false;
                    System.out.println("----1");
                  }
                } catch (Exception e) {
                  e.printStackTrace();
                } finally {
                  lock.unlock();
                }
              }
            },
            "thread1")
        .start();

    new Thread(
            () -> {
              while (true) {
                lock.lock();

                try {
                  if (!flag) {
                    flag = true;
                    System.out.println("----2");
                  }
                } catch (Exception e) {
                  e.printStackTrace();
                } finally {
                  lock.unlock();
                }
              }
            },
            "thread2")
        .start();
  }
}
