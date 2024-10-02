package Blind75.LinkedList;

public class MergeKSorted {

  static ListNode mergeTwoLists(ListNode head1, ListNode head2) {
    ListNode dummy = new ListNode(0);
    ListNode current = dummy;

    while (head1 != null && head2 != null) {
      if (head1.val <= head2.val) {
        current.next = head1;
        head1 = head1.next;
      } else {
        current.next = head2;
        head2 = head2.next;
      }
      current = current.next;
    }

    if (head1 != null) {
      current.next = head1;
    }
    if (head2 != null) {
      current.next = head2;
    }

    return dummy.next;
  }

  static ListNode mergeKSorted(ListNode[] nodes) {
    if (nodes == null || nodes.length == 0)
      return null;

    ListNode mergedList = nodes[0];
    for (int i = 1; i < nodes.length; i++) {
      mergedList = mergeTwoLists(mergedList, nodes[i]);
    }

    return mergedList;
  }

  public static void main(String[] a) {
    System.out.println("Hello World");
    // You can add test cases here to test the mergeKSorted method
  }
}
