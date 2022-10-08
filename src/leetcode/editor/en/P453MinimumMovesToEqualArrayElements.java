//Given an integer array nums of size n, return the minimum number of moves 
//required to make all array elements equal. 
//
// In one move, you can increment n - 1 elements of the array by 1. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3]
//Output: 3
//Explanation: Only three moves are needed (remember each move increments two 
//elements):
//[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
// 
//
// Example 2: 
//
// 
//Input: nums = [1,1,1]
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// n == nums.length 
// 1 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// The answer is guaranteed to fit in a 32-bit integer. 
// 
//
// Related Topics Array Math 👍 1839 👎 1736


package leetcode.editor.en;

// 2022-09-08 09:58:20

public class P453MinimumMovesToEqualArrayElements {
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minMoves(int[] nums) {
        // Incrementing (n-1) elements ==> decrementing (1) element
        int minNum = Integer.MAX_VALUE;
        for (int n : nums) {
            minNum = Math.min(minNum, n);
        }

        int stepCounter = 0;
        for (int n : nums) {
            stepCounter += n - minNum;
        }
        return stepCounter;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P453MinimumMovesToEqualArrayElements().new Solution();
        
    } 
}