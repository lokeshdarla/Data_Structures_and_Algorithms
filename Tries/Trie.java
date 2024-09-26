package Tries;

class Node {
  Node links[] = new Node[26];
  Boolean flag = false;

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

  void setEnd() {
    flag = true;
  }

  Boolean isEnd() {
    return flag;
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
    }

    node.setEnd();
  }

  public boolean search(String word) {
    Node node = root;
    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      if (!node.isContainsKey(ch)) {
        return false;
      }
      node = node.getChar(ch);
    }
    return node.isEnd();
  }

  public boolean startsWith(String prefix) {
    Node node = root;
    for (int i = 0; i < prefix.length(); i++) {
      char ch = prefix.charAt(i);
      if (!node.isContainsKey(ch)) {
        return false;
      }
      node = node.getChar(ch);
    }
    return true;
  }
}
