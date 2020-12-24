package thread.threadArt.four;

import something.exception.MyException;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by YuChen on 2018/1/17 0017
 *
 * <p>栈：满的时候入栈堵塞 没有的时候出栈堵塞(可以进一步的读写分离)
 */
public class MyQueue {

  private int[] array;

  private volatile int count = 0;

  private final Lock lock = new ReentrantLock();

  private final Condition condition1 = lock.newCondition();
  private final Condition condition2 = lock.newCondition();

  public MyQueue(int length) {

    if (length < 1)
      try {
        throw new MyException("array length is too low");
      } catch (MyException e) {
        e.printStackTrace();
      }
    array = new int[length];
  }

  private int getSize() {
    return array.length;
  }

  public void addEle(int num) throws InterruptedException {
    lock.lock();

    try {
      while (count == getSize()) condition1.await();
      array[count++] = num;
      condition1.signalAll();
    } finally {
      System.out.println(array[count]);
      lock.unlock();
    }
  }

  public int getEle() throws InterruptedException {
    lock.lock();
    try {
      while (count == 0) condition2.await();
      condition2.signalAll();

      System.out.println(array[count - 1]);
      return array[count--];
    } finally {
      lock.unlock();
    }
  }

  public static void main(String[] args) {
    MyQueue myQueue = new MyQueue(3);

    new Thread(
            () -> {
              for (int i = 0; i <= 20; i++) {
                if (i % 2 == 0)
                  try {
                    myQueue.getEle();
                  } catch (InterruptedException e) {
                    e.printStackTrace();
                  }
                else
                  try {
                    myQueue.addEle(i);
                  } catch (Exception e) {
                    e.printStackTrace();
                  }
              }
            })
        .start();
  }
}
