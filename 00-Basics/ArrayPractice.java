import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ArrayPractice {
  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<Integer>();
    list.add(22);
    list.add(3);

    System.out.println(list.size());

    // get elements
    System.out.println(list.get(0));

    // to add element between
    list.add(1, 25);
    System.out.println(list);

    list.sort(new Comparator<Integer>() {
      public int compare(Integer a, Integer b) {
        return a - b;
      }
    });

    Collections.sort(list);
    System.out.println(list);
  }
}
