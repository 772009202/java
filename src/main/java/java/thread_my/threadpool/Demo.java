package java.thread_my.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 核心线程数：实际运用的线程数 最大线程数：最多可以开多少线程 线程池原理：实际线程是否满 任务队列是否满 是否超过最大线程数 这么设计的原因是：是核心线程数充分利用
 *
 * @author Administrator
 * @date 2020-02-14
 */
public class Demo {
  public static void main(String[] args) {
    ThreadPoolExecutor executor =
        new ThreadPoolExecutor(1, 2, 5L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(3));
    // 超过6就会报错 最大线程数和队列都满了
    for (int i = 1; i < 6; i++) {
      Task task = new Task("任务" + i);
      executor.execute(task);
    }
    System.out.println("异步的哦！！");
    executor.shutdown();
  }
}

class Task implements Runnable {
  private String name;

  public Task(String name) {
    this.name = name;
  }

  @Override
  public void run() {
    System.out.println(Thread.currentThread().getName() + name);
  }
}
