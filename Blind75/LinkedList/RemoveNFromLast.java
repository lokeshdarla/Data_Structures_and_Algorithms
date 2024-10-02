package Blind75.LinkedList;

public class RemoveNFromLast {
  static class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  public ListNode removeNFromLast(int n, ListNode head) {

    ListNode dummy = new ListNode(0);
    dummy.next = head;

    ListNode fast = dummy;
    ListNode slow = dummy;

    for (int i = 0; i <= n; i++) {
      if (fast != null) {
        fast = fast.next;
      } else {

        return head;
      }
    }

    while (fast != null) {
      fast = fast.next;
      slow = slow.next;
    }

    slow.next = slow.next.next;

    return dummy.next;
  }

  private static void printList(ListNode head) {
    ListNode curr = head;
    while (curr != null) {
      System.out.print(curr.val + " ");
      curr = curr.next;
    }
    System.out.println();
  }

  public static void main(String[] args) {
    ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
    RemoveNFromLast solution = new RemoveNFromLast();
    ListNode modifiedHead1 = solution.removeNFromLast(2, head1);

    System.out.print("Modified List 1: ");
    printList(modifiedHead1);

    ListNode head2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
    ListNode modifiedHead2 = solution.removeNFromLast(5, head2);

    System.out.print("Modified List 2: ");
    printList(modifiedHead2);

    ListNode head3 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
    ListNode modifiedHead3 = solution.removeNFromLast(1, head3);

    System.out.print("Modified List 3: ");
    printList(modifiedHead3);

    ListNode head4 = null;
    ListNode modifiedHead4 = solution.removeNFromLast(1, head4);

    System.out.print("Modified List 4: ");
    printList(modifiedHead4);

    ListNode head5 = new ListNode(1, new ListNode(2, new ListNode(3)));
    ListNode modifiedHead5 = solution.removeNFromLast(5, head5);

    System.out.print("Modified List 5: ");
    printList(modifiedHead5);

  }

}
