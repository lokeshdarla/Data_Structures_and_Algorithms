import java.util.LinkedList;

public class LinkedListUtil {

  public static void main(String[] args) {
    LinkedList<Integer> list = new LinkedList<Integer>();
    System.out.println("Initial linked list:");
    System.out.println(list);

    // Test add method
    list.add(10);
    list.add(20);
    list.add(30);
    list.add(40);
    list.add(50);
    System.out.println("Linked list after adding elements:");
    System.out.println(list);

    // Test size method
    System.out.println("Size of the list: " + list.size());
    System.out.println("Is the list empty? " + list.isEmpty()); // Should return false

    // Test remove method
    list.remove(30);
    System.out.println("Linked list after removing element 30:");
    System.out.println(list);
    list.removeFirst(); // Remove the first element
    System.out.println("Linked list after removing first element:");
    System.out.println(list);

    // Test get method
    System.out.println("Element at index 2: " + list.get(2)); // Should return 40

    // Test set method
    System.out.println("Previous element at index 3: " + list.set(3, 100)); // Should return 50
    System.out.println("Linked list after setting element at index 3 to 100:");
    System.out.println(list);
  }
}
