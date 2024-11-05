import java.util.Scanner;

public class StrongPassword {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int t = scanner.nextInt();
    scanner.nextLine(); // consume newline
    while (t > 0) {
      String s = scanner.nextLine();
      int siz = s.length();
      boolean flag = false;
      char c;

      for (int i = 0; i < siz - 1; i++) {
        if (s.charAt(i) == s.charAt(i + 1)) {
          // Insert at i + 1
          int l = s.charAt(i + 1) - 1;
          if (l == 96) {
            l = 122; // If 'a' is decremented, wrap around to 'z'
          }
          c = (char) l;
          s = s.substring(0, i + 1) + c + s.substring(i + 1);
          flag = true;
          break;
        }
      }
      if (!flag) {
        // Insert at position 0
        int l = s.charAt(0) - 1;
        if (l == 96) {
          l = 122;
        }
        c = (char) l;
        s = c + s;
      }

      System.out.println(s);
      t--;
    }
    scanner.close();
  }
}
