//A peak element is an element that is strictly greater than its neighbors. 
//
// Given a 0-indexed integer array nums, find a peak element, and return its 
//index. If the array contains multiple peaks, return the index to any of the peaks. 
//
//
// You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is 
//always considered to be strictly greater than a neighbor that is outside the 
//array. 
//
// You must write an algorithm that runs in O(log n) time. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3,1]
//Output: 2
//Explanation: 3 is a peak element and your function should return the index 
//number 2. 
//
// Example 2: 
//
// 
//Input: nums = [1,2,1,3,5,6,4]
//Output: 5
//Explanation: Your function can return either index number 1 where the peak 
//element is 2, or index number 5 where the peak element is 6. 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 1000 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// nums[i] != nums[i + 1] for all valid i. 
// 
//
// Related Topics Array Binary Search 👍 7743 👎 4093


package leetcode.editor.en;

// 2022-11-04 09:40:07

public class P162FindPeakElement {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findPeakElement(int[] nums) {
            final int len = nums.length;
            if (len == 1 || nums[0] > nums[1]) {
                return 0;
            }
            if (nums[len-1] > nums[len-2]) {
                return len - 1;
            }
            int lt = 1, rt = nums.length - 2;
            while (lt < rt) {
                int mid = lt + (rt - lt) / 2;
                if (nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]) {
                    return mid;
                }
                if (nums[mid] < nums[mid-1]) {
                    rt = mid - 1;
                } else {
                    lt = mid + 1;
                }
            }
            return lt;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P162FindPeakElement().new Solution();
        
    } 
}