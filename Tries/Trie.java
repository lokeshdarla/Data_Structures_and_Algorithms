package Tries;

class Node {
  Node links[] = new Node[26];
  int countWordsEqual = 0;
  int countWordsPrefix = 0;

  public Node() {
  }

  Boolean isContainsKey(char ch) {
    return links[ch - 'a'] != null;
  }

  Node getChar(char ch) {
    return links[ch - 'a'];
  }

  void put(char ch, Node node) {
    links[ch - 'a'] = node;
  }

  void increasePrefix() {
    countWordsPrefix++;
  }

  void increaseEnd() {
    countWordsEqual++;
  }

  void decreasePrefix() {
    countWordsPrefix--;
  }

  void decreaseEnd() {
    countWordsEqual--;
  }

  int getPrefixCount() {
    return countWordsPrefix;
  }

  int getEndCount() {
    return countWordsEqual;
  }
}

public class Trie {
  private static Node root;

  public Trie() {
    root = new Node();
  }

  public void insert(String word) {
    Node node = root;
    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      if (!node.isContainsKey(ch)) {
        node.put(ch, new Node());
      }
      node = node.getChar(ch);
      node.increasePrefix();
    }
    node.increaseEnd();
  }

  public int countWordsEqualTo(String word) {
    Node node = root;
    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      if (!node.isContainsKey(ch)) {
        return 0;
      }
      node = node.getChar(ch);
    }
    return node.getEndCount();
  }

  public int countWordsStartingWith(String prefix) {
    Node node = root;
    for (int i = 0; i < prefix.length(); i++) {
      char ch = prefix.charAt(i);
      if (!node.isContainsKey(ch)) {
        return 0;
      }
      node = node.getChar(ch);
    }
    return node.getPrefixCount();
  }

  public void erase(String word) {
    Node node = root;
    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      if (node.isContainsKey(ch)) {
        node = node.getChar(ch);
        node.decreasePrefix();
      } else {
        return;
      }
    }
    node.decreaseEnd();
  }
}
