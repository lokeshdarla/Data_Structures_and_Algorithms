package Blind75.Binary;

public class ReverseBits {

  public static void main(String[] args) {
    int n = 11234567;
    int result = 0;
    for (int i = 0; i < 32; i++) {
      result <<= 1;
      result = result | (n & 1);
      n >>= 1;
    }
    System.out.println(result);
  }

}
