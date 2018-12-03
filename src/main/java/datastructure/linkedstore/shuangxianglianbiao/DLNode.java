package datastructure.linkedstore.shuangxianglianbiao;

/**
 * Created by YuChen on 2018/3/26 0026
 */
public class DLNode<E> implements Node<E> {

	private E element;

	private DLNode next;

	private DLNode pre;

	public DLNode(E element, DLNode next, DLNode pre) {
		this.element = element;
		this.next = next;
		this.pre = pre;
	}

	public DLNode(){
		this(null, null, null);
	}

	@Override
	public E getData() {
		return element;
	}

	@Override
	public void setData(E e) {
		element = e;
	}

	public void setNext(DLNode next) {
		this.next = next;
	}

	public DLNode getNext() {
		return next;
	}

	public void setPre(DLNode pre) {
		this.pre = pre;
	}

	public DLNode getPre() {
		return pre;
	}

}
