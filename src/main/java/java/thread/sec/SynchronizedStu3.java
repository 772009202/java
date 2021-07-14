package java.thread.sec;

/** Created by YuChen on 2017/10/10 0010 这个关于synchronized的用法更好 */
public class SynchronizedStu3 {

  public static void main(String[] args) {
    Service1 service1 = new Service1();
    Thread1 thread1 = new Thread1(service1);
    Thread2 thread2 = new Thread2(service1);
    thread1.start();
    thread2.start();
  }

  static class Service1 {
    synchronized void sys1() {
      System.out.println("A");
    }

    synchronized void sys2() {
      System.out.println("B");
    }
  }

  static class Service2 {
    private Service1 service1;

    Service2(Service1 service1) {
      this.service1 = service1;
    }

    void sys() {
      /** 这边能更好的看出锁住的是对象 */
      synchronized (service1) {
        try {
          Thread.sleep(2000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        service1.sys1();
      }
    }
  }

  static class Thread1 extends Thread {
    private Service2 service2;

    Thread1(Service1 service1) {
      service2 = new Service2(service1);
    }

    @Override
    public void run() {
      super.run();
      service2.sys();
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
      service1.sys2();
    }
  }
}
