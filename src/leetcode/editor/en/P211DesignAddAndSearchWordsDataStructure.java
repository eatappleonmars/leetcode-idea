//Design a data structure that supports adding new words and finding if a 
//string matches any previously added string. 
//
// Implement the WordDictionary class: 
//
// 
// WordDictionary() Initializes the object. 
// void addWord(word) Adds word to the data structure, it can be matched later. 
//
// bool search(word) Returns true if there is any string in the data structure 
//that matches word or false otherwise. word may contain dots '.' where dots can 
//be matched with any letter. 
// 
//
// 
// Example: 
//
// 
//Input
//["WordDictionary","addWord","addWord","addWord","search","search","search",
//"search"]
//[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
//Output
//[null,null,null,null,false,true,true,true]
//
//Explanation
//WordDictionary wordDictionary = new WordDictionary();
//wordDictionary.addWord("bad");
//wordDictionary.addWord("dad");
//wordDictionary.addWord("mad");
//wordDictionary.search("pad"); // return False
//wordDictionary.search("bad"); // return True
//wordDictionary.search(".ad"); // return True
//wordDictionary.search("b.."); // return True
// 
//
// 
// Constraints: 
//
// 
// 1 <= word.length <= 25 
// word in addWord consists of lowercase English letters. 
// word in search consist of '.' or lowercase English letters. 
// There will be at most 3 dots in word for search queries. 
// At most 10⁴ calls will be made to addWord and search. 
// 
// Related Topics String Depth-First Search Design Trie 👍 4882 👎 210


package leetcode.editor.en;

// 2022-05-28 10:29:26

public class P211DesignAddAndSearchWordsDataStructure {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class WordDictionary {

        class TrieNode {
            boolean end;
            TrieNode[] children = new TrieNode[26];
        }

        private TrieNode root;

        public WordDictionary() {
            this.root = new TrieNode();
        }

        public void addWord(String word) {
            TrieNode node = this.root;
            for (char c : word.toCharArray()) {
                int i = c - 'a';
                if (node.children[i] == null) {
                    node.children[i] = new TrieNode();
                }
                node = node.children[i];
            }
            node.end = true;
        }

        public boolean search(String word) {
            return search(root, word.toCharArray(), 0);
        }

        private boolean search(TrieNode node, char[] wChars, int index) {
            if (index == wChars.length) {
                return node.end;
            }

            char c = wChars[index];

            if (c == '.') {
                for (TrieNode child : node.children) {
                    if (child != null && search(child, wChars, index + 1)) {
                        return true;
                    }
                }
                return false;
            }

            int i = c - 'a';
            return node.children[i] != null && search(node.children[i], wChars, index + 1);
        }
    }

    /**
     * Your WordDictionary object will be instantiated and called as such:
     * WordDictionary obj = new WordDictionary();
     * obj.addWord(word);
     * boolean param_2 = obj.search(word);
     */
    //leetcode submit region end(Prohibit modification and deletion)
}