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

import java.util.PriorityQueue;
import java.util.Queue;

public class P215KthLargestElementInAnArray {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            Queue<Integer> minHeap = new PriorityQueue<>();
            for (int n : nums) {
                if (minHeap.size() < k) {
                    minHeap.offer(n);
                } else if (n > minHeap.peek()) {
                    minHeap.poll();
                    minHeap.offer(n);
                }
            }
            return minHeap.peek();
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