//Given an array of integers nums, sort the array in ascending order. 
//
// 
// Example 1: 
// Input: nums = [5,2,3,1]
//Output: [1,2,3,5]
// Example 2: 
// Input: nums = [5,1,1,2,0,0]
//Output: [0,0,1,1,2,5]
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 5 * 10⁴ 
// -5 * 10⁴ <= nums[i] <= 5 * 10⁴ 
// 
// Related Topics Array Divide and Conquer Sorting Heap (Priority Queue) Merge 
//Sort Bucket Sort Radix Sort Counting Sort 👍 2245 👎 533


package leetcode.editor.en;

// 2022-06-17 09:56:08

public class P912SortAnArray {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortArray(int[] nums) {
            return quickSort(nums);
        }

        private int[] quickSort(int[] nums) {
            quickSort(nums, 0, nums.length - 1);
            return nums;
        }

        private void quickSort(int[] nums, int lt, int rt) {
            if (lt >= rt) {
                return;
            }

            int pivotIndex = lt + (int) (Math.random() * (rt - lt + 1));
            swap(nums, pivotIndex, rt);

            int pivotValue = nums[rt];
            int partitionIndex = lt;
            for (int i = lt; i < rt; i++) {
                if (nums[i] <= pivotValue) {
                    swap(nums, i, partitionIndex);
                    partitionIndex++;
                }
            }
            swap(nums, partitionIndex, rt);

            quickSort(nums, lt, partitionIndex - 1);
            quickSort(nums, partitionIndex + 1, rt);
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
        Solution sol = new P912SortAnArray().new Solution();
        
    } 
}