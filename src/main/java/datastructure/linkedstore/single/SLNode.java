package datastructure.linkedstore.single;

import lang.Object;

/**
 * Created by YuChen on 2018/3/26 0026
 *
 * 单向链表结点定义
 */
public class SLNode<E> implements Node<E>{

	//数据域
	private E element;

	//下一个结点
	private SLNode next;

	public SLNode(E element, SLNode next) {
		this.element = element;
		this.next = next;
	}

	public SLNode() {
		this(null, null);
	}

	@Override
	public E getData() {
		return element;
	}

	@Override
	public void setData(E element) {
		this.element = element;
	}

	public void setNext(SLNode next) {
		this.next = next;
	}

	public SLNode getNext() {
		return next;
	}

}
