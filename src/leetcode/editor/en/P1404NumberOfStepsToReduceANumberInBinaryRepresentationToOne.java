//Given the binary representation of an integer as a string s, return the 
//number of steps to reduce it to 1 under the following rules: 
//
// 
// If the current number is even, you have to divide it by 2. 
// If the current number is odd, you have to add 1 to it. 
// 
//
// It is guaranteed that you can always reach one for all test cases. 
//
// 
// Example 1: 
//
// 
//Input: s = "1101"
//Output: 6
//Explanation: "1101" corressponds to number 13 in their decimal representation.
//
//Step 1) 13 is odd, add 1 and obtain 14. 
//Step 2) 14 is even, divide by 2 and obtain 7.
//Step 3) 7 is odd, add 1 and obtain 8.
//Step 4) 8 is even, divide by 2 and obtain 4.  
//Step 5) 4 is even, divide by 2 and obtain 2. 
//Step 6) 2 is even, divide by 2 and obtain 1.  
// 
//
// Example 2: 
//
// 
//Input: s = "10"
//Output: 1
//Explanation: "10" corressponds to number 2 in their decimal representation.
//Step 1) 2 is even, divide by 2 and obtain 1.  
// 
//
// Example 3: 
//
// 
//Input: s = "1"
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 500 
// s consists of characters '0' or '1' 
// s[0] == '1' 
// 
//
// Related Topics String Bit Manipulation 👍 561 👎 49


package leetcode.editor.en;

// 2022-08-25 21:50:19

public class P1404NumberOfStepsToReduceANumberInBinaryRepresentationToOne {
    
    //leetcode submit region begin(Prohibit modification and deletion)
        class Solution {
        /**
         * The following applies to all digits EXCEPT the first digit
         * #  digit carry action      result_carry
         * 1  0     0     >>1         0
         * 2  0     1     same as #3  0
         * 3  1     0     +1 && >>1   1
         * 4  1     1     >>1         1

         * The following applies to only the first digit:
         *   Important: s[0] == "1" based on the constraint:

         * #  digit carry action
         * 1  1     0     none
         * 2  1     1     >>1
         *
         */
            public int numSteps(String s) {
                char[] array = s.toCharArray();
                int count = 0;
                int carry = 0;
                for (int i = array.length - 1; i > 0; i--) {
                    if (array[i] - '0' != carry) {
                        carry = 1;
                        count++;
                    }
                    count++;
                }
                // carry cannot be 0
                return count + carry;
            }
        }
        //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P1404NumberOfStepsToReduceANumberInBinaryRepresentationToOne().new Solution();
        
    } 
}