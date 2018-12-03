package datastructure.tree.ercha;

/**
 * Created by YuChen on 2018/3/9 0009
 *
 * 树的操作接口
 */
public interface Tree {

	int getSize();

	boolean isEmpty();

	TreeNode getRoot();

	int getHeight();

	TreeNode find(Object object);

	void preOrder();

	void inOrder();

	void postOrder();

	void levelOrder();
}
