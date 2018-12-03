package datastructure.linkedstore.shuangxianglianbiao;

/**
 * Created by YuChen on 2018/3/26 0026
 *
 * 双向链表的节点定义
 */
public interface Node<E> {

	//获取结点数据域
	public E getData();

	//设置结点数据域
	public void setData(E e);
}
