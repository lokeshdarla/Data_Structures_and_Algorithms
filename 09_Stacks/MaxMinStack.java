import java.util.*;

public class MaxMinStack {
  private Stack<Integer> mainStack;
  private Stack<Integer> minStack;
  private Stack<Integer> maxStack;

  public MaxMinStack() {
    mainStack = new Stack<>();
    minStack = new Stack<>();
    maxStack = new Stack<>();
  }

  public void push(int value) {
    mainStack.push(value);

    if (maxStack.isEmpty() || value >= maxStack.peek()) {
      maxStack.push(value);
    }
    if (minStack.isEmpty() || value <= minStack.peek()) {
      minStack.push(value);
    }

    System.out.println("Pushed: " + value);
  }

  public int pop() {
    if (mainStack.isEmpty()) {
      System.out.println("Stack is empty, Cannot pop");
      return -1;
    }

    int poppedValue = mainStack.pop();

    if (poppedValue == maxStack.peek()) {
      maxStack.pop();
    }

    if (poppedValue == minStack.peek()) {
      minStack.pop();
    }

    return poppedValue;
  }

  public int getMax() {
    if (maxStack.isEmpty()) {
      System.out.println("Stack is empty, No maximum value.");
      return -1;
    }

    return maxStack.peek();
  }

  public int getMin() {
    if (minStack.isEmpty()) {
      System.out.println("Stack is empty, No minimum value");
      return -1;
    }

    return minStack.peek();
  }

  public static void main(String[] args) {
    MaxMinStack stack = new MaxMinStack();

    stack.push(10);
    stack.push(20);
    stack.push(5);
    stack.push(30);
    stack.push(15);

    System.out.println("Current Max: " + stack.getMax()); // Output: 30
    System.out.println("Current Min: " + stack.getMin()); // Output: 5

    stack.pop(); // Pops 15
    System.out.println("Current Max after pop: " + stack.getMax()); // Output: 30
    System.out.println("Current Min after pop: " + stack.getMin()); // Output: 5

    stack.pop(); // Pops 30
    System.out.println("Current Max after pop: " + stack.getMax()); // Output: 20
    System.out.println("Current Min after pop: " + stack.getMin()); // Output: 5

    stack.pop(); // Pops 5
    System.out.println("Current Max after pop: " + stack.getMax()); // Output: 20
    System.out.println("Current Min after pop: " + stack.getMin()); // Output: 10
  }
}
