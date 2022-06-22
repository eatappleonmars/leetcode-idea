//Given an integer array nums and an integer k, return the kᵗʰ largest element 
//in the array. 
//
// Note that it is the kᵗʰ largest element in the sorted order, not the kᵗʰ 
//distinct element. 
//
// 
// Example 1: 
// Input: nums = [3,2,1,5,6,4], k = 2
//Output: 5
// Example 2: 
// Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
//Output: 4
// 
// 
// Constraints: 
//
// 
// 1 <= k <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
// Related Topics Array Divide and Conquer Sorting Heap (Priority Queue) 
//Quickselect 👍 7413 👎 424


package leetcode.editor.en;

// 2021-11-22 21:15:10
public class P215KthLargestElementInAnArray {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            quickSelect(nums, 0, nums.length - 1, k - 1);
            return nums[k - 1];
        }

        private void quickSelect(int[] nums, int beg, int end, final int targetIndex) {
            if (beg >= end || beg > targetIndex || end < targetIndex) {
                return;
            }

            // We need a starting point in order to partition the array
            // "pivot" is the candidate index & value that we begin with
            // By selecting the last element, it makes the process easier
            int randomIndex = beg + (int) (Math.random() * (end - beg + 1));
            swap(nums, randomIndex, end);

            final int pivotValue = nums[end];

            // All values > pivotValue should be put to the left of partitionIndex
            // All values < pivotValue should be put to the right of partitionIndex
            // When partition is completed, partitionIndex should point to the pivotValue
            int partitionIndex = beg;
            for(int i = beg; i < end; i++) {
                if (pivotValue < nums[i]) {
                    swap(nums, partitionIndex, i);
                    partitionIndex++;
                }
            }
            swap(nums, end, partitionIndex);

            if (partitionIndex == targetIndex) {
                return;
            }

            quickSelect(nums, beg, partitionIndex - 1, targetIndex);
            quickSelect(nums, partitionIndex + 1, end, targetIndex);
        }

        private void swap(int[] nums, int i, int j) {
            int n = nums[i];
            nums[i] = nums[j];
            nums[j] = n;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P215KthLargestElementInAnArray().new Solution();
        
    } 
}