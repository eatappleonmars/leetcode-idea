//There is an integer array nums sorted in ascending order (with distinct 
//values). 
//
// Prior to being passed to your function, nums is possibly rotated at an 
//unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k]
//, nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For 
//example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0
//,1,2]. 
//
// Given the array nums after the possible rotation and an integer target, 
//return the index of target if it is in nums, or -1 if it is not in nums. 
//
// You must write an algorithm with O(log n) runtime complexity. 
//
// 
// Example 1: 
// Input: nums = [4,5,6,7,0,1,2], target = 0
//Output: 4
// Example 2: 
// Input: nums = [4,5,6,7,0,1,2], target = 3
//Output: -1
// Example 3: 
// Input: nums = [1], target = 0
//Output: -1
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 5000 
// -10⁴ <= nums[i] <= 10⁴ 
// All values of nums are unique. 
// nums is an ascending array that is possibly rotated. 
// -10⁴ <= target <= 10⁴ 
// 
// Related Topics Array Binary Search 👍 14606 👎 915


package leetcode.editor.en;

// 2022-06-02 10:46:53

public class P33SearchInRotatedSortedArray {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {
            int maxIndex = locateMaxIndex(nums);
            int minIndex = (maxIndex + 1) % nums.length;
            if (target >= nums[0]) {
                return binarySearch(nums, 0, maxIndex, target);
            } else {
                return binarySearch(nums, minIndex,nums.length - 1, target);
            }
        }

        private int locateMaxIndex(int[] nums) {
            if (nums[0] <= nums[nums.length - 1]) {
                return nums.length - 1;
            }
            int lt = 0;
            int rt = nums.length - 1;
            while (rt - lt > 1) {
                int mid = lt + (rt - lt) / 2;
                if (nums[mid] > nums[lt]) {
                    lt = mid;
                } else {
                    rt = mid;
                }
            }
            return lt;
        }

        // [lt, rt] is valid, sorted subarray of nums
        private int binarySearch(int[] nums, int lt, int rt, int target) {
            if (target < nums[lt] || target > nums[rt]) {
                return -1;
            }
            while (lt <= rt) {
                int mid = lt + (rt - lt) / 2;
                if (nums[mid] == target) {
                    return mid;
                }
                if (nums[mid] < target) {
                    lt = mid + 1;
                } else {
                    rt = mid - 1;
                }
            }
            return -1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P33SearchInRotatedSortedArray().new Solution();
        
    } 
}