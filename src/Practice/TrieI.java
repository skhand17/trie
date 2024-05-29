package Practice;

public class TrieI {
    private Node root;
    static class Node {
        Node[] links = new Node[26];
        boolean flag = false;

        boolean containsKey(char ch){
            return links[ch - 'a'] != null;
        }

        Node get(char ch){
            return links[ch -'a'];
        }

        void put(char ch, Node node) {
            links[ch - 'a'] = node;
        }

        void setEnd(){
            flag = true;
        }

        boolean isEnd(){
            return flag;
        }
    }

    public TrieI() {
        root = new Node();
    }

    public void insert(String word) {
        Node node = root;

        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(!node.containsKey(ch)){
                node.put(ch, new Node());
            }

            node = node.get(ch);
        }
        node.setEnd();
    }

    public boolean search(String word) {
        Node node = root;

        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);

            if(!node.containsKey(ch)){
                return false;
            }

            node = node.get(ch);
        }
        return node.isEnd();
    }

    public boolean startsWith(String prefix) {

        Node node = root;

        for(int i=0; i<prefix.length(); i++){
            char ch = prefix.charAt(i);
            if(!node.containsKey(ch)){
                return false;
            }
            node = node.get(ch);
        }
        return true;
    }

    public static void main(String[] args) {
        TrieI trie = new TrieI();
        String[] words = {"apple", "appl", "apxl"};
        for(String s : words){
            trie.insert(s);
        }

        System.out.println(trie.search("apple"));
    }
}