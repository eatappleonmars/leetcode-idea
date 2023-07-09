//Given an array of strings strs, group the anagrams together. You can return 
//the answer in any order. 
//
// An Anagram is a word or phrase formed by rearranging the letters of a 
//different word or phrase, typically using all the original letters exactly once. 
//
// 
// Example 1: 
// Input: strs = ["eat","tea","tan","ate","nat","bat"]
//Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
// 
// Example 2: 
// Input: strs = [""]
//Output: [[""]]
// 
// Example 3: 
// Input: strs = ["a"]
//Output: [["a"]]
// 
// 
// Constraints: 
//
// 
// 1 <= strs.length <= 10⁴ 
// 0 <= strs[i].length <= 100 
// strs[i] consists of lowercase English letters. 
// 
//
// Related Topics Array Hash Table String Sorting 👍 16008 👎 453


package leetcode.editor.en;

// 2023-07-09 14:22:05

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P49GroupAnagrams {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            return sol1(strs);

            // Sol2 - Not Implemented yet
            // Instead of using sorted s as the key, using character count string as the key
            // Example: bac --> #1#1#1#0...
        }

        private List<List<String>> sol1(String[] strs) {
            Map<String, List<Integer>> groupings = new HashMap<>();
            for (int i = 0; i < strs.length; i++) {
                String s = strs[i];
                // Convert s to sorted s'
                char[] array = s.toCharArray();
                Arrays.sort(array);
                String converted = new String(array);

                List<Integer> indexes = groupings.getOrDefault(converted, new ArrayList<>());
                indexes.add(i);
                groupings.put(converted, indexes);
            }

            List<List<String>> res = new ArrayList<>();
            for (List<Integer> indexes : groupings.values()) {
                List<String> grouping = new ArrayList<>();
                for (int i : indexes) {
                    grouping.add(strs[i]);
                }
                res.add(grouping);
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P49GroupAnagrams().new Solution();
        
    } 
}