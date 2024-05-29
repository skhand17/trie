package BitTries.MaximumXorOfTwoNumbersInAnArray;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/*
*
* Example 1:

* Input:Arr1: 3 10 5 25 2, Arr2: 8 1 2 12 7

* Output: Maximum XOR value: 30

* Explanation: The maximum XOR value is 30, which occurs when XORing 7 and 25.

* Example 2:

* Input:Arr1:  9, 8, 7, 5, 4, Arr2: 12, 44, 22, 10

* Output: Maximum XOR value: 43

* Explanation: The maximum XOR value is 43, which occurs when XORing 44 and 7.
*
*
*
* */
public class Trie {

    static Node root = new Node();
    static class Node {

        Node[] links;

        public Node() {
            this.links = new Node[2];
        }

         boolean containsKey(int bit) {
            return links[bit] != null;
        }

        void put(int bit, Node node){
            links[bit] = node;
        }

        Node get(int bit) {
            return links[bit];
        }
    }

    public Trie() {
    }

    static void insert(int num) {

        Node node = root;

        for(int i=31; i>=0; i--){
            /*
            * This checks which bits are set for a particular number in binary representation
            * */
            int bit = num >> i & 1;

            if(!node.containsKey(bit))
                node.put(bit, new Node());

            node = node.get(bit);
        }

    }

    static int getMax(int num) {
        Node node = root;
        int maxNum = 0;

        for(int i=31; i>=0; i--){
            int bit = num >> i & 1;

            if(node.containsKey(1- bit)){
                /*
                * To find the maximum number we left shift the 1 binary represenation by the value of i and then perform or operation
                *
                * */
                maxNum = maxNum | (1<<i);
                node = node.get(1 - bit);
            } else {
                node = node.get(bit);
            }
        }

        return maxNum;
    }

    static int maxXOR(int n, int m, ArrayList<Integer> arr1, ArrayList<Integer> arr2) {

        for(int i=0; i<n; i++){
            Trie.insert(arr1.get(i));
        }
        int maxi = 0;
        for(int i=0; i<m; i++){
            maxi = Math.max(maxi, getMax(arr2.get(i)));
        }

        return maxi;
    }

    public static void main(String[] args) {

        ArrayList<Integer> arr1 = new ArrayList<>(List.of(7, 8, 9, 10));
        ArrayList<Integer> arr2 = new ArrayList<>(List.of(1, 2, 3, 4));

        int maxi = maxXOR(arr1.size(), arr2.size(), arr1, arr2);
        System.out.println(maxi);
    }


}
