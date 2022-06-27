//You have k lists of sorted integers in non-decreasing order. Find the 
//smallest range that includes at least one number from each of the k lists. 
//
// We define the range [a, b] is smaller than range [c, d] if b - a < d - c or 
//a < c if b - a == d - c. 
//
// 
// Example 1: 
//
// 
//Input: nums = [[4,10,15,24,26],[0,9,12,20],[5,18,22,30]]
//Output: [20,24]
//Explanation: 
//List 1: [4, 10, 15, 24,26], 24 is in range [20,24].
//List 2: [0, 9, 12, 20], 20 is in range [20,24].
//List 3: [5, 18, 22, 30], 22 is in range [20,24].
// 
//
// Example 2: 
//
// 
//Input: nums = [[1,2,3],[1,2,3],[1,2,3]]
//Output: [1,1]
// 
//
// 
// Constraints: 
//
// 
// nums.length == k 
// 1 <= k <= 3500 
// 1 <= nums[i].length <= 50 
// -10⁵ <= nums[i][j] <= 10⁵ 
// nums[i] is sorted in non-decreasing order. 
// 
// Related Topics Array Hash Table Greedy Sliding Window Sorting Heap (Priority 
//Queue) 👍 2257 👎 37


package leetcode.editor.en;

// 2022-06-24 09:45:45

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class P632SmallestRangeCoveringElementsFromKLists {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] smallestRange(List<List<Integer>> nums) {
            int[][] matrix = convertToMatrix(nums);
            // [ value, row, col ]
            Queue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(pair -> pair[0]));

            int currMax = Integer.MIN_VALUE;
            for (int row = 0; row < matrix.length; row++) {
                int val = matrix[row][0];
                currMax = Math.max(currMax, val);
                minHeap.offer(new int[]{val, row, 0});
            }
            
            int minRange = Integer.MAX_VALUE;
            int[] res = new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE};
            
            while (true) {
                int[] first = minHeap.poll();
                int val = first[0];
                int row = first[1];
                int col = first[2];

                int range = currMax - val;
                if (range < minRange) {
                    minRange = range;
                    res = new int[]{val, currMax};
                }

                if (col + 1 == matrix[row].length) {
                    break;
                }

                int nextVal = matrix[row][col + 1];
                minHeap.offer(new int[]{nextVal, row, col + 1});
                currMax = Math.max(currMax, nextVal);
            }
            
            return res;
        }
        
        private int[][] convertToMatrix(List<List<Integer>> nums) {
            int[][] matrix = new int[nums.size()][];
            int i = 0;
            for (List<Integer> numsRow : nums) {
                matrix[i] = new int[numsRow.size()];
                int j = 0;
                for (int n : numsRow) {
                    matrix[i][j] = n;
                    j++;
                }
                i++;
            }
            return matrix;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P632SmallestRangeCoveringElementsFromKLists().new Solution();
        
    } 
}