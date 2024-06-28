public class LinkedListScratch {
  class Node {
    int data;
    Node next;

    Node(int data) {
      this.data = data;
      this.next = null;
    }
  }

  private Node head;
  private int length;

  LinkedListScratch() {
    this.head = null;
    this.length = 0;
  }

  // Method to add a node at the end
  public void add(int data) {
    Node node = new Node(data);
    if (head == null) {
      head = node;
    } else {
      Node temp = head;
      while (temp.next != null) {
        temp = temp.next;
      }
      temp.next = node;
    }
    this.length++;
  }

  // Method to display the linked list
  public void display() {
    Node temp = this.head;
    while (temp != null) {
      System.out.print(temp.data + " -> ");
      temp = temp.next;
    }
    System.out.println("null");
  }

  // Method to find if a data is present in the list
  public boolean find(int data) {
    Node temp = this.head;
    while (temp != null) {
      if (temp.data == data) {
        return true;
      }
      temp = temp.next; // Update temp to the next node
    }
    return false;
  }

  // Method to check if the list is empty
  public boolean isEmpty() {
    return this.length == 0;
  }

  // Method to get the size of the list
  public int size() {
    return this.length;
  }

  // Method to remove a node with specific data
  public void remove(int data) {
    if (this.head == null) {
      return;
    }
    if (head.data == data) {
      head = head.next; // Update head to the next node
      length--;
      return;
    }
    Node temp = this.head;
    while (temp.next != null) {
      if (temp.next.data == data) {
        temp.next = temp.next.next;
        length--;
        return;
      }
      temp = temp.next;
    }
    System.out.println("Data not found in the linked list");
  }

  public int get(int index) {
    int i = -1;
    Node currNode = this.head;
    while (currNode != null) {
      i++;
      if (index == i) {
        return currNode.data;
      }
      currNode = currNode.next;
    }
    return -1;
  }

  public int set(int index, int data) {
    int i = -1;
    Node currNode = this.head;
    while (currNode != null) {
      i++;
      if (index == i) {
        return currNode.data;
      }
      currNode = currNode.next;
    }
    return -1;
  }

  public static void main(String[] args) {
    LinkedListScratch list = new LinkedListScratch();
    System.out.println("Initial linked list:");
    list.display();

    // Test add method
    list.add(10);
    list.add(20);
    list.add(30);
    list.add(40);
    list.add(50);
    for (int i = 0; i < list.size(); i++) {
      System.out.println(list.get(i));
    }
    System.out.println("Linked list after adding elements:");
    list.display();

    // Test size method
    System.out.println("Size of the list: " + list.size());

    // Test find method
    System.out.println("Finding element 20: " + list.find(20)); // Should return true
    System.out.println("Finding element 60: " + list.find(60)); // Should return false

    // Test isEmpty method
    System.out.println("Is the list empty? " + list.isEmpty()); // Should return false

    // Test remove method
    list.remove(30);
    System.out.println("Linked list after removing element 30:");
    list.display();
    list.remove(10);
    System.out.println("Linked list after removing element 10:");
    list.display();
    list.remove(50);
    System.out.println("Linked list after removing element 50:");
    list.display();

    // Test edge cases
    list.remove(100); // Attempt to remove an element not in the list
    System.out.println("Linked list after attempting to remove element not in the list:");
    list.display();
    list.remove(20);
    list.remove(40);
    list.remove(20); // Attempt to remove the same element again
    System.out.println("Linked list after removing all elements:");
    list.display();
    System.out.println("Is the list empty? " + list.isEmpty()); // Should return true
  }
}
