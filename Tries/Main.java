package Tries;

public class Main {
  public static void main(String[] args) {
    Trie trie = new Trie();

    trie.insert("apple");
    System.out.println(trie.search("apple")); // Output: true
    System.out.println(trie.search("app")); // Output: false
    System.out.println(trie.startsWith("app")); // Output: true

    trie.insert("abcde");
    System.out.println(trie.search("app")); // Output: true
    System.out.println(trie.startsWith("ab")); // Output: true
  }
}
