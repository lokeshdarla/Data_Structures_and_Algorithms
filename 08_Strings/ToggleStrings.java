// Given a string toggle chars and return ans string
// Toggle between uppercase and lowercase

public class ToggleStrings {

  static String toggleCase(String str) {
    char[] arr = str.toCharArray();

    for (int i = 0; i < arr.length; i++) {
      char ch = arr[i];
      if (Character.isUpperCase(ch)) {
        arr[i] = Character.toLowerCase(ch);
      } else {
        arr[i] = Character.toUpperCase(ch);
      }
    }

    return new String(arr);
  }

  public static void main(String a[]) {
    String str = "Lokesh";
    System.out.println(toggleCase(str));
  }
}
