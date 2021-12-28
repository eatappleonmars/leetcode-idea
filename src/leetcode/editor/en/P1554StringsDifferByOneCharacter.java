//Given a list of strings dict where all the strings are of the same length. 
//
// Return true if there are 2 strings that only differ by 1 character in the 
//same index, otherwise return false. 
//
// 
// Example 1: 
//
// 
//Input: dict = ["abcd","acbd", "aacd"]
//Output: true
//Explanation: Strings "abcd" and "aacd" differ only by one character in the 
//index 1.
// 
//
// Example 2: 
//
// 
//Input: dict = ["ab","cd","yz"]
//Output: false
// 
//
// Example 3: 
//
// 
//Input: dict = ["abcd","cccc","abyd","abab"]
//Output: true
// 
//
// 
// Constraints: 
//
// 
// The number of characters in dict <= 10⁵ 
// dict[i].length == dict[j].length 
// dict[i] should be unique. 
// dict[i] contains only lowercase English letters. 
// 
//
// 
// Follow up: Could you solve this problem in O(n * m) where n is the length of 
//dict and m is the length of each string. 
// Related Topics Hash Table String Rolling Hash Hash Function 👍 137 👎 4


package leetcode.editor.en;

// 2021-12-26 10:40:10

import java.util.HashSet;
import java.util.Set;

public class P1554StringsDifferByOneCharacter {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean differByOne(String[] dict) {
            return optimalSolution(dict);
    //        return naiveSolution(dict);
        }

        // Solution 1
        // Time: O(mn)
        private boolean optimalSolution(String[] dict) {
            int m = dict[0].length();
            int n = dict.length;

            // Convert dict to longDict by encoding each string with 26进制
            long[] longDict = new long[n];
            for (int j = 0; j < n; j++) { // O(n)
                long encoded = 0;
                for (char c : dict[j].toCharArray()) { // O(m)
                    encoded = encoded * 26 + (c - 'a');
                }
                longDict[j] = encoded;
            }

            // Check each position in string
            long base = 1;
            for (int i = m - 1; i >= 0; i--) { // O(m)
                Set<Long> seen = new HashSet<>();
                for (int j = 0; j < n; j++) { // O(n)
                    char c = dict[j].charAt(i);
                    long masked = longDict[j] - (c - 'a') * base;
                    if (!seen.add(masked)) {
                        return true;
                    }
                }
                base *= 26;
            }

            return false;
        }

//        // Solution 2
//        // Time: O(nm2)
//        private boolean naiveSolution(String[] dict) {
//            Set<String> seen = new HashSet<>();
//            int m = dict[0].length();
//            int n = dict.length;
//            for (int i = 0; i < m; i++) { // O(m)
//                seen.clear();
//                for (String s : dict) { // O(n)
//                    String temp = s.substring(0, i) + s.substring(i + 1, m); // O(m)
//                    if (seen.contains(temp)) {
//                        return true;
//                    }
//                    seen.add(temp);
//                }
//            }
//            return false;
//        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P1554StringsDifferByOneCharacter().new Solution();
        
    } 
}