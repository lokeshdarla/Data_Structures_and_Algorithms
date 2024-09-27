
public class MinAddToMakeValid {

  public static int minAddToMakeValid(String s) {
    int open = 0;
    int close = 0;

    for (char ch : s.toCharArray()) {
      if (ch == '(') {
        open++;
      } else if (ch == ')') {
        if (open > 0) {
          open--;
        } else {
          close++;
        }

      }
    }

    return open + close;
  }

  public static void main(String[] args) {
    String s1 = "())";
    System.out.println("Minimum add to make valid for '" + s1 + "': " + minAddToMakeValid(s1)); // Output: 1

    String s2 = "(((";
    System.out.println("Minimum add to make valid for '" + s2 + "': " + minAddToMakeValid(s2)); // Output: 3

    String s3 = "()";
    System.out.println("Minimum add to make valid for '" + s3 + "': " + minAddToMakeValid(s3)); // Output: 0

    String s4 = "()))((";
    System.out.println("Minimum add to make valid for '" + s4 + "': " + minAddToMakeValid(s4)); // Output: 4
  }
}
