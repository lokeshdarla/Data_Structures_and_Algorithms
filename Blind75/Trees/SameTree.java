package Blind75.Trees;

import Blind75.Trees.BinaryTree;

public class SameTree {

  static boolean isSame(TreeNode root1, TreeNode root2) {
    if (root1 == null && root2 == null) {
      return true;
    }

    if (root1 == null || root2 == null) {
      return false;
    }

    return (root1.data == root2.data
        && isSame(root1.leftTreeNode, root2.leftTreeNode)
        && isSame(root1.rightTreeNode, root2.rightTreeNode));
  }

  public static void main(String[] args) {
    BinaryTree tree1 = new BinaryTree(0);
    tree1.root.leftTreeNode = new TreeNode(1);
    tree1.root.rightTreeNode = new TreeNode(2);

    BinaryTree tree2 = new BinaryTree(0);
    tree2.root.leftTreeNode = new TreeNode(1);
    tree2.root.rightTreeNode = new TreeNode(2);

    System.out.println(isSame(tree1.root, tree2.root));
  }
}
