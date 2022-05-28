//Given an array of strings words (without duplicates), return all the 
//concatenated words in the given list of words. 
//
// A concatenated word is defined as a string that is comprised entirely of at 
//least two shorter words in the given array. 
//
// 
// Example 1: 
//
// 
//Input: words = ["cat","cats","catsdogcats","dog","dogcatsdog",
//"hippopotamuses","rat","ratcatdogcat"]
//Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]
//Explanation: "catsdogcats" can be concatenated by "cats", "dog" and "cats"; 
//"dogcatsdog" can be concatenated by "dog", "cats" and "dog"; 
//"ratcatdogcat" can be concatenated by "rat", "cat", "dog" and "cat". 
//
// Example 2: 
//
// 
//Input: words = ["cat","dog","catdog"]
//Output: ["catdog"]
// 
//
// 
// Constraints: 
//
// 
// 1 <= words.length <= 10⁴ 
// 0 <= words[i].length <= 30 
// words[i] consists of only lowercase English letters. 
// 0 <= sum(words[i].length) <= 10⁵ 
// 
// Related Topics Array String Dynamic Programming Depth-First Search Trie 👍 19
//35 👎 225


package leetcode.editor.en;

// 2022-05-28 10:54:33

import java.util.ArrayList;
import java.util.List;

public class P472ConcatenatedWords {
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    class TrieNode {
        boolean end;
        TrieNode[] children = new TrieNode[26];
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            if (word.length() > 0) {
                add(root, word.toCharArray(), 0);
            }
        }
        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (isConcatenated(root, root, word.toCharArray(), 0) > 0) {
                res.add(word);
            }
        }
        return res;
    }

    // Return concatenated flag.
    //  0 indicates word is found without concatenation.
    //  1 indicates word is found with at least one concatenation.
    // -1 indicates word is not found.
    private int isConcatenated(TrieNode root, TrieNode node, char[] wChars, int index) {
        if (node == null) {
            return -1;
        }
        if (index == wChars.length) {
            return node.end ? 0 : -1;
        }

        char c = wChars[index];
        int i = c - 'a';

        if (node.end && isConcatenated(root, root, wChars, index) >= 0) {
            return 1;
        } else {
            return isConcatenated(root, node.children[i], wChars, index + 1);
        }
    }

    private void add(TrieNode node, char[] wChars, int index) {
        if (index == wChars.length) {
            node.end = true;
            return;
        }
        char c = wChars[index];
        int i = c - 'a';
        if (node.children[i] == null) {
            node.children[i] = new TrieNode();
        }
        add(node.children[i], wChars, index + 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P472ConcatenatedWords().new Solution();
        
    } 
}