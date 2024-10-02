package Blind75.Binary;

public class MissingNumber {

  // alternatively we can use math logic
  public static void main(String args[]) {
    int[] arr = { 1, 2, 4, 0 };

    int n = 4;
    int result = 0;
    for (int i = 0; i <= n; i++) {
      result = result ^ i;
    }
    for (int num : arr) {
      result = result ^ num;
    }

    System.out.println(result);
  }
}
