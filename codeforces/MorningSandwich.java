import java.util.Scanner;

public class MorningSandwich {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int t = scanner.nextInt();

    for (int i = 0; i < t; i++) {
      int b = scanner.nextInt();
      int c = scanner.nextInt();
      int h = scanner.nextInt();

      if (c + h <= b - 1) {
        System.out.println(2 * (c + h) + 1);
      } else {
        System.out.println(2 * b - 1);
      }
    }

    scanner.close();
  }
}
