package datastructure.storehouse.dequeue;

import exception.MyException;

/**
 * Created by YuChen on 2018/3/27 0027
 *
 * <p>用循环数组实现的队列
 */
public class Dequeue implements Queue {

  // 默认队列大小
  private static final int CAP = 7;

  // 数组
  private Object[] objs;

  // 数组大小
  private int length;

  // 队首指针
  private int ds;

  // 队尾指针
  private int dw;

  public Dequeue(int cap) {
    length = cap + 1;
    objs = new Object[length];
    ds = dw = 0;
  }

  public Dequeue() {
    this(CAP);
  }

  @Override
  public int getSize() {
    return (dw - ds + length) % length; // 很关键
  }

  @Override
  public boolean isEmpty() {
    return dw == ds;
  }

  @Override
  public void enqueue(Object object) {

    if (getSize() == length - 1)
      try {
        throw new MyException("队列已经满了");
      } catch (MyException e) {
        e.printStackTrace();
      }

    objs[dw] = object;
    dw = (dw + 1) % length; // 很nice
  }

  // 可以扩容
  private void expandSpace() {}

  @Override
  public Object dequeue() {
    if (isEmpty())
      try {
        throw new MyException("队列为空");
      } catch (MyException e) {
        e.printStackTrace();
      }
    Object obj = objs[ds];
    objs[ds] = null;
    ds = (ds + 1) % length;
    return obj;
  }

  @Override
  public Object peek() {
    return null;
  }
}
