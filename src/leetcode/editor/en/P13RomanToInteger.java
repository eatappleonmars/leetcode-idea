//Roman numerals are represented by seven different symbols: I, V, X, L, C, D 
//and M. 
//
// 
//Symbol       Value
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000 
//
// For example, 2 is written as II in Roman numeral, just two ones added 
//together. 12 is written as XII, which is simply X + II. The number 27 is written as 
//XXVII, which is XX + V + II. 
//
// Roman numerals are usually written largest to smallest from left to right. 
//However, the numeral for four is not IIII. Instead, the number four is written as 
//IV. Because the one is before the five we subtract it making four. The same 
//principle applies to the number nine, which is written as IX. There are six 
//instances where subtraction is used: 
//
// 
// I can be placed before V (5) and X (10) to make 4 and 9. 
// X can be placed before L (50) and C (100) to make 40 and 90. 
// C can be placed before D (500) and M (1000) to make 400 and 900. 
// 
//
// Given a roman numeral, convert it to an integer. 
//
// 
// Example 1: 
//
// 
//Input: s = "III"
//Output: 3
//Explanation: III = 3.
// 
//
// Example 2: 
//
// 
//Input: s = "LVIII"
//Output: 58
//Explanation: L = 50, V= 5, III = 3.
// 
//
// Example 3: 
//
// 
//Input: s = "MCMXCIV"
//Output: 1994
//Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 15 
// s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M'). 
// It is guaranteed that s is a valid roman numeral in the range [1, 3999]. 
// 
//
// Related Topics Hash Table Math String 👍 11145 👎 635


package leetcode.editor.en;

// 2023-07-04 11:37:05

import java.util.HashMap;
import java.util.Map;

public class P13RomanToInteger {
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private Map<Character, Integer> valueMap = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000
    );

        private Map<Character, Integer> indexMap = Map.of(
                'I', 0,
                'V', 1,
                'X', 2,
                'L', 3,
                'C', 4,
                'D', 5,
                'M', 6
        );

    public int romanToInt(String s) {
        int sum = valueMap.get(s.charAt(0));

        char prevChar = s.charAt(0);
        int prevCharIndex = indexMap.get(prevChar);

        for (int i = 1; i < s.length(); i++) {
            char currChar = s.charAt(i);
            int currCharIndex = indexMap.get(currChar);
            sum += valueMap.get(currChar);
            // Check previous char
            int diffIndex = currCharIndex - prevCharIndex;
            if (diffIndex >= 1 && diffIndex <= 2) {
                sum -= 2 * valueMap.get(prevChar);
            }
            prevChar = currChar;
            prevCharIndex = currCharIndex;
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P13RomanToInteger().new Solution();
        
    } 
}