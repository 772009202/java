package java.thread.thir;

import java.util.ArrayList;
import java.util.List;

/** Created by YuChen on 2017/10/12 0012 */
public class WaitAndNotify2 {

  public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    String a = new String("lock");
    Thread1 t1 = new Thread1(new Service1(list, a));
    Thread2 t2 = new Thread2(new Service2(list, a));
    Thread2 t21 = new Thread2(new Service2(list, a));
    Thread2 t22 = new Thread2(new Service2(list, a));
    Thread2 t23 = new Thread2(new Service2(list, a));

    t1.start();
    t2.start();
    t21.start();
    t22.start();
    t23.start();
  }

  static class Thread1 extends Thread {
    private volatile Service1 service1;

    Thread1(Service1 service1) {
      this.service1 = service1;
    }

    @Override
    public void run() {
      super.run();
      try {
        while (true) {
          service1.add();
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  static class Thread2 extends Thread {
    private volatile Service2 service2;

    Thread2(Service2 service2) {
      this.service2 = service2;
    }

    @Override
    public void run() {
      super.run();
      try {
        while (true) {
          service2.pop();
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  static class Service1 {
    private List<String> list;
    private String lock;

    Service1(List<String> list, String string) {
      this.list = list;
      this.lock = string;
    }

    /**
     * 异常分析： 1.生产者生产结束，下一次开始 2.某一个消费者唤醒并结束，下一次开始 3.1 ->生产者醒同上 3.2->消费者醒 wait 3.2.1另一个消费者醒 >3.2线程异常
     *
     * @throws InterruptedException
     */
    void add() throws InterruptedException { // 异常解决：以下
      synchronized (lock) {
        if (list.size() != 0) { // ->这里需要while不然 thread2唤醒thread2 程序往下走的时候list越界(第一步)
          lock.wait();
        }
        String value = System.currentTimeMillis() + "";
        list.add(value);
        lock.notify(); // ->这里要唤醒所有的线程为了就是唤醒生产者线程 否则会出现假死 (第二步)
        System.out.println(list.get(0));
      }
    }
  }

  static class Service2 {
    private List<String> list;
    private String lock;

    Service2(List<String> list, String string) {
      this.list = list;
      this.lock = string;
    }

    void pop() throws InterruptedException {
      synchronized (lock) {
        if (list.size() == 0) {
          lock.wait();
        }
        list.remove(0);
        lock.notify();
        System.out.println("删除成功");
      }
    }
  }
}
