package map.mymap1_8;

/**
 * 手写一个二叉树(有序才有意义)
 *
 * @author Administrator
 * @date 2020-02-22
 */
public class MyBinaryTree {

  /** 节点的数据 */
  int data;

  /** 左分支 小于data的 */
  private MyBinaryTree left;

  /** 右分支 大于data的 */
  private MyBinaryTree right;

  public MyBinaryTree(int date) {
    this.data = date;
  }

  /**
   * @param root 被添加的树
   * @param newData 新节点的数据
   */
  public void setNode(MyBinaryTree root, int newData) {
    if (root != null) {
      // 添进右树
      if (newData > root.data) {
        if (root.right != null) setNode(root.right, newData); // 右树有节点 递归一直添加到底层
        else root.right = new MyBinaryTree(newData); // 右节点没有直接添加到右树
      } else if (newData < root.data) {
        if (root.left != null) setNode(root.left, newData); // 右树有节点 递归一直添加到底层
        else root.left = new MyBinaryTree(newData); // 右节点没有直接添加到右树
      }
    }
  }

  /** 打印这颗树 */
  public void console(MyBinaryTree root) {
    if (root != null) {
      console(root.left);
      System.out.println(root.data);
      console(root.right);
    }
  }

  public static void main(String[] args) {
    int[] datas = {3, 4, 2, 1, 7, 8};
    MyBinaryTree root = new MyBinaryTree(datas[0]);
    for (int i = 1; i < datas.length; i++) {
      root.setNode(root, datas[i]);
    }
    root.console(root);
  }
}
