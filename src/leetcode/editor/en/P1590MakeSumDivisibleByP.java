//Given an array of positive integers nums, remove the smallest subarray (
//possibly empty) such that the sum of the remaining elements is divisible by p. It is 
//not allowed to remove the whole array. 
//
// Return the length of the smallest subarray that you need to remove, or -1 if 
//it's impossible. 
//
// A subarray is defined as a contiguous block of elements in the array. 
//
// 
// Example 1: 
//
// 
//Input: nums = [3,1,4,2], p = 6
//Output: 1
//Explanation: The sum of the elements in nums is 10, which is not divisible by 
//6. We can remove the subarray [4], and the sum of the remaining elements is 6, 
//which is divisible by 6.
// 
//
// Example 2: 
//
// 
//Input: nums = [6,3,5,2], p = 9
//Output: 2
//Explanation: We cannot remove a single element to get a sum divisible by 9. 
//The best way is to remove the subarray [5,2], leaving us with [6,3] with sum 9.
// 
//
// Example 3: 
//
// 
//Input: nums = [1,2,3], p = 3
//Output: 0
//Explanation: Here the sum is 6. which is already divisible by 3. Thus we do 
//not need to remove anything.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁹ 
// 1 <= p <= 10⁹ 
// 
// Related Topics Array Hash Table Prefix Sum 👍 833 👎 36


package leetcode.editor.en;

// 2022-03-07 09:59:48

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P1590MakeSumDivisibleByP {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minSubarray(int[] nums, int p) {
            // n is positive. Safe to use remainder in addition operation
            int sumMod = 0;
            for (int n : nums) {
                sumMod = (sumMod + n) % p;
            }
            // Already divisible by p
            if (sumMod == 0) {
                return 0;
            }
            // { mod : latest index }
            Map<Integer, Integer> prefixSumMods = new HashMap<>();
            prefixSumMods.put(0, -1);

            int prefixMod = 0;
            int minLen = nums.length;;
            for (int i = 0; i < nums.length; i++) {
                prefixMod = (prefixMod + nums[i]) % p;
                // sum_i % p (aka target) == (sum_j % p - sum % p) % p
                // where % means taking mod mathematically, 2 % 6 = 2, -2 % 6 = 4
                int target = (prefixMod - sumMod + p) % p;
                if (prefixSumMods.containsKey(target)) {
                    minLen = Math.min(minLen, i - prefixSumMods.get(target));
                    if (minLen == 1) {
                        return 1;
                    }
                }
                prefixSumMods.put(prefixMod, i);
            }

            return minLen >= nums.length ? -1 : minLen;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P1590MakeSumDivisibleByP().new Solution();
        
    } 
}