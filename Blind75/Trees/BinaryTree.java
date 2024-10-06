package Blind75.Trees;

import Blind75.Trees.TreeNode;

public class BinaryTree {
  public TreeNode root;

  public BinaryTree(int data) {
    this.root = new TreeNode(data);
  }

  public void InorderTraversal(TreeNode node) {
    if (node != null) {
      this.InorderTraversal(node.leftTreeNode);
      System.out.print(node.data + " ");
      this.InorderTraversal(node.rightTreeNode);
    }
  }

  public void PreorderTraversal(TreeNode node) {
    if (node != null) {
      System.out.print(node.data + " ");
      this.PreorderTraversal(node.leftTreeNode);
      this.PreorderTraversal(node.rightTreeNode);
    }
  }

  public int height(TreeNode node) {
    if (node == null) {
      return 0;
    }
    return Math.max(height(node.leftTreeNode), height(node.rightTreeNode)) + 1;
  }
}
