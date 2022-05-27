//Design a map that allows you to do the following: 
//
// 
// Maps a string key to a given value. 
// Returns the sum of the values that have a key with a prefix equal to a given 
//string. 
// 
//
// Implement the MapSum class: 
//
// 
// MapSum() Initializes the MapSum object. 
// void insert(String key, int val) Inserts the key-val pair into the map. If 
//the key already existed, the original key-value pair will be overridden to the 
//new one. 
// int sum(string prefix) Returns the sum of all the pairs' value whose key 
//starts with the prefix. 
// 
//
// 
// Example 1: 
//
// 
//Input
//["MapSum", "insert", "sum", "insert", "sum"]
//[[], ["apple", 3], ["ap"], ["app", 2], ["ap"]]
//Output
//[null, null, 3, null, 5]
//
//Explanation
//MapSum mapSum = new MapSum();
//mapSum.insert("apple", 3);  
//mapSum.sum("ap");           // return 3 (apple = 3)
//mapSum.insert("app", 2);    
//mapSum.sum("ap");           // return 5 (apple + app = 3 + 2 = 5)
// 
//
// 
// Constraints: 
//
// 
// 1 <= key.length, prefix.length <= 50 
// key and prefix consist of only lowercase English letters. 
// 1 <= val <= 1000 
// At most 50 calls will be made to insert and sum. 
// 
// Related Topics Hash Table String Design Trie 👍 1226 👎 125


package leetcode.editor.en;

// 2022-05-27 10:42:22

import java.util.HashMap;
import java.util.Map;

public class P677MapSumPairs {
    
    //leetcode submit region begin(Prohibit modification and deletion)

    class MapSum {

        class TrieNode {
            int count;
            TrieNode[] children = new TrieNode[26];
        }

        private TrieNode root;
        private Map<String, Integer> map;

        public MapSum() {
            this.root = new TrieNode();
            this.map = new HashMap<>();
        }

        public void insert(String key, int val) {

            int oldValue = map.getOrDefault(key, 0);
            map.put(key, val);

            val -= oldValue; // replace old string if already exist

            TrieNode node = this.root;
            for (char c : key.toCharArray()) {
                int i = c - 'a';
                if (node.children[i] == null) {
                    node.children[i] = new TrieNode();
                }
                node = node.children[i];
                node.count += val;
            }
        }

        public int sum(String prefix) {
            TrieNode node = this.root;
            for (char c : prefix.toCharArray()) {
                int i = c - 'a';
                node = node.children[i];
                if (node == null) {
                    return 0;
                }
            }
            return node.count;
        }
    }

    /**
     * Your MapSum object will be instantiated and called as such:
     * MapSum obj = new MapSum();
     * obj.insert(key,val);
     * int param_2 = obj.sum(prefix);
     */
    //leetcode submit region end(Prohibit modification and deletion)
}