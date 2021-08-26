package java_.map.mymap1_8;

/**
 * 模拟红黑树 也就是1.8 hashMap底层用到的 <br>
 * 红黑树：变色、左旋、右旋
 *
 * @author Administrator
 * @date 2020-02-23
 */
public class RedBlackTree {

  /** 存的值 */
  private int data;

  /** 根节点 */
  private RedBlackTree root;

  /** 左树 */
  private RedBlackTree left;

  /** 右树 */
  private RedBlackTree right;

  /** 父亲节点 */
  private RedBlackTree parent;

  /** 颜色 */
  private String color;

  /** 指针 */
  private RedBlackTree pointer;

  public void insertNode(int value) {
    // 根节点  ---这边可以放到初始化里面
    if (this.root == null) {
      RedBlackTree newNode = initNode(value, true);
      this.root = newNode;
      return;
    }
    insertNode(this.root, value);
    changeColor();
  }

  private void insertNode(RedBlackTree root, int value) {
    // 非根节点要在添加在左右树下
    if (value > root.data) {
      RedBlackTree right = root.right;
      if (right == null) root.right = initNode(value, false, root);
      else insertNode(right, value);
    } else {
      RedBlackTree left = root.left;
      if (left == null) root.left = initNode(value, false, root);
      else insertNode(left, value);
    }
  }

  private void changeColor() {
    // 叔叔节点和父亲节点都是红色 需要变色
    if (pointer.parent != null && pointer.parent.parent != null) {
      // 叔叔节点
      RedBlackTree uncle =
          pointer.parent.parent.left == pointer.parent
              ? pointer.parent.parent.right
              : pointer.parent.parent.left;
      RedBlackTree father = pointer.parent;
      if (pointer.parent.color.equals(Constants.RED)
          && (uncle == null || uncle.color.equals(Constants.RED))) {}
      // 变色
      father.color = Constants.BLACK;
      if (uncle != null) uncle.color = Constants.BLACK;
      pointer.parent.parent.color = Constants.RED;
      // 递归向上
      pointer = pointer.parent.parent;
      changeColor();
    }
  }

  /**
   * 初始化一个节点
   *
   * @param value 存的值
   * @param isRoot 是否是根节点
   * @return
   */
  private RedBlackTree initNode(int value, boolean isRoot) {
    RedBlackTree node = new RedBlackTree();
    if (isRoot) {
      this.root = node;
      node.color = Constants.BLACK;
    } else {
      node.root = root;
      node.color = Constants.RED;
      this.pointer = node; // 添加字节点的时候 指针指向这里
    }
    node.data = value;
    return node;
  }

  private RedBlackTree initNode(int value, boolean isRoot, RedBlackTree parent) {
    RedBlackTree newNode = initNode(value, false);
    newNode.parent = parent;
    return newNode;
  }

  public static void main(String[] args) {
    RedBlackTree tree = new RedBlackTree();
    tree.insertNode(1);
    tree.insertNode(2);
    tree.insertNode(3);
  }
}
