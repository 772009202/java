package thread_my.awaitandnotify;

/**
 * 等待通知机制 生产者消费者 顺序执行
 *
 * <p>synchronized （wait、notify）配套使用的 wait是释放锁 notify是通知别人去获得锁
 */
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

  public void producer() {
    int i = 0;
    while (true) {
      synchronized (this) {
        if (!flag) {
          try {
            this.wait();
            Thread.sleep(1000);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }

        if (i % 2 == 0) {
          name = i + "";
          System.out.println("生产者name：" + name);
          i++;
        } else {
          name = i + "";
          i++;
          System.out.println("生产者name：" + name);
        }
        flag = false;
        this.notify();
      }
    }
  }

  public void consumer() {
    while (true) {
      synchronized (this) {
        if (flag) {
          try {
            this.wait();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
        System.out.println("消费者name：" + name);
        flag = true;
        this.notify();
      }
    }
  }
}
