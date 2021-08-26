package java_.thread.four;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by YuChen on 2017/10/13 0013
 *
 * <p>getHoldCount实现类的api 当前线程调用lock()的次数 getQueueLength 等待此锁的线程的个数 getWaitQueueLength
 * 返回此condition条件等待的线程
 */
public class LockAPI {

  public static void main(String[] args) throws InterruptedException {
    Service service = new Service();
    /*Thread1 t1 = new Thread1(service);
    t1.start();*/
    // getHoldCount的测试 2 1

    /*for (int i=0; i<5; i++) {
    	new Thread1(service).start();
    }*/
    // getQueueLength的测试

    Thread2 t1 = new Thread2(service);
    Thread2 t2 = new Thread2(service);
    Thread3 t3 = new Thread3(service);
    t1.start(); // getWaitQueueLength测试
    t2.start();
    Thread.sleep(100);
    t3.start();
  }

  static class Thread1 extends Thread {
    private Service service;

    Thread1(Service service) {
      this.service = service;
    }

    @Override
    public void run() {
      super.run();
      /*service.change();*/
      // getHoldCount的测试 2 1
      try {
        service.countWait(); // getQueueLength
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  static class Thread2 extends Thread {
    private Service service;

    Thread2(Service service) {
      this.service = service;
    }

    @Override
    public void run() {
      super.run();
      try {
        service.countCon();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  static class Thread3 extends Thread {
    private Service service;

    Thread3(Service service) {
      this.service = service;
    }

    @Override
    public void run() {
      super.run();
      service.countCon2();
    }
  }

  static class Service {
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    void change() {
      lock.lock();
      change2();
      System.out.println(lock.getHoldCount());
      lock.unlock();
    }

    void change2() {
      lock.lock();
      System.out.println(lock.getHoldCount());
      lock.unlock();
    }

    void countWait() throws InterruptedException {
      lock.lock();
      /*Thread.sleep(1000);*/
      // 确保其他线程在上一线程完成前获得锁 不然结果就是0
      System.out.println(lock.getQueueLength());
      lock.unlock();
    }

    void countCon() throws InterruptedException {
      lock.lock();
      condition.await();
      lock.unlock();
    }

    void countCon2() {
      lock.lock();
      System.out.println(lock.getWaitQueueLength(condition));
      condition.signalAll();
      lock.unlock();
    }
  }
}
