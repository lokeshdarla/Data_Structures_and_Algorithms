package CollectionFramework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ArrayListExercise {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        // Print original list
        System.out.println("Original list: " + list);

        // Add element at specific index
        list.add(2, 200);
        System.out.println("After adding 200 at index 2: " + list);

        // Remove element at specific index
        list.remove(1);
        System.out.println("After removing element at index 1: " + list);

        // Get an element
        System.out.println("Element at index 2: " + list.get(2));

        // Check size
        System.out.println("Size of the list: " + list.size());

        // Check if list contains an element
        System.out.println("List contains 200: " + list.contains(200));

        // Find index of an element
        System.out.println("Index of 200: " + list.indexOf(200));

        // Create a sublist
        List<Integer> subList = list.subList(1, 3);
        System.out.println("Sublist from index 1 to 2: " + subList);

        // Add all elements from another collection
        List<Integer> additional = Arrays.asList(5, 6, 7);
        list.addAll(additional);
        System.out.println("After adding additional elements: " + list);

        // Sort the list
        list.sort((x,y)->Integer.compare(x, y));
        System.out.println("Sorted list: " + list);

        // Use stream to filter and print elements
        list.stream().filter(x -> x > 2).forEach(System.out::println);
        list.stream().filter(x->x>4).forEach(System.out::println);
    }
}
