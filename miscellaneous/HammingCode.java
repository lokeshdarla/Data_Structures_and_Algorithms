package miscellaneous;

import java.util.Scanner;

public class HammingCode {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter number of data bits: ");
    int n = sc.nextInt();
    int[] dataBits = new int[n];

    System.out.println("Enter data bits:");
    for (int i = 0; i < n; i++) {
      dataBits[i] = sc.nextInt();
    }

    int r = 0; // Calculate number of redundant bits
    while ((n + r + 1) > Math.pow(2, r)) {
      r++;
    }

    int[] hammingCode = new int[n + r];
    int j = 0;
    for (int i = 0; i < hammingCode.length; i++) {
      if (Math.pow(2, j) - 1 == i) {
        hammingCode[i] = 0;
        j++;
      } else {
        hammingCode[i] = dataBits[--n];
      }
    }

    for (int i = 0; i < r; i++) {
      int x = (int) Math.pow(2, i);
      int oneCount = 0;

      for (int k = x - 1; k < hammingCode.length; k += 2 * x) {
        for (int l = k; l < k + x && l < hammingCode.length; l++) {
          if (hammingCode[l] == 1) {
            oneCount++;
          }
        }
      }
      hammingCode[x - 1] = oneCount % 2;
    }

    System.out.println("Hamming code: ");
    for (int i = hammingCode.length - 1; i >= 0; i--) {
      System.out.print(hammingCode[i]);
    }
    sc.close();
  }
}
