//Given a string s, partition s such that every substring of the partition is a 
//palindrome. Return all possible palindrome partitioning of s. 
//
// A palindrome string is a string that reads the same backward as forward. 
//
// 
// Example 1: 
// Input: s = "aab"
//Output: [["a","a","b"],["aa","b"]]
// Example 2: 
// Input: s = "a"
//Output: [["a"]]
// 
// 
// Constraints: 
//
// 
// 1 <= s.length <= 16 
// s contains only lowercase English letters. 
// 
// Related Topics String Dynamic Programming Backtracking 👍 6255 👎 194


package leetcode.editor.en;

// 2022-03-13 14:49:38

import java.util.ArrayList;
import java.util.List;

public class P131PalindromePartitioning {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> partition(String s) {

            List<String> current = new ArrayList<>();
            List<List<String>> res = new ArrayList<>();
            
            helper(s, 0, current, res);
            return res;
        }

        // Find all partitions of substring s[start, end)
        private void helper(String s, int start, List<String> current, List<List<String>> res) {
            
            if (start == s.length()) {
                res.add(new ArrayList<>(current));
                return;
            }

            // Try partition at index i in substring s[start, end)
            // If s[start, i) is not palindrome, we cannot partition here
            // Otherwise, note down prefix s[start, i), and check all combinations of substring s[i, end)
            for (int i = start + 1; i <= s.length(); i++) {
                if (!isPalindrome(s, start, i)) {
                    continue; // cannot partition at i because s[0:i) is not palindrome
                }
                current.add(s.substring(start, i));
                helper(s, i, current, res); // find all in s[i, end)
                current.remove(current.size() - 1);
            }
        }

        // Check s[start, end)
        private boolean isPalindrome(String s, int start, int end) {
            int i = start, j = end - 1;
            while (i < j) {
                if (s.charAt(i) != s.charAt(j)) {
                    return false;
                }
                i++;
                j--;
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P131PalindromePartitioning().new Solution();
        
    } 
}