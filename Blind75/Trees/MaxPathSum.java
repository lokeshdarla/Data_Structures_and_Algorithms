package Blind75.Trees;

public class MaxPathSum {
  private int maxSum;

  public int maxPathSum(TreeNode root) {
    maxSum = Integer.MIN_VALUE;
    maxPathSumHelper(root);
    return maxSum;
  }

  int maxPathSumHelper(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int leftSum = Math.max(maxPathSumHelper(root.left), 0);
    int rightSum = Math.max(maxPathSumHelper(root.right), 0);

    maxSum = Math.max(maxSum, leftSum + rightSum + root.data);

    return root.data + Math.max(leftSum, rightSum);
  }

  public static void main(String[] args) {

    TreeNode tree = new BinaryTree(0);
    tree.root.left = new TreeNode(1);
    tree.root.right = new TreeNode(2);
    tree.root.left.left = new TreeNode(3);
    tree.root.left.right = new TreeNode(4);
    tree.root.right.left = new TreeNode(5);
    tree.root.right.right = new TreeNode(6);

    MaxPathSum mps = new MaxPathSum();
    System.out.println("Maximum Path Sum: " + mps.maxPathSum(tree.root));
  }
}
