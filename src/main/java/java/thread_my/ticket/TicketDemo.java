package java.thread_my.ticket;

/**
 * 车票的demo 线程安全性问题 安全性问题思考：我们需要争夺同一资源才会有安全性问题，注意在设置锁的时候要是同一把锁
 *
 * <p>synchronized:内置锁 互斥 可重入
 */
public class TicketDemo {

  public static void main(String args[]) {
    Runnable ticketSale =
        () -> {
          Ticket ticket = new Ticket();
          ticket.sale();
        };
    Thread thread1 = new Thread(ticketSale, "售票窗口1");
    Thread thread2 = new Thread(ticketSale, "售票窗口2");

    thread1.start();
    thread2.start();
  }
}

class Ticket {
  // 100张车票
  private static int ticket = 100;

  private static Object obj = new Object();

  public void sale() {
    while (ticket > 0) {

      try {
        Thread.currentThread().sleep(50);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      synchronized (obj) {
        // 这边的判断 最后一次运行也会触发 他会接管锁进入方法 但是上一次已经卖到
        // 0张了，这边不判断的话就会成负数
        if (ticket > 0) {
          System.out.println(Thread.currentThread().getName() + "售卖第：" + (100 - ticket + 1) + "张!");
          ticket--;
        }
      }
    }
  }
}
