import java.util.Scanner;

public class RatingIncrease {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int numTests = scanner.nextInt();
    scanner.nextLine(); // consume the newline after the integer input

    while (numTests-- > 0) {
      String inputString = scanner.nextLine();

      boolean canSplit = false;
      long firstNumber = 0, secondNumber = 0;

      for (int position = 1; position < inputString.length(); position++) {
        if (inputString.charAt(position) == '0')
          continue;

        firstNumber = Long.parseLong(inputString.substring(0, position));
        secondNumber = Long.parseLong(inputString.substring(position));

        if (firstNumber < secondNumber) {
          canSplit = true;
          break;
        }
      }

      if (canSplit) {
        System.out.println(firstNumber + " " + secondNumber);
      } else {
        System.out.println(-1);
      }
    }

    scanner.close();
  }
}
