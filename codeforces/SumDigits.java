import java.util.Scanner;

public class SumDigits {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int t = scanner.nextInt();

    for (int i = 0; i < t; i++) {
      int n = scanner.nextInt();
      int a = n % 10;
      n = n / 10;
      a += n % 10;

      System.out.println(a);
    }

    scanner.close();
  }
}
