package Blind75.LinkedList;

public class ReorderList {

  public ListNode reorderList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode fast = head;
    ListNode slow = head;
    while (fast.next != null && fast.next.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }

    ListNode secondHalf = slow.next;
    slow.next = null;
    secondHalf = reverseList(secondHalf);

    ListNode firstHalf = head;
    ListNode dummy = new ListNode(0);
    ListNode current = dummy;

    while (firstHalf != null || secondHalf != null) {
      if (firstHalf != null) {
        current.next = firstHalf;
        firstHalf = firstHalf.next;
        current = current.next;
      }
      if (secondHalf != null) {
        current.next = secondHalf;
        secondHalf = secondHalf.next;
        current = current.next;
      }
    }

    return dummy.next;
  }

  private ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;
    while (curr != null) {
      ListNode nextTemp = curr.next;
      curr.next = prev;
      prev = curr;
      curr = nextTemp;
    }
    return prev;
  }

  public static void main(String[] args) {

    ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

    ReorderList solution = new ReorderList();
    ListNode modifiedHead = solution.reorderList(head);

    System.out.print("Reordered List: ");
    printList(modifiedHead);
  }

  private static void printList(ListNode head) {
    ListNode curr = head;
    while (curr != null) {
      System.out.print(curr.val + " ");
      curr = curr.next;
    }
    System.out.println();
  }
}
