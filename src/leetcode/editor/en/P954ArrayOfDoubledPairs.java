//Given an integer array of even length arr, return true if it is possible to 
//reorder arr such that arr[2 * i + 1] = 2 * arr[2 * i] for every 0 <= i < len(arr) 
/// 2, or false otherwise. 
//
// 
// Example 1: 
//
// 
//Input: arr = [3,1,3,6]
//Output: false
// 
//
// Example 2: 
//
// 
//Input: arr = [2,1,2,6]
//Output: false
// 
//
// Example 3: 
//
// 
//Input: arr = [4,-2,2,-4]
//Output: true
//Explanation: We can take two groups, [-2,-4] and [2,4] to form [-2,-4,2,4] or 
//[2,4,-2,-4].
// 
//
// Example 4: 
//
// 
//Input: arr = [1,2,4,16,8,4]
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 2 <= arr.length <= 3 * 10⁴ 
// arr.length is even. 
// -10⁵ <= arr[i] <= 10⁵ 
// 
// Related Topics Array Hash Table Greedy Sorting 👍 913 👎 104


package leetcode.editor.en;

// 2021-12-06 09:32:48

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class P954ArrayOfDoubledPairs {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canReorderDoubled(int[] arr) {
            Arrays.sort(arr);
            Queue<Integer> queue = new ArrayDeque<>();

            int ltIndex = 0;
            while (ltIndex < arr.length && arr[ltIndex] < 0) {
                if (!check(-arr[ltIndex], queue)) {
                    return false;
                }
                ltIndex++;
            }

            // Done with negative numbers
            if (!queue.isEmpty()) {
                return false;
            }

            // check positive numbers from right
            int rtIndex = arr.length - 1;
            while (rtIndex >= ltIndex) {
                if (!check(arr[rtIndex], queue)) {
                    return false;
                }
                rtIndex--;
            }

            return queue.isEmpty();
        }

        // val >= 0
        // first element in queue is the unmatched largest value
        private boolean check(int val, Queue<Integer> queue) {
            int val2 = val << 1;
            if (queue.isEmpty() || val2 > queue.peek()) {
                queue.offer(val);
            } else if (val2 == queue.peek()) {
                queue.poll();
            } else { // This indicates the largest value can no longer be matched, fast fail
                return false;
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P954ArrayOfDoubledPairs().new Solution();
        
    } 
}