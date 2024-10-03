package Blind75.StringsExercises;

import java.util.HashMap;

public class IsAnagram {

  boolean isAnagram(String str1, String str2) {
    if (str1.length() != str2.length()) {
      return false;
    }

    HashMap<Character, Integer> hMap = new HashMap<>();

    for (char ch : str1.toCharArray()) {
      hMap.put(ch, hMap.getOrDefault(ch, 0) + 1);
    }

    for (char ch : str2.toCharArray()) {
      if (!hMap.containsKey(ch) || hMap.get(ch) == 0) {
        return false;
      }
      hMap.put(ch, hMap.get(ch) - 1);
    }

    return true;
  }

  public static void main(String[] args) {
    IsAnagram anagramChecker = new IsAnagram();

    // Test cases
    System.out.println("Listen and Silent are anagrams: " + anagramChecker.isAnagram("Listen", "Silent")); // true
    System.out.println("Hello and Olelh are anagrams: " + anagramChecker.isAnagram("Hello", "Olelh")); // true
    System.out.println("Test and Best are anagrams: " + anagramChecker.isAnagram("Test", "Best")); // false
    System.out.println("Dormitory and Dirty room are anagrams: " + anagramChecker.isAnagram("Dormitory", "Dirtyroom")); // true
  }
}
