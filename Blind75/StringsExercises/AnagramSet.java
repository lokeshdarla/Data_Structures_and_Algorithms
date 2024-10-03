import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class AnagramSet {

  static boolean isAnagram(String str1, String str2) {
    if (str1.length() != str2.length()) {
      return false;
    }
    HashMap<Character, Integer> hMap = new HashMap<>();
    for (char ch : str1.toCharArray()) {
      hMap.put(ch, hMap.getOrDefault(ch, 0) + 1);
    }
    for (char ch : str2.toCharArray()) {
      if (hMap.containsKey(ch) && hMap.get(ch) != 0) {
        hMap.put(ch, hMap.get(ch) - 1);
      } else {
        return false;
      }
    }
    return true;
  }

  static List<List<String>> anagramSet(List<String> strings) {
    List<List<String>> result = new ArrayList<>();
    int n = strings.size();
    boolean[] used = new boolean[n];

    for (int i = 0; i < n; i++) {
      if (!used[i]) {
        List<String> anagramGroup = new ArrayList<>();
        anagramGroup.add(strings.get(i));
        used[i] = true;

        for (int j = i + 1; j < n; j++) {
          if (!used[j] && isAnagram(strings.get(i), strings.get(j))) {
            anagramGroup.add(strings.get(j));
            used[j] = true;
          }
        }
        result.add(anagramGroup);
      }
    }
    return result;
  }

  public static void main(String[] args) {
    List<String> input = List.of("eat", "tea", "tan", "ate", "nat", "bat");
    List<List<String>> anagrams = anagramSet(input);
    System.out.println(anagrams);
  }
}
