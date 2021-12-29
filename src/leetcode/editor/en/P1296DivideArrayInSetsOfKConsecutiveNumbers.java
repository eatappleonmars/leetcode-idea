//Given an array of integers nums and a positive integer k, find whether it is 
//possible to divide this array into sets of k consecutive numbers. 
//
// Return true if it is possible. Otherwise, return false. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3,3,4,4,5,6], k = 4
//Output: true
//Explanation: Array can be divided into [1,2,3,4] and [3,4,5,6].
// 
//
// Example 2: 
//
// 
//Input: nums = [3,2,1,2,3,4,3,4,5,9,10,11], k = 3
//Output: true
//Explanation: Array can be divided into [1,2,3] , [2,3,4] , [3,4,5] and [9,10,1
//1].
// 
//
// Example 3: 
//
// 
//Input: nums = [1,2,3,4], k = 3
//Output: false
//Explanation: Each array should be divided in subarrays of size 3.
// 
//
// 
// Constraints: 
//
// 
// 1 <= k <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁹ 
// 
//
// 
//Note: This question is the same as 846: https://leetcode.com/problems/hand-of-
//straights/ Related Topics Array Hash Table Greedy Sorting 👍 949 👎 75


package leetcode.editor.en;

// 2021-12-28 09:56:46

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class P1296DivideArrayInSetsOfKConsecutiveNumbers {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPossibleDivide(int[] nums, int k) {
            int len = nums.length;
            // Check mod
            if (len % k != 0) {
                return false;
            }

            Map<Integer, Integer> countingMap = new HashMap<>();
            for (int n : nums) {
                countingMap.put(n, countingMap.getOrDefault(n, 0) + 1);
            }

            Arrays.sort(nums);
            for (int n : nums) {
                int c = countingMap.get(n);
                if (c == 0) {
                    continue;
                }
                countingMap.replace(n, c - 1);
                for (int i = 1; i < k; i++) { // build subset [n, member...]
                    int member = n + i;
                    c = countingMap.getOrDefault(member, -1);
                    if (c <= 0) return false;
                    countingMap.replace(member, c - 1);
                }
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P1296DivideArrayInSetsOfKConsecutiveNumbers().new Solution();
        
    } 
}