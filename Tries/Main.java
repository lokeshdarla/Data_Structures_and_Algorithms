package Tries;

public class Main {
  public static void main(String[] args) {
    Trie trie = new Trie();

    trie.insert("apple");
    trie.insert("apple");
    trie.insert("app");

    System.out.println(trie.countWordsEqualTo("apple")); // Output: 2
    System.out.println(trie.countWordsStartingWith("app")); // Output: 3
    System.out.println(trie.countWordsEqualTo("app")); // Output: 1

    trie.erase("apple");
    System.out.println(trie.countWordsEqualTo("apple")); // Output: 1
    System.out.println(trie.countWordsStartingWith("app")); // Output: 2
  }
}
