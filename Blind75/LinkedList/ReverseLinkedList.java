package Blind75.LinkedList;

public class ReverseLinkedList {

  ListNode reverseLinkedList(ListNode head) {
    ListNode curr = head;
    ListNode prev = null;
    ListNode next = null;

    while (curr != null) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    return prev;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);

    ReverseLinkedList solution = new ReverseLinkedList();
    ListNode reversedHead = solution.reverseLinkedList(head);

    ListNode current = reversedHead;
    while (current != null) {
      System.out.print(current.val + " ");
      current = current.next;
    }
  }
}
