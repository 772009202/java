package datastructure.storehouse.stack;

import exception.MyException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YuChen on 2018/3/7 0007
 *
 * 采取顺序存储结构在实现 即数组
 */
public class StoreHouse<E> implements MyStack<E> {

	private int pop = -1;

	private List<E> list = new ArrayList<E>();

	@Override
	public int getSize() {
		return pop+1;
	}

	@Override
	public boolean isEmpty() {
		return pop == -1;
	}

	@Override
	public void push(E e) {
		list.add(++pop, e);
	}

	@Override
	public E pop() throws MyException {
		if (getSize() < 1)
			throw new MyException("栈为空");
		E e = list.get(pop);
		list.set(pop--, null); //防止垃圾不能及时回收

		return e;
	}

	@Override
	public E peek() throws MyException {
		if (getSize() < 1)
			throw new MyException("栈为空");

		return list.get(pop);
	}
}
