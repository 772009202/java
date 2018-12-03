package datastructure.linkedstore.single;

import exception.MyException;

import java.util.*;

/**
 * Created by YuChen on 2018/3/26 0026
 *
 * 单向链表的实现
 */
public class ListSLinked<E> implements List<E> {

	//首个结点 解决边界问题
	private SLNode head;

	//结点个数
	private int size;

	public ListSLinked() {
		head = new SLNode();
		size = 0;
	}

	public SLNode getHead() {
		return head;
	}

	//辅助方法 获取元素的前驱结点 可能为null
	private SLNode getPreNode(Object obj) {
		SLNode p = head;

		while (null != p.getNext()) {
			SLNode next = p.getNext();
			if (next.getData() != null && next.getData().equals(obj))
				return p == head ? null : p;
			p = next;
		}

		return null;
	}

	//辅助方法 获取元素的结点 可能为null
	private SLNode getNode(Object obj) {
		SLNode p = head;

		while (null != p.getNext()) {
			SLNode next = p.getNext();
			if (next.getData() != null && next.getData().equals(obj))
				return p;
			p = next;
		}

		return null;
	}

	//辅助方法 获取序号为i的前驱结点
	private SLNode getPreNode(int i) {
		SLNode p = head;

		for (;i>0;i--) {
			if (null != p.getNext())
				p = p.getNext();
		}

		return p;
	}

	//辅助方法 获取序号为i的结点
	private SLNode getNode(int i) {
		SLNode p = head;

		for (;i>=0;i--) {
			if (null != p.getNext())
				p = p.getNext();
		}

		return p;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == -1;
	}

	@Override
	public boolean contains(Object o) {
		return getNode(o) != null;
	}

	@Override
	public boolean add(E e) {
		add(size, e);
		return true;
	}

	@Override
	public boolean remove(Object o) {
		SLNode node = getNode(o);
		return node != null;
	}

	@Override
	public E get(int index) {
		SLNode node = getNode(index);
		return (E) node.getData();
	}

	@Override
	public void add(int index, Object element) {
		if (index < 0 || index > size)
			throw new MyException("越界");

		SLNode node = getNode(index);
		SLNode newNode; //插入的新结点
		if (null == node) {
			newNode = new SLNode(element, null);
		} else {
			newNode = new SLNode(element, node);
		}

		SLNode preNode = getPreNode(index);
		preNode.setNext(newNode);
		size++;
	}

	@Override
	public E remove(int index) {
		SLNode node = getNode(index);
		SLNode preNode = getPreNode(index);
		preNode.setNext(node.getNext());
		size--;

		return (E) node.getData();
	}

	@Override
	public int indexOf(Object o) {
		SLNode p = head;
		int index = -1;

		while (null != p.getNext()) {
			index++;
			SLNode next = p.getNext();
			if (null != next.getData() && next.getData().equals(o))
				return index;
			p = next;
		}

		return -1;
	}

	@Override
	public int lastIndexOf(Object o) {
		SLNode p = head;
		int index = -1;
		int lastIndex = index;

		while (null != p.getNext()) {
			index++;
			SLNode next = p.getNext();
			if (null != next.getData() && next.getData().equals(o))
				lastIndex = index;
			p = next;
		}

		return lastIndex;
	}

	@Override
	public ListIterator listIterator() {
		return null;
	}

	@Override
	public ListIterator listIterator(int index) {
		return null;
	}

	@Override
	public List subList(int fromIndex, int toIndex) {
		return null;
	}

	@Override
	public boolean retainAll(Collection c) {
		return false;
	}

	@Override
	public boolean removeAll(Collection c) {
		return false;
	}

	@Override
	public boolean containsAll(Collection c) {
		return false;
	}

	@Override
	public Object[] toArray(Object[] a) {
		return new Object[0];
	}

	@Override
	public boolean addAll(Collection c) {
		return false;
	}

	@Override
	public boolean addAll(int index, Collection c) {
		return false;
	}

	@Override
	public void clear() {

	}

	@Override
	public Object set(int index, Object element) {
		return null;
	}

	@Override
	public Object[] toArray() {
		return new Object[0];
	}

	@Override
	public Iterator iterator() {
//		return new LinkedListIterator<E>(this);
		return null;
	}

}
