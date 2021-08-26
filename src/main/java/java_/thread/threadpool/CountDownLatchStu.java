package java_.thread.threadpool;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by YuChen on 2017/12/14 0014 ThreadPoolExecutor CountDownLatch CyclicBarrier Semaphore
 * Exchanger Future FutureTask
 */
public class CountDownLatchStu {

  public void sys() {
    int count = 10;
    ThreadPoolExecutor tp =
        new ThreadPoolExecutor(
            1, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(count));
    final CountDownLatch latch = new CountDownLatch(count);
    int[] dates = new int[10204];
    int step = dates.length / count;
    for (int i = 0; i < count; i++) {
      int start = i * step;
      int end = (i + 1) * step;
      if (i == count - 1) end = dates.length;
      /*			tp.execute(new );*/
    }
  }
}
