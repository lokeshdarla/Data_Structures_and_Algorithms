import java.util.Scanner;

public class check_for_prime {

  public static boolean isPrime(int n) {
    if (n <= 1) {
      return false;
    } else if (n == 2 || n == 3)
      return true;
    else if (n % 2 == 0 || n % 3 == 0) {
      return false;
    } else {
      for (int i = 5; i * i <= n; i++) {
        if (n % i == 0 || n % (i + 2) == 0) {
          return false;
        }
      }
    }
    return true;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter the number: ");
    int n = scanner.nextInt();
    System.out.println("Hello World " + n);
    if (isPrime(n)) {
      System.out.println(n + " is a Prime");
    } else {
      System.out.println(n + " is not a Prime");
    }
    scanner.close();
  }
}
