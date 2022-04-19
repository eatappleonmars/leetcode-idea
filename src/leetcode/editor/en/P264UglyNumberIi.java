//An ugly number is a positive integer whose prime factors are limited to 2, 3, 
//and 5. 
//
// Given an integer n, return the nᵗʰ ugly number. 
//
// 
// Example 1: 
//
// 
//Input: n = 10
//Output: 12
//Explanation: [1, 2, 3, 4, 5, 6, 8, 9, 10, 12] is the sequence of the first 10 
//ugly numbers.
// 
//
// Example 2: 
//
// 
//Input: n = 1
//Output: 1
//Explanation: 1 has no prime factors, therefore all of its prime factors are 
//limited to 2, 3, and 5.
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 1690 
// 
// Related Topics Hash Table Math Dynamic Programming Heap (Priority Queue) 👍 3
//950 👎 210


package leetcode.editor.en;

// 2022-04-19 09:41:31

public class P264UglyNumberIi {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int nthUglyNumber(int n) {

            if (n == 1) {
                return 1;
            }

            int[] numbers = new int[n + 1];
            numbers[1] = 1;

            // Index of number to be used to generate the next number
            int p2 = 1, p3 = 1, p5 = 1;

            for (int i = 2; i <= n; i++) {
                int m2 = numbers[p2] * 2;
                int m3 = numbers[p3] * 3;
                int m5 = numbers[p5] * 5;

                int min = Math.min(m2, Math.min(m3, m5));
                numbers[i] = min;

                // Increment the index which generates the next smallest ugly number
                // Multiple pointers may be incremented in case duplicated number is generated such as 2*3 = 3*2 = 6
                if (m2 == min) p2++;
                if (m3 == min) p3++;
                if (m5 == min) p5++;
            }

            return numbers[n];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P264UglyNumberIi().new Solution();
        
    } 
}