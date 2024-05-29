package Practice;

/*
* Insert words : "apple" ,"apple", "apps", "apps" - 1st Functionality
* countWordsEqualTo :  count the no of words in the trie equal to something
* countWordsStartWith : count the no of words that starts with this prefix
* Erase a word from a trie
* */

public class TrieII {


    static class Node {
        Node[] links = new Node[26];
        int countEndWith = 0;
        int startPrefixWith = 0;

        Node() {

        }

        boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        Node get(char ch){
            return links[ch - 'a'];
        }

        void put(char ch, Node node){
            links[ch - 'a'] = node;
        }

        void increaseEndWith(){
            countEndWith++;
        }

        void decreaseEndWith(){
            countEndWith--;
        }

        void increaseStartPrefixWith(){
            startPrefixWith++;
        }

        void decreaseStartPrefixWith(){
            startPrefixWith--;
        }

        int getCountEndWith(){
            return countEndWith;
        }

        int getStartPrefixWith(){
           return startPrefixWith;
        }

    }
    private static Node root;

    TrieII(){
        root = new Node();
    }

    public void insertWord(String word) {
        Node node =  root;

        for(char ch : word.toCharArray()) {
            if(!node.containsKey(ch)){
                node.put(ch, new Node());
            }
            node = node.get(ch);
            node.increaseStartPrefixWith();
        }
        node.increaseEndWith();
    }

    public int countWordEqualTo(String word) {
        Node node = root;

        for(char ch : word.toCharArray()){
            if(node.containsKey(ch)){
                node = node.get(ch);
            } else {
                return 0;
            }
        }
        return node.getCountEndWith();
    }

    public int countStartPrefixWith(String word) {
        Node node =  root;

        for(char ch: word.toCharArray()){
            if(node.containsKey(ch)){
                node = node.get(ch);
            } else {
                return 0;
            }
        }
        return node.getStartPrefixWith();
    }

    public void erase(String word) {
        Node node = root;
        for(char ch : word.toCharArray()) {
            if(node.containsKey(ch)){
                node = node.get(ch);
                node.decreaseStartPrefixWith();
            } else {
                return;
            }
        }
        node.decreaseEndWith();
    }


    public static void main(String[] args) {
        TrieII trieII = new TrieII();
        String[] words = new String[]{"apple", "apple", "apps", "apps"};
        for(String s : words){
            trieII.insertWord(s);
        }

        System.out.println(trieII.countWordEqualTo("apple"));

        System.out.println(trieII.countStartPrefixWith("app"));

        trieII.erase("apple");

        System.out.println(trieII.countWordEqualTo("apple"));
    }

}
