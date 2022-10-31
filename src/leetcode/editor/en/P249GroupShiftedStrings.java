//We can shift a string by shifting each of its letters to its successive 
//letter. 
//
// 
// For example, "abc" can be shifted to be "bcd". 
// 
//
// We can keep shifting the string to form a sequence. 
//
// 
// For example, we can keep shifting "abc" to form the sequence: "abc" -> "bcd" 
//-> ... -> "xyz". 
// 
//
// Given an array of strings strings, group all strings[i] that belong to the 
//same shifting sequence. You may return the answer in any order. 
//
// 
// Example 1: 
// Input: strings = ["abc","bcd","acef","xyz","az","ba","a","z"]
//Output: [["acef"],["a","z"],["abc","bcd","xyz"],["az","ba"]]
// 
// Example 2: 
// Input: strings = ["a"]
//Output: [["a"]]
// 
// 
// Constraints: 
//
// 
// 1 <= strings.length <= 200 
// 1 <= strings[i].length <= 50 
// strings[i] consists of lowercase English letters. 
// 
//
// Related Topics Array Hash Table String 👍 1434 👎 275


package leetcode.editor.en;

// 2022-10-31 08:55:33

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P249GroupShiftedStrings {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> groupStrings(String[] strings) {
            Map<String, List<String>> map = new HashMap<>();
            for (String s : strings) {
                String normalizedOffset = computeNormalizedOffsets(s);
                List<String> group = map.computeIfAbsent(normalizedOffset, norm -> new ArrayList<>());
                group.add(s);
            }
            List<List<String>> res = new ArrayList<>();
            res.addAll(map.values());
            return res;
        }

        // Compute normalized offsets (in string representation) by shifting the input string
        // s.t. it begins with letter 'a'
        // Example: "bac"(1,0,2) --> -1 --> 0,-1,1 --> "0-25-1-" (azb)
        private String computeNormalizedOffsets(String s) {
            StringBuilder sb = new StringBuilder();
            final int diff = s.charAt(0) - 'a';
            for (int i = 0; i < s.length(); i++) {
                int offset = ((s.charAt(i) - 'a') - diff + 26) % 26;
                sb.append(offset).append("-");
            }
            return sb.toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P249GroupShiftedStrings().new Solution();
        
    } 
}