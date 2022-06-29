//Given an integer n, return any array containing n unique integers such that 
//they add up to 0. 
//
// 
// Example 1: 
//
// 
//Input: n = 5
//Output: [-7,-1,1,3,4]
//Explanation: These arrays also are accepted [-5,-1,1,2,3] , [-3,-1,2,-2,4].
// 
//
// Example 2: 
//
// 
//Input: n = 3
//Output: [-1,0,1]
// 
//
// Example 3: 
//
// 
//Input: n = 1
//Output: [0]
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 1000 
// 
// Related Topics Array Math 👍 1162 👎 485


package leetcode.editor.en;

// 2022-06-29 09:38:42

public class P1304FindNUniqueIntegersSumUpToZero {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sumZero(int n) {
            int[] res = new int[n];
            int i = 0;

            if (n % 2 == 1) {
                res[0] = 0;
                i++;
                n--;
            }

            int candidate = 1;
            while (n > 0) {
                res[i++] = candidate;
                res[i++] = -candidate;
                candidate++;
                n -= 2;
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P1304FindNUniqueIntegersSumUpToZero().new Solution();
        
    } 
}