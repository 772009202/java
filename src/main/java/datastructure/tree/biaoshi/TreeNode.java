package datastructure.tree.biaoshi;

/**
 * Created by YuChen on 2018/3/30 0030
 *
 * 树的结点表示方法
 */
public class TreeNode {

	private Object element;

	private int parent;

	private Node childNode;

	//子结点的线性存储
	private class Node{
		private int element;//索引
		private Node next; //下一个子结点
	}

}
