package Blind75.Trees;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

  static void levelOrderTraversal(TreeNode node) {
    if (node == null) {
      return;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(node);
    while (!queue.isEmpty()) {
      TreeNode currentNode = queue.poll();
      System.out.print(currentNode.data + " ");

      if (currentNode.leftTreeNode != null) {
        queue.add(currentNode.leftTreeNode);
      }

      if (currentNode.rightTreeNode != null) {
        queue.add(currentNode.rightTreeNode);
      }
    }
  }

  public static void main(String[] args) {
    BinaryTree tree = new BinaryTree(0);
    tree.root.leftTreeNode = new TreeNode(1);
    tree.root.rightTreeNode = new TreeNode(2);
    tree.root.leftTreeNode.leftTreeNode = new TreeNode(3);
    tree.root.leftTreeNode.rightTreeNode = new TreeNode(4);
    tree.root.rightTreeNode.leftTreeNode = new TreeNode(5);
    tree.root.rightTreeNode.rightTreeNode = new TreeNode(6);

    levelOrderTraversal(tree.root);
  }

}
