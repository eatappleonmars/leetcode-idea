//Given an array nums of size n, return the majority element. 
//
// The majority element is the element that appears more than ⌊n / 2⌋ times. 
//You may assume that the majority element always exists in the array. 
//
// 
// Example 1: 
// Input: nums = [3,2,3]
//Output: 3
// 
// Example 2: 
// Input: nums = [2,2,1,1,1,2,2]
//Output: 2
// 
// 
// Constraints: 
//
// 
// n == nums.length 
// 1 <= n <= 5 * 10⁴ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// 
//Follow-up: Could you solve the problem in linear time and in 
//O(1) space?
//
// Related Topics Array Hash Table Divide and Conquer Sorting Counting 👍 15434 
//👎 456


package leetcode.editor.en;

// 2023-06-29 20:02:32

public class P169MajorityElement {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int majorityElement(int[] nums) {
            int majority = 0;
            for (int i = 31; i >= 0; i--) {
                // A mask number with single bit=1 at ith location. Example: 00001000
                int mask = 1 << i;
                // Let's count the numbers that has bit=1 at ith location as well.
                int bit1Count = 0;
                for (int n : nums) {
                    if ((n & mask) != 0) {
                        bit1Count++;
                    }
                }
                if (bit1Count > nums.length / 2) {
                    // More than half of the numbers have bit=1 at ith location.
                    // This includes the majority number. So let's set ith location to bit=1
                    majority |= mask;
                }
            }
            return majority;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P169MajorityElement().new Solution();
        
    } 
}