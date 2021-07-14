package java.thread.threadpool;

import java.util.concurrent.*;

/**
 * @author YuChen
 * @see 2018/6/20 0020
 */
public class MyThreadPool {
  private static final ThreadPoolExecutor POOL;

  static {
    POOL =
        new ThreadPoolExecutor(10, 5, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(10));
  }

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    POOL.execute(() -> {});

    Future future = POOL.submit(() -> {});

    Object obj = future.get();
  }
}
