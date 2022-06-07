//Given a string containing digits from 2-9 inclusive, return all possible 
//letter combinations that the number could represent. Return the answer in any order. 
//
//
// A mapping of digit to letters (just like on the telephone buttons) is given 
//below. Note that 1 does not map to any letters. 
//
// 
//
// 
// Example 1: 
//
// 
//Input: digits = "23"
//Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// Example 2: 
//
// 
//Input: digits = ""
//Output: []
// 
//
// Example 3: 
//
// 
//Input: digits = "2"
//Output: ["a","b","c"]
// 
//
// 
// Constraints: 
//
// 
// 0 <= digits.length <= 4 
// digits[i] is a digit in the range ['2', '9']. 
// 
// Related Topics Hash Table String Backtracking 👍 10820 👎 701


package leetcode.editor.en;

// 2022-06-06 15:24:43

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class P17LetterCombinationsOfAPhoneNumber {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Map<Character, String> mapping = Map.of(
                '2', "abc",
                '3', "def",
                '4', "ghi",
                '5', "jkl",
                '6', "mno",
                '7', "pqrs",
                '8', "tuv",
                '9', "wxyz"
        );

        public List<String> letterCombinations(String digits) {
            List<String> res = new ArrayList<>();
            if (digits.length() == 0) {
                return res;
            }
            helper(digits.toCharArray(), 0, new StringBuilder(), res);
            return res;
        }

        private void helper(char[] digits, int index, StringBuilder sb, List<String> res) {
            if (index == digits.length) {
                res.add(sb.toString());
                return;
            }
            char digit = digits[index];
            String letters = mapping.get(digit);
            for (char letter : letters.toCharArray()) {
                sb.append(letter);
                helper(digits, index + 1, sb, res);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P17LetterCombinationsOfAPhoneNumber().new Solution();
        
    } 
}