


/*
* Problem Statement: Implement a program that takes a string 'S' as input and returns the number of distinct substrings of the given string, including the empty substring.
*  Use a trie data structure to accomplish this.

Note:

A string ‘B’ is considered a substring of a string ‘A’ if ‘B’ can be obtained by deleting zero or more characters from the start and end of ‘A’.
Two strings ‘X’ and ‘Y’ are considered different if there is at least one index ‘i’ such that the character of ‘X’ at index ‘i’ is different from the character of ‘Y’ at index ‘i’ (i.e., X[i] != Y[i]).
*
*Example 1:
Input: Input String = [‘abab’]
Output: 8
Explanation: All possible substring of ‘abab’ are:
“”
“a”
“b”
“ab”
“aba”
“abab”
“bab”
“ba”

Example 2:
Input: Input String = [“bob”]

Output: 7
Explanation:  All possible substring of ‘bob’ are:
“”
“b”
“bo”
“bob”
“o”
“ob”
“b”
*
* */

public class CountDistinctSubstrings {

    static Node root = new Node();
    static int countDistinct;

    static class Node {

        Node[] links;
        boolean flag;

        public Node() {
            links = new Node[26];
            flag = false;
        }

        boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        void put(char ch, Node node) {
            links[ch - 'a'] = node;
        }

        Node get(char ch) {
            return links[ch - 'a'];
        }

        void setFlag() {
            flag = true;
        }

        boolean isEnd() {
            return flag;
        }

    }

    public CountDistinctSubstrings() {
    }
    /*
    * Time Complexity : O(n^2)
    * SC : For Trie is harder
    *
    * */

    static void insert(String word) {
        for (int i = 0; i < word.length(); i++) {
            Node node = root;
            for (int j = i; j < word.length(); j++) {
                if (!node.containsKey(word.charAt(j))) {
                    node.put(word.charAt(j), new Node());
                    countDistinct++;
                }
                node = node.get(word.charAt(j));
            }
            node.setFlag();
        }
    }

    public static void main(String[] args) {
        CountDistinctSubstrings.insert("bob");
        System.out.println(CountDistinctSubstrings.countDistinct+1);
    }
}
