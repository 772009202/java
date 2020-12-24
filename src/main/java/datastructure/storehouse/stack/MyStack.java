package datastructure.storehouse.stack;

import something.exception.MyException;

/**
 * Created by YuChen on 2018/3/7 0007
 *
 * <p>设计的堆栈接口
 */
public interface MyStack<E> {

  // 栈含元素个数
  public int getSize();

  // 是否为空
  public boolean isEmpty();

  // 入栈操作
  public void push(E e);

  // 栈顶元素出栈
  public E pop() throws MyException;

  // 读取栈顶元素
  public E peek() throws MyException;
}
