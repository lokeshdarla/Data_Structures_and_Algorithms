package miscellaneous;

public class CRC {
  public static String xor(String a, String b) {
    String result = "";
    for (int i = 1; i < a.length(); i++) {
      result += (a.charAt(i) == b.charAt(i)) ? "0" : "1";
    }
    return result;
  }

  public static String mod2div(String dividend, String divisor) {
    int pick = divisor.length();
    String tmp = dividend.substring(0, pick);

    while (pick < dividend.length()) {
      if (tmp.charAt(0) == '1') {
        tmp = xor(divisor, tmp) + dividend.charAt(pick);
      } else {
        tmp = xor("0".repeat(divisor.length()), tmp) + dividend.charAt(pick);
      }
      pick += 1;
    }

    if (tmp.charAt(0) == '1') {
      tmp = xor(divisor, tmp);
    } else {
      tmp = xor("0".repeat(divisor.length()), tmp);
    }

    return tmp;
  }

  public static void main(String[] args) {
    String data = "11010011101100"; // Input data
    String divisor = "1011"; // Generator

    int divisorLength = divisor.length();
    String appendedData = data + "0".repeat(divisorLength - 1);
    String remainder = mod2div(appendedData, divisor);

    System.out.println("CRC remainder: " + remainder);
    System.out.println("Transmitted data: " + data + remainder);
  }
}
