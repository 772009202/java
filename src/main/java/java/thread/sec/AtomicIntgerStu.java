package java.thread.sec;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by YuChen on 2017/10/11 0011 atomic -> 原子类前缀 具有原子性 某些情况下可以替代synchronized (线程计数)
 * CountDownLatch
 */
public class AtomicIntgerStu {

  public static void main(String[] args) {
    Service service = new Service();
    Thread1 t1 = new Thread1(service);
    Thread1 t2 = new Thread1(service);
    t1.start();
    t2.start();

    //		Service1 service2 = new Service1();
    //		Thread2 t3 = new Thread2(service2);
    //		Thread2 t4 = new Thread2(service2);
    //		t3.start();
    //		t4.start();
  }

  static class Service {
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    /**
     * 可替代synchronized，轻量级
     *
     * @throws InterruptedException
     */
    void change() throws InterruptedException {
      for (int i = 0; i < 100; i++) {
        System.out.println(atomicInteger.incrementAndGet());
        Thread.sleep(100);
      }
    }
  }

  static class Thread1 extends Thread {
    private Service service;

    Thread1(Service service) {
      this.service = service;
    }

    @Override
    public void run() {
      super.run();
      try {
        service.change();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  static class Thread2 extends Thread {
    private Service1 service1;

    Thread2(Service1 service1) {
      this.service1 = service1;
    }

    @Override
    public void run() {
      super.run();
      try {
        service1.change();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  static class Service1 {
    /** 仅仅具有可见性，程序依旧线程不安全 */
    private volatile int num = 0;

    void change() throws InterruptedException {
      for (int i = 0; i < 100; i++) {
        num++;
        System.out.println(num);
        Thread.sleep(100);
      }
    }
  }
}
