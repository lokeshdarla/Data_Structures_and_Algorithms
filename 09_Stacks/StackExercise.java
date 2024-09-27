import java.util.*;

public class StackExercise {
  public static void main(String a[]) {
    System.out.println("Hello World");

    Stack<Integer> stack = new Stack<>();

    // Push elements onto the stack
    stack.push(2);
    stack.push(3);
    stack.push(4);
    System.out.println("Stack after pushes: " + stack);

    // Pop an element from the stack
    stack.pop();
    System.out.println("Stack after pop: " + stack);

    // Peek at the top element
    System.out.println("Top element (peek): " + stack.peek());

    // Push another element
    stack.push(5);
    System.out.println("Stack after another push: " + stack);

    // Check if the stack is empty
    System.out.println("Is stack empty? " + stack.isEmpty());

    // Get the size of the stack
    System.out.println("Size of the stack: " + stack.size());

    // Pop all elements from the stack
    while (!stack.isEmpty()) {
      System.out.println("Popped: " + stack.pop());
    }

    // Check again if stack is empty
    System.out.println("Is stack empty after popping all elements? " + stack.isEmpty());
  }
}
