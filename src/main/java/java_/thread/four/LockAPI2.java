package java_.thread.four;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/** Created by YuChen on 2017/10/13 0013 */
public class LockAPI2 {

  public static void main(String[] args) throws InterruptedException {
    final Service service = new Service();
    Runnable runnable =
        new Runnable() {
          @Override
          public void run() {
            try {
              service.sys();
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }
        };
    Thread thread1 = new Thread(runnable);
    Thread thread2 = new Thread(runnable);
    thread1.start();
    thread2.start();
    Thread.sleep(1000);
    System.out.println(service.lock.hasQueuedThread(thread1));
    System.out.println(service.lock.hasQueuedThread(thread2));
    System.out.println(service.lock.hasQueuedThreads());
  }

  static class Service {
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    void sys() throws InterruptedException {
      lock.lock();
      Thread.sleep(2000);
      lock.unlock();
    }
  }
}
