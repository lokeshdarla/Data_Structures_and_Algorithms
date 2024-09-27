import java.util.*;

public class QueueUsingStack {
  private Stack<Integer> stack1;
  private Stack<Integer> stack2;

  public QueueUsingStack() {
    stack1 = new Stack<>();
    stack2 = new Stack<>();
  }

  public void enqueue(int value) {
    stack1.push(value);
    System.out.println("Enqueued: " + value);
  }

  public int dequeue() {
    if (stack1.isEmpty() && stack2.isEmpty()) {
      System.out.println("Queue is empty. Cannot dequeue");
      return -1;
    }

    if (stack2.isEmpty()) {
      while (!stack1.isEmpty()) {
        stack2.push(stack1.pop());
      }
    }

    return stack2.pop();
  }

  public int peek() {
    if (stack1.isEmpty() && stack2.isEmpty()) {
      System.out.println("Queue is empty. Cannot peek");
      return -1;
    }

    if (stack2.isEmpty()) {
      while (!stack1.isEmpty()) {
        stack2.push(stack1.pop());
      }
    }

    return stack2.peek();
  }

  public boolean isEmpty() {
    return stack1.isEmpty() && stack2.isEmpty();
  }

  public static void main(String[] args) {
    QueueUsingStack queue = new QueueUsingStack();

    queue.enqueue(10);
    queue.enqueue(20);
    queue.enqueue(30);
    queue.enqueue(40);

    System.out.println("Dequeued: " + queue.dequeue());
    System.out.println("Dequeued: " + queue.dequeue());

    System.out.println("Front element is: " + queue.peek());

    queue.enqueue(50);

    while (!queue.isEmpty()) {
      System.out.println("Dequeued: " + queue.dequeue());
    }

    queue.dequeue();
  }

}
