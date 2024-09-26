import java.util.*;

// Given two strings sheik if they are anagrams or not
public class Anagrams {

  static Boolean isAnagram(String str1, String str2) {
    HashMap<Character, Integer> hMap = new HashMap<>();

    char[] arr1 = str1.toCharArray();
    for (int i = 0; i < arr1.length; i++) {
      char ch = arr1[i];
      hMap.put(ch, hMap.getOrDefault(ch, 0) + 1);
    }

    char[] arr2 = str2.toCharArray();
    for (int i = 0; i < arr2.length; i++) {
      char ch = arr2[i];
      if (hMap.containsKey(ch)) {
        if (hMap.get(ch) == 0) {
          return false;
        } else {
          hMap.put(ch, hMap.get(ch) - 1);
        }
      } else {
        return false;
      }
    }
    return true;
  }

  public static void main(String a[]) {
    String str1 = "Hello";
    String str2 = "ollHe";
    if (isAnagram(str1, str2)) {
      System.err.println("Two strings are anagrams");
    } else {
      System.err.println("They are not anagrams");
    }
  }
}
