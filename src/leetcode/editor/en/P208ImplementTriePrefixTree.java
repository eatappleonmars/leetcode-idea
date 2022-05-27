//A trie (pronounced as "try") or prefix tree is a tree data structure used to 
//efficiently store and retrieve keys in a dataset of strings. There are various 
//applications of this data structure, such as autocomplete and spellchecker. 
//
// Implement the Trie class: 
//
// 
// Trie() Initializes the trie object. 
// void insert(String word) Inserts the string word into the trie. 
// boolean search(String word) Returns true if the string word is in the trie (
//i.e., was inserted before), and false otherwise. 
// boolean startsWith(String prefix) Returns true if there is a previously 
//inserted string word that has the prefix prefix, and false otherwise. 
// 
//
// 
// Example 1: 
//
// 
//Input
//["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
//[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
//Output
//[null, null, true, false, true, null, true]
//
//Explanation
//Trie trie = new Trie();
//trie.insert("apple");
//trie.search("apple");   // return True
//trie.search("app");     // return False
//trie.startsWith("app"); // return True
//trie.insert("app");
//trie.search("app");     // return True
// 
//
// 
// Constraints: 
//
// 
// 1 <= word.length, prefix.length <= 2000 
// word and prefix consist only of lowercase English trieNode. 
// At most 3 * 10⁴ calls in total will be made to insert, search, and 
//startsWith. 
// 
// Related Topics Hash Table String Design Trie 👍 7063 👎 91


package leetcode.editor.en;

// 2022-05-27 09:09:05


public class P208ImplementTriePrefixTree {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Trie {

        class TrieNode {
            boolean end;
            TrieNode[] children = new TrieNode[26];
        }

        private final TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode trieNode = this.root;
            for (char c : word.toCharArray()) {
                int i = c - 'a';
                if (trieNode.children[i] == null) {
                    trieNode.children[i] = new TrieNode();
                }
                trieNode = trieNode.children[i];
            }
            trieNode.end = true;
        }

        public boolean search(String word) {
            TrieNode trieNode = traverse(word);
            return trieNode != null && trieNode.end;
        }

        public boolean startsWith(String prefix) {
            TrieNode trieNode = traverse(prefix);
            return trieNode != null;
        }
        
        private TrieNode traverse(String s) {
            TrieNode trieNode = this.root;
            for (char c : s.toCharArray()) {
                int i = c - 'a';
                if (trieNode.children[i] == null) {
                    return null;
                }
                trieNode = trieNode.children[i];
            }
            return trieNode;
        }
    }

    /**
     * Your Trie object will be instantiated and called as such:
     * Trie obj = new Trie();
     * obj.insert(word);
     * boolean param_2 = obj.search(word);
     * boolean param_3 = obj.startsWith(prefix);
     */
    //leetcode submit region end(Prohibit modification and deletion)
}