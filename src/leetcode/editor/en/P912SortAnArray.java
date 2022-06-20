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
            int pivotIndex = quickSortPartition(nums, lt, rt);
            quickSort(nums, lt, pivotIndex - 1);
            quickSort(nums, pivotIndex + 1, rt);
        }

        /**
         * Randomly select a pivot value, and partition the nums array such that
         *   values <= pivot value are put on the left  side of the pivot value, and
         *   values >  pivot value are put on the right side of the pivot value
         * Return the pivot index
         */
        private int quickSortPartition(int[] nums, int lt, int rt) {
            // To avoid worst case scenario which has O(n^2)
            int randomIndex = lt + (int) (Math.random() * (rt - lt + 1));
            // Swap pivot value with leftmost value
            swap(nums, lt, randomIndex);
            // nums[candidateIndex] is the first value > pivotValue, and hence could be
            // used to swap for later values <= pivotValues
            int candidateIndex = lt + 1;
            // Clever method below::
            // Leave pivot (namely, nums[lt]) where it is for the moment to avoid unnecessary swaps or
            // the need to determine if looking left or right
            int pivotValue = nums[lt];
            for (int i = lt + 1; i <= rt; i++) {
                if (nums[i] <= pivotValue) {
                    swap(nums, i, candidateIndex);
                    candidateIndex++;
                }
            }
            // Now swap pivot to the proper place to the last valid index at which the value <= pivotValue
            swap(nums, lt, candidateIndex - 1);

            return candidateIndex - 1;
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