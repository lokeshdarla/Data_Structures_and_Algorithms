package LeetCode.DailyQuestions;

public class SimilaritySentencesIII {
  static boolean isSimilar(String sentence1, String sentence2) {

    String[] words1 = sentence1.split(" ");
    String[] words2 = sentence2.split(" ");

    if (words1.length > words2.length) {
      String[] temp = words1;
      words1 = words2;
      words2 = temp;
    }

    int start = 0;

    while (start < words1.length && words1[start].equals(words2[start])) {
      start++;
    }

    int end = 0;

    while (end < words1.length && words1[words1.length - 1 - end].equals(words2[words2.length - 1 - end])) {
      end++;
    }

    return start + end >= words1.length;
  }

  public static void main(String[] args) {
    String sentence1 = "Hello Jane";
    String sentence2 = "Hello my name is Jane";
    System.out.println(isSimilar(sentence1, sentence2)); // Expected output: true

    String sentence3 = "Frog cool";
    String sentence4 = "Frogs are cool";
    System.out.println(isSimilar(sentence3, sentence4)); // Expected output: false
  }
}
