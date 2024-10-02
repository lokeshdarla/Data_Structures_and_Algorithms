package Blind75.LinkedList;

public class MergeTwoSorted {

  public ListNode mergerTwoSorted(ListNode head1, ListNode head2) {
    ListNode temp1 = head1;
    ListNode temp2 = head2;
    ListNode dummy = new ListNode(0);
    ListNode current = dummy;

    while (temp1 != null && temp2 != null) {
      if (temp1.val <= temp2.val) {
        current.next = temp1;
        temp1 = temp1.next;
      } else {
        current.next = temp2;
        temp2 = temp2.next;
      }
      current = current.next;
    }

    if (temp1 != null) {
      current.next = temp1;
    } else if (temp2 != null) {
      current.next = temp2;
    }

    return dummy.next;
  }

  public static void main(String[] args) {

    ListNode head1 = new ListNode(1);
    head1.next = new ListNode(3);
    head1.next.next = new ListNode(5);

    ListNode head2 = new ListNode(2);
    head2.next = new ListNode(4);
    head2.next.next = new ListNode(6);

    MergeTwoSorted merger = new MergeTwoSorted();
    ListNode mergedHead = merger.mergerTwoSorted(head1, head2);

    System.out.print("Merged Linked List: ");
    printList(mergedHead);
  }

  public static void printList(ListNode head) {
    ListNode current = head;
    while (current != null) {
      System.out.print(current.val + " ");
      current = current.next;
    }
    System.out.println();
  }
}
