import java.util.Scanner;

public class TowerBuilder {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int t = scanner.nextInt();

    for (int i = 0; i < t; i++) {
      int n = scanner.nextInt();
      int m = scanner.nextInt();

      if (m >= 0 && m <= n && (n % 2 == m % 2)) {
        System.out.println("Yes");
      } else {
        System.out.println("No");
      }
    }

    scanner.close();
  }
}
