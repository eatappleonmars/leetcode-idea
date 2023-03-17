//You are given a string s consisting of lowercase English letters. A duplicate 
//removal consists of choosing two adjacent and equal letters and removing them. 
//
// We repeatedly make duplicate removals on s until we no longer can. 
//
// Return the final string after all such duplicate removals have been made. It 
//can be proven that the answer is unique. 
//
// 
// Example 1: 
//
// 
//Input: s = "abbaca"
//Output: "ca"
//Explanation: 
//For example, in "abbaca" we could remove "bb" since the letters are adjacent 
//and equal, and this is the only possible move.  The result of this move is that 
//the string is "aaca", of which only "aa" is possible, so the final string is 
//"ca".
// 
//
// Example 2: 
//
// 
//Input: s = "azxxzy"
//Output: "ay"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁵ 
// s consists of lowercase English letters. 
// 
//
// Related Topics String Stack 👍 5522 👎 218


package leetcode.editor.en;

// 2023-03-17 10:56:54

import java.util.Deque;

public class P1047RemoveAllAdjacentDuplicatesInString {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String removeDuplicates(String s) {
            return solveWithStringBuilder(s);
//            return solveWithTwoPointers(s);
        }

        private String solveWithStringBuilder(String s) {
            StringBuilder sb = new StringBuilder();
            for (char c : s.toCharArray()) {
                if (sb.length() == 0 || c != sb.charAt(sb.length()-1)) {
                    sb.append(c);
                } else {
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
            return sb.toString();
        }

        public String solveWithTwoPointers(String s) {
            char[] sArray = s.toCharArray();
            int r = 1; // read index
            int w = 1; // (can) write to this index
            while (r < sArray.length) {
                if (w == 0 || sArray[r] != sArray[w-1]) {
                    sArray[w] = sArray[r];
                    w++;
                } else {
                    w--;
                }
                r++;
            }
            return new String(sArray, 0, w);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P1047RemoveAllAdjacentDuplicatesInString().new Solution();
        
    } 
}