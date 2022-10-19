//You are given two arrays of integers nums1 and nums2, possibly of different 
//lengths. The values in the arrays are between 1 and 6, inclusive. 
//
// In one operation, you can change any integer's value in any of the arrays to 
//any value between 1 and 6, inclusive. 
//
// Return the minimum number of operations required to make the sum of values 
//in nums1 equal to the sum of values in nums2. Return -1 if it is not possible to 
//make the sum of the two arrays equal. 
//
// 
// Example 1: 
//
// 
//Input: nums1 = [1,2,3,4,5,6], nums2 = [1,1,2,2,2,2]
//Output: 3
//Explanation: You can make the sums of nums1 and nums2 equal with 3 operations.
// All indices are 0-indexed.
//- Change nums2[0] to 6. nums1 = [1,2,3,4,5,6], nums2 = [6,1,2,2,2,2].
//- Change nums1[5] to 1. nums1 = [1,2,3,4,5,1], nums2 = [6,1,2,2,2,2].
//- Change nums1[2] to 2. nums1 = [1,2,2,4,5,1], nums2 = [6,1,2,2,2,2].
// 
//
// Example 2: 
//
// 
//Input: nums1 = [1,1,1,1,1,1,1], nums2 = [6]
//Output: -1
//Explanation: There is no way to decrease the sum of nums1 or to increase the 
//sum of nums2 to make them equal.
// 
//
// Example 3: 
//
// 
//Input: nums1 = [6,6], nums2 = [1]
//Output: 3
//Explanation: You can make the sums of nums1 and nums2 equal with 3 operations.
// All indices are 0-indexed. 
//- Change nums1[0] to 2. nums1 = [2,6], nums2 = [1].
//- Change nums1[1] to 2. nums1 = [2,2], nums2 = [1].
//- Change nums2[0] to 4. nums1 = [2,2], nums2 = [4].
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums1.length, nums2.length <= 10⁵ 
// 1 <= nums1[i], nums2[i] <= 6 
// 
//
// Related Topics Array Hash Table Greedy Counting 👍 691 👎 24


package leetcode.editor.en;

// 2022-10-11 21:25:24

import java.util.Arrays;
import java.util.Collections;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class P1775EqualSumArraysWithMinimumNumberOfOperations {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minOperations(int[] nums1, int[] nums2) {
            if (!isPossible(nums1, nums2)) {
                return -1;
            }

            int s1 = IntStream.of(nums1).sum();
            int s2 = IntStream.of(nums2).sum();

            if (s1 == s2) {
                return 0;
            }

            if (s1 < s2) {
//                return solveWithSortingAndTwoPointers(nums1, s1, nums2, s2);
                return solveWithCountingDeltas(nums1, s1, nums2, s2);
            } else {
//                return solveWithSortingAndTwoPointers(nums2, s2, nums1, s1);
                return solveWithCountingDeltas(nums2, s2, nums1, s1);
            }
        }

        private boolean isPossible(int[] nums1, int[] nums2) {
            int len1 = nums1.length;
            int len2 = nums2.length;
            return Math.min(len1, len2) * 6 >= Math.max(len1, len2);
        }

        // Time: O(n*log(n))
        // Space: O(1)
        // nums1 is the array with smaller sum
        private int solveWithSortingAndTwoPointers(int[] nums1, int s1,
                                                   int[] nums2, int s2) {


            Arrays.sort(nums1);
            Arrays.sort(nums2);

            int count = 0;
            int i = 0; // index for the smaller array
            int j = nums2.length - 1; // index for the bigger array
            int delta = s2 - s1;
            while (delta > 0) {
                // incr: delta when increasing the smallest element in the smaller array to 6
                int incr = i == nums1.length ? 0 : 6 - nums1[i];
                // decr: delta when decreasing the largest element in the bigger array to 1
                int decr = j == -1 ? 0 : nums2[j] - 1;
                if (incr >= decr) {
                    delta -= incr;
                    i++;
                } else {
                    delta -= decr;
                    j--;
                }
                count++;
            }
            return count;
        }

        // Time: O(m + n)
        // Space: O(1)
        private int solveWithCountingDeltas(int[] nums1, int s1, int[] nums2, int s2) {
            int[] deltaCounts = new int[6];
            IntStream.of(nums1).forEach(n -> deltaCounts[6 - n]++);
            IntStream.of(nums2).forEach(n -> deltaCounts[n - 1]++);
            int delta = s2 - s1;
            int descend = 5;
            int count = 0;
            while (delta > 0) {
                if (deltaCounts[descend] == 0) {
                    descend--;
                    continue;
                }
                delta -= descend;
                deltaCounts[descend]--;
                count++;
            }
            return count;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P1775EqualSumArraysWithMinimumNumberOfOperations().new Solution();
        int[] nums1 = {1,2,3,4,5,6};
        int[] nums2 = {1,1,2,2,2,2};
        System.out.println(sol.minOperations(nums1, nums2));

    } 
}