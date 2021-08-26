package java_.thread.sec;

/** Created by YuChen on 2017/10/10 0010 */
public class SynchronizedStu6 {

  public static void main(String[] args) throws InterruptedException {
    Service service = new Service();
    Thread1 thread1 = new Thread1(service);
    Thread2 thread2 = new Thread2(service);
    thread1.setName("A");
    thread2.setName("B");
    thread1.start();
    /** 加一秒str指向对象改变 thread1锁的对象和thread2要的锁不一样了 此时thread2进入同步块；不加thread2等thread1完成 这里很nice! */
    Thread.sleep(1000);
    thread2.start();
  }

  static class Service {
    private String str = "ABC";

    void sys() throws InterruptedException {
      synchronized (str) {
        System.out.println(Thread.currentThread().getName() + "start");
        this.str = "2";
        Thread.sleep(3000);
        System.out.println(Thread.currentThread().getName() + "end");
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
        service.sys();
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
        service.sys();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
