/*
 *
 * Another Important Variant of the TRIE data structure
 *
 *
 * */


/*
 * Problem Statement: Implement a Trie data structure that supports the following methods:

 * Insert (word): To insert a string `word` in the Trie.

 * Count Words Equal To (word): Return the count of occurrences of the string word in the Trie.

 * Count Words Starting With (prefix): Return the count of words in the Trie that have the string “prefix” as a prefix.

 * Erase (word): Delete one occurrence of the string word from the Trie.
 *
 * */

public class TrieII {

    static Node root = new Node();

    static class Node {
        Node[] links;
        int countEndWith;
        int countPrefix;

        public Node() {
            this.links = new Node[26];
            this.countEndWith = 0;
            this.countPrefix = 0;
        }

        boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        Node get(char ch) {
            return links[ch - 'a'];
        }

        void put(char ch, Node node) {
            links[ch - 'a'] = node;
        }

        void increseEndWith() {
            countEndWith++;
        }

        void increaseCountPrefix() {
            countPrefix++;
        }

        void decreaseEndWith() {
            countEndWith--;
        }

        void decreaseCountPrefix() {
            countPrefix--;
        }

        int getCountEndWith() {
            return countEndWith;
        }

        int getCountPrefix() {
            return countPrefix;
        }

    }

    public TrieII() {
    }

   static void insert(String word) {
        Node node = root;

        for (char ch : word.toCharArray()) {
            if (!node.containsKey(ch))
                node.put(ch, new Node());

            node = node.get(ch);
            node.increaseCountPrefix();
        }
        node.increseEndWith();
    }

   static int countWordsEqualTo(String word) {

        Node node = root;

        for (char ch : word.toCharArray()) {

            if (node.containsKey(ch))
                node = node.get(ch);
            else
                return 0;
        }
        return node.getCountEndWith();
    }

    static int countWordsStartingWith(String prefix) {
        Node node = root;

        for (char ch : prefix.toCharArray()) {

            if (node.containsKey(ch)) {
                node = node.get(ch);
            } else {
                return 0;
            }
        }
        return node.getCountPrefix();
    }

    static void erase(String eraseWord) {

        Node node = root;

        for(char ch : eraseWord.toCharArray()){
            if(node.containsKey(ch)){
                node = node.get(ch);
                node.decreaseCountPrefix();
            } else {
                return;
            }
        }
        node.decreaseEndWith();
    }

    public static void main(String[] args) {

        TrieII.insert("apple");
        TrieII.insert("apple");
        TrieII.insert("apps");
        TrieII.insert("apps");


        System.out.println(TrieII.countWordsEqualTo("apple"));
        System.out.println(TrieII.countWordsStartingWith("app"));

        TrieII.erase("apps");

        System.out.println(TrieII.countWordsEqualTo("apple"));
        System.out.println(TrieII.countWordsStartingWith("apps"));

    }


}
