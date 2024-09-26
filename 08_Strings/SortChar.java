import java.util.*;

public class SortChar {

  static String charSort(char[] arr) {
    int n = arr.length;
    int[] freq = new int[26];

    for (int i = 0; i < n; i++) {
      int idx = arr[i] - 'a';
      freq[idx]++;
    }

    int k = 0;
    for (int i = 0; i < 26; i++) {
      int count = freq[i];
      char ch = (char) (i + 'a');
      for (int j = 0; j < count; j++) {
        arr[k++] = ch;
      }
    }

    return new String(arr);
  }

  static String frequencySort(char[] arr) {
    HashMap<Character, Integer> hMap = new HashMap<>();
    int n = arr.length;

    for (int i = 0; i < n; i++) {
      char ch = arr[i];
      hMap.put(ch, hMap.getOrDefault(ch, 0) + 1);
    }

    List<Map.Entry<Character, Integer>> entryList = new ArrayList<>(hMap.entrySet());

    entryList.sort((a, b) -> a.getValue() - b.getValue());

    StringBuilder sortedStr = new StringBuilder();

    for (Map.Entry<Character, Integer> entry : entryList) {
      char ch = entry.getKey();
      int count = entry.getValue();
      for (int i = 0; i < count; i++) {
        sortedStr.append(ch);
      }
    }

    return sortedStr.toString();
  }

  public static void main(String[] args) {
    char[] arr = { 'a', 'b', 'c', 'a', 'b', 'c', 'a', 'b' };

    System.out.println("Lexicographical sort: " + charSort(arr));

    System.out.println("Frequency sort: " + frequencySort(arr));
  }
}
