//A message containing letters from A-Z can be encoded into numbers using the 
//following mapping: 
//
// 
//'A' -> "1"
//'B' -> "2"
//...
//'Z' -> "26"
// 
//
// To decode an encoded message, all the digits must be grouped then mapped 
//back into letters using the reverse of the mapping above (there may be multiple 
//ways). For example, "11106" can be mapped into: 
//
// 
// "AAJF" with the grouping (1 1 10 6) 
// "KJF" with the grouping (11 10 6) 
// 
//
// Note that the grouping (1 11 06) is invalid because "06" cannot be mapped 
//into 'F' since "6" is different from "06". 
//
// Given a string s containing only digits, return the number of ways to decode 
//it. 
//
// The test cases are generated so that the answer fits in a 32-bit integer. 
//
// 
// Example 1: 
//
// 
//Input: s = "12"
//Output: 2
//Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).
// 
//
// Example 2: 
//
// 
//Input: s = "226"
//Output: 3
//Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2
// 6).
// 
//
// Example 3: 
//
// 
//Input: s = "06"
//Output: 0
//Explanation: "06" cannot be mapped to "F" because of the leading zero ("6" is 
//different from "06").
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 100 
// s contains only digits and may contain leading zero(s). 
// 
// Related Topics String Dynamic Programming 👍 6706 👎 3795


package leetcode.editor.en;

// 2022-04-19 21:46:11

public class P91DecodeWays {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numDecodings(String s) {

            char[] sArray = s.toCharArray();

            if (sArray[0] == '0') {
                return 0;
            }

            final int len = sArray.length;
            int[] dp = new int[len + 1]; // need extra slot for dp[i-1]
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 1; i < len; i++) {
                final char c = s.charAt(i);
                final char prevChar = sArray[i - 1];

                if (c != '0') {
                    dp[i+1] = dp[i];
                    if (prevChar == '1' || (prevChar == '2' && c >= '1' && c <= '6')) { // valid: xx11 - xx19 and xx21 - xx26
                        dp[i+1] += dp[i-1];
                    }
                } else { // c == '0'
                    if (prevChar != '1' && prevChar != '2') { // valide: xx10, xx20
                        return 0;
                    }
                    dp[i + 1] = dp[i - 1];
                }
            }

            return dp[len];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P91DecodeWays().new Solution();
        
    } 
}