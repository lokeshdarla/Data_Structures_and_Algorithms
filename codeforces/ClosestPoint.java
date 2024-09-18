import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long t = scanner.nextLong();
        while (t-- > 0) {
            long n = scanner.nextLong();
            long a = 0, b = 0;

            for (long p = 0; p < n; p++) {
                b = a;
                a = scanner.nextLong();
            }

            if (n == 2 && (b - a > 1 || b - a < -1)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

        scanner.close();
    }
}
