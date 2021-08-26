package java_.mythread.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/** 使用lock锁完成 生产者消费者按顺序执行 */
public class Demo {

  public static void main(String args[]) {

    Body body = new Body();
    Thread1 thread1 = new Thread1(body);
    Thread2 thread2 = new Thread2(body);

    thread1.start();
    thread2.start();
  }
}

class Thread1 extends Thread {
  private Body body;

  public Thread1(Body body) {
    this.body = body;
  }

  @Override
  public void run() {
    body.producer();
  }
}

class Thread2 extends Thread {
  private Body body;

  public Thread2(Body body) {
    this.body = body;
  }

  @Override
  public void run() {
    body.consumer();
  }
}

class Body {

  private volatile String name;

  // true的时候去生产 false去消费
  private volatile Boolean flag = true;

  private Lock lock = new ReentrantLock();

  private Condition condition = lock.newCondition();

  public void producer() {
    int i = 0;
    while (true) {
      lock.lock();
      try {
        if (!flag) {
          try {
            condition.await();
            Thread.sleep(1000);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
        if (i % 2 == 0) {
          name = i + "";
          i++;
          System.out.println("生产者name：" + name);
        } else {
          name = i + "";
          i++;
          System.out.println("生产者name：" + name);
        }
        flag = false;
        condition.signal();
      } catch (Exception e) {

      } finally {
        lock.unlock();
      }
    }
  }

  public void consumer() {
    while (true) {
      lock.lock();
      try {
        if (flag) {
          condition.await();
        }
        System.out.println("消费者name：" + name);
        flag = true;
        condition.signal();
      } catch (Exception e) {
        e.printStackTrace();
      } finally {
        lock.unlock();
      }
    }
  }
}
