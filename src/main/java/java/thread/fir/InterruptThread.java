package java.thread.fir;

import something.exception.MyException;

/**
 * Created by YuChen on 2017/9/30 0030 1.interrupted(静态)判断运行此处的线程是不是被打断 2.isInterrupted(非静态)
 * 判断线程对象是否被打断 3.在线程沉睡的时候打断会报错，interrupted清除状态的功能 变false 4.stop强制停止的方法已经被抛弃
 */

/*
 * 逻辑上终止线程:生产者根据消费者中断提前结束方法(例如break) 消费者主动打断,然而感觉并不好
 * 顺便可以结合return 剩下部分不执行
 * */
public class InterruptThread {

  public static void main(String[] args) throws InterruptedException {

    Thread.currentThread().interrupt();
    System.out.println(Thread.interrupted());
    System.out.println(Thread.interrupted()); // 第二次最后 变false 清除状态的功能

    Thread threadDemo = new Thread(new ThreadDemo());
    threadDemo.start();
    threadDemo.interrupt();
    System.out.println("----" + threadDemo.isInterrupted());
  }

  /** 暴力的退出，利用抛异常的方式，不会执行下面的语句 */
  class A extends Thread {
    @Override
    public void run() {
      if (this.interrupted())
        try {
          throw new MyException("----线程退出");
        } catch (MyException e) {
          e.printStackTrace();
        }
      System.out.println(9); // 异常后不会被执行。
    }
  }
}
