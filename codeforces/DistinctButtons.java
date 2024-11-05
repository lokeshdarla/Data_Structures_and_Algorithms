import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
  static class Pair {
    long first;
    long second;

    Pair(long first, long second) {
      this.first = first;
      this.second = second;
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String input = scanner.next();
    scanner.close();

    ArrayList<Pair> positionPairs = new ArrayList<>();
    long balanceCount = 0;

    for (int idx = 0; idx < input.length(); idx++) {
      positionPairs.add(new Pair(balanceCount, idx));
      balanceCount += (input.charAt(idx) == '(') ? 1 : (input.charAt(idx) == ')') ? -1 : 0;
    }

    // Sort the pairs based on custom comparator
    Collections.sort(positionPairs, new Comparator<Pair>() {
      @Override
      public int compare(Pair a, Pair b) {
        if (a.first == b.first) {
          return Long.compare(b.second, a.second); // descending order of second when first is equal
        }
        return Long.compare(a.first, b.first); // ascending order of first
      }
    });

    StringBuilder output = new StringBuilder(input.length());
    for (int i = 0; i < input.length(); i++) {
      output.append('.');
    }

    for (int idx = 0; idx < positionPairs.size(); idx++) {
      output.setCharAt(idx, input.charAt((int) positionPairs.get(idx).second));
    }

    System.out.println(output);
  }
}
