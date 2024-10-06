package Blind75.Trees;

import Blind75.Trees.BinaryTree;

public class InvertTree {

  static void invertTree(TreeNode node) {
    if (node == null) {
      return;
    }

    TreeNode temp = node.leftTreeNode;
    node.leftTreeNode = node.rightTreeNode;
    node.rightTreeNode = temp;

    invertTree(node.leftTreeNode);
    invertTree(node.rightTreeNode);
  }

  public static void main(String[] args) {
    BinaryTree tree = new BinaryTree(0);
    tree.root.leftTreeNode = new TreeNode(1);
    tree.root.rightTreeNode = new TreeNode(2);
    tree.root.leftTreeNode.leftTreeNode = new TreeNode(3);
    tree.root.leftTreeNode.rightTreeNode = new TreeNode(4);
    tree.root.rightTreeNode.leftTreeNode = new TreeNode(5);
    tree.root.rightTreeNode.rightTreeNode = new TreeNode(6);

    System.out.println("Before inversion:");
    tree.PreorderTraversal(tree.root);
    System.out.println();

    invertTree(tree.root);

    System.out.println("After inversion:");
    tree.PreorderTraversal(tree.root);
    System.out.println();
  }
}
