package Blind75.LinkedList;

public class DetectCycleI {

  boolean detectCycleI(ListNode head) {
    ListNode fast = head;
    ListNode slow = head;

    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;

      if (fast == slow) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] a) {
    DetectCycleI solution = new DetectCycleI();

    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);

    head.next.next.next.next.next = head.next;

    boolean hasCycle = solution.detectCycleI(head);
    System.out.println("Cycle detected: " + hasCycle);
  }
}
