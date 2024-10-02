package Blind75.LinkedList;

public class ListNode {
  int val;
  ListNode next;

  ListNode() {
  };

  ListNode(int val) {
    this.val = val;
    next = null;
  }

  ListNode(int val, ListNode nextNode) {
    this.val = val;
    this.next = nextNode;
  }
}
