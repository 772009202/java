package thread.threadArt.sec;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/** Created by YuChen on 2018/1/4 0004 */
public class CounterTest {

  private AtomicInteger atomicInteger = new AtomicInteger(0);

  private volatile int i = 0;

  /** 非安全计数 */
  private void notSafe() {
    i++;
  }

  /** 安全计数 */
  private void safe() {
    for (; ; ) {
      int i = atomicInteger.get();
      boolean suc = atomicInteger.compareAndSet(i, ++i);
      if (suc) {
        break;
      }
    }
  }

  public static void main(String[] args) {
    final CounterTest counterTest = new CounterTest();
    List<Thread> ts = new ArrayList<Thread>();
    long startTime = System.currentTimeMillis();
    for (int i = 0; i < 100; i++) {
      ts.add(
          new Thread(
              () -> {
                for (int j = 0; j < 1000; j++) {
                  counterTest.safe();
                  counterTest.notSafe();
                }
              }));
    }

    for (Thread e : ts) {
      e.start();
    }

    for (Thread e : ts) {
      try {
        e.join();
      } catch (InterruptedException e1) {
        e1.printStackTrace();
      }
    }

    System.out.println(counterTest.i);
    System.out.println(counterTest.atomicInteger.get());
    System.out.println(System.currentTimeMillis() - startTime);
  }
}
