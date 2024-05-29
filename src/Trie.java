
class Node {

    Node[] links = new Node[26];
    boolean flag = false;

    public Node() {
    }

    boolean containsKey(char ch) {
        return (links[ch - 'a'] != null);
    }

    Node get(char ch) {
        return links[ch - 'a'];
    }

    void put(char ch, Node node) {
        links[ch - 'a'] = node;
    }

    void setEnd() {
        flag = true;
    }

    boolean isEnd() {
        return flag;
    }
}

/*
 *
 * This is a Trie Data Structure Format
 *
 * */


public class Trie {
    private static Node root;

    public Trie() {
        root = new Node();
    }

    /*
     * TC : O(n)
     *
     * */
    void insert(String word) {

        Node node = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.containsKey(ch)) {
                node.put(ch, new Node());
            }
            /*
             * Moves to the reference trie
             * */
            node.get(ch);
        }

        node.setEnd();

    }

    //    Returns if the word is in the trie
//      TC O(n)
    boolean search(String word) {

        Node node = root;

        for (int i = 0; i < word.length(); i++) {
            if (!node.containsKey(word.charAt(i)))
                return false;
            node = node.get(word.charAt(i));
        }
        return node.isEnd();
    }


    /*
    * TC: O(n) where n is the length of the prefix word
    *
    * */
    boolean startsWith(String prefix) {

        Node node = root;

        for (int i = 0; i < prefix.length(); i++) {
            if (!node.containsKey(prefix.charAt(i)))
                return false;

            node = node.get(prefix.charAt(i));
        }
        return false;
    }
}
