package Blind75.Binary;

public class AddTwo {

  public static void main(String[] args) {
    int a = 143;
    int b = 1432;

    int sum = a;
    while (b != 0) {
      int carry = (a & b) << 1;
      sum = a ^ b;
      a = sum;
      b = carry;
    }

    System.out.println(a);

  }

}
