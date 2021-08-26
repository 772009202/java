package algorithm.dfs.middleorder;

import java.util.ArrayList;
import java.util.List;

/**
 * 中序遍历
 *
 * @author chenyu
 * @date 2021-07-15
 */
public class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {}

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}

class Solution {

  private List<Integer> list = new ArrayList<>();

  public List<Integer> inorderTraversal(TreeNode root) {
    if (root == null) {
      return list;
    }
    inorderTraversal2(root);
    return list;
  }

  public void inorderTraversal2(TreeNode root) {
    if (root.left != null) {
      inorderTraversal2(root.left);
    }
    list.add(root.val);

    if (root.right != null) {
      inorderTraversal2(root.right);
    }
  }
}
