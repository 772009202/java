package datastructure.linkedstore.single.iterator;

import datastructure.linkedstore.single.ListSLinked;
import datastructure.linkedstore.single.SLNode;

import java.util.LinkedList;

/**
 * Created by YuChen on 2018/3/27 0027
 */
public class LinkedListIterator<E> implements Iterator {

	//当前结点
	private SLNode<E> current;

	//线性表
	private ListSLinked<E> list;

	public LinkedListIterator(ListSLinked list) {
		this.list = list;

		first();
	}

	//暂时不用吧
	@Override
	public void first() {

		if (list.getHead().getNext() == null)
			current = null;
		else
			current = list.getHead().getNext();
	}


	@Override
	public void next() {
		if (null != current)
			current = current.getNext();
	}

	@Override
	public boolean isDone() {
		return current != null && current.getNext() != null;
	}

	@Override
	public Object currentLtem() {
		return current == null? null : current.getData();
	}
}
