package thread_my.threadpool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Callable<T>类似于Runnable 它是带有返回值的 这边是future模式 在主线程过去值之前可以做一些操作 其实思路就是主线程在get()的时候 采取堵塞(wait)
 *
 * @author Administrator
 * @date 2020-02-15
 */
public class Demo2 {
  public static void main(String[] args) throws ExecutionException, InterruptedException {
    ExecutorService executorService = Executors.newCachedThreadPool();
    Future<String> future =
        executorService.submit(
            () -> {
              System.out.println("开始处理业务");
              Thread.sleep(2000);
              System.out.println("业务处理结束");
              return "ok";
            });
    System.out.println("主线程11111");
    String result = future.get();
    System.out.println("主线程22222");
    System.out.println(result);
    executorService.shutdown();
  }
}
