package Blind75.Binary;

public class CountBits {
  static int countSetBits(int n) {
    int count = 0;
    while (n > 0) {
      n = n & (n - 1);
      count++;
    }
    return count;
  }

  public static void main(String args[]) {
    int n = 5;
    int arr[] = new int[n + 1];
    for (int i = 0; i <= n; i++) {
      arr[i] = countSetBits(i);
    }
    for (int i = 0; i <= n; i++) {
      System.out.println(i + "--" + arr[i]);
    }
  }
}
