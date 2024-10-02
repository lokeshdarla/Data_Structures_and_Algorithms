package Blind75.LinkedList;

public class DetectCycleII {

  ListNode DetectCycleII(ListNode head) {
    ListNode fast = head;
    ListNode slow = head;
    ListNode temp = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      if (fast == slow) {
        while (slow != temp) {
          slow = slow.next;
          temp = temp.next;
        }
        return temp;
      }
    }
    return null;

  }

  public static void main(String[] a) {
    DetectCycleII solution = new DetectCycleII();
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);

    head.next.next.next.next.next = head.next;

    ListNode cycleStart = solution.DetectCycleII(head);
    if (cycleStart != null) {
      System.out.println("Cycle detected at node with value: " + cycleStart.val);
    } else {
      System.out.println("No cycle detected.");
    }
  }

}
