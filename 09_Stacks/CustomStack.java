public class CustomStack {
  private int maxSize;
  private int[] stackArray;
  private int top;

  public CustomStack(int size) {
    this.maxSize = size;
    this.stackArray = new int[maxSize];
    top = -1;
  }

  public boolean isFull() {
    return (this.top == this.maxSize - 1);
  }

  public boolean isEmpty() {
    return (this.top == -1);
  }

  public void push(int value) {
    if (this.isFull()) {
      System.out.println("Stack overflow");
    } else {
      this.stackArray[++this.top] = value;
      System.out.println("Pushed " + value + " to stack");
    }
  }

  public int pop() {
    if (this.isEmpty()) {
      System.out.println("Stack is Empty");
      return -1;
    } else {
      return this.stackArray[this.top--];
    }
  }

  public int peek() {
    if (this.isEmpty()) {
      System.err.println("Stack is Empty");
      return -1;
    } else {
      return this.stackArray[this.top];
    }
  }

  public static void main(String[] args) {
    CustomStack stack = new CustomStack(5); // Create a stack of size 5

    stack.push(10);
    stack.push(20);
    stack.push(30);
    stack.push(40);
    stack.push(50);
    stack.push(60); // Stack is full here

    System.out.println("Top element is: " + stack.peek());

    System.out.println("Popped element: " + stack.pop());
    System.out.println("Top element after pop: " + stack.peek());

    // Pop all elements
    while (!stack.isEmpty()) {
      System.out.println("Popped: " + stack.pop());
    }

    // Trying to pop from an empty stack
    stack.pop();
  }

}
