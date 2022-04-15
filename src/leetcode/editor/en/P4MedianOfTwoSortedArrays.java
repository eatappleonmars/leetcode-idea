//Given two sorted arrays nums1 and nums2 of size m and n respectively, return 
//the median of the two sorted arrays. 
//
// The overall run time complexity should be O(log (m+n)). 
//
// 
// Example 1: 
//
// 
//Input: nums1 = [1,3], nums2 = [2]
//Output: 2.00000
//Explanation: merged array = [1,2,3] and median is 2.
// 
//
// Example 2: 
//
// 
//Input: nums1 = [1,2], nums2 = [3,4]
//Output: 2.50000
//Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
// 
//
// 
// Constraints: 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -10⁶ <= nums1[i], nums2[i] <= 10⁶ 
// 
// Related Topics Array Binary Search Divide and Conquer 👍 15970 👎 1963


package leetcode.editor.en;

// 2022-04-15 10:00:23

public class P4MedianOfTwoSortedArrays {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int i = 0, j = 0;
        
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {

            final int m = nums1.length;
            final int n = nums2.length;
            final int len = m + n;
            final int half = (len - 1) / 2;
            
            int k = 0;

            while (k < half) {
                getSmallerValueAndIncrement(nums1, nums2);
                k++;
            }

            double median = getSmallerValueAndIncrement(nums1, nums2);

            if (len % 2 == 0) {
                double median2 = getSmallerValueAndIncrement(nums1, nums2);
                median = (median + median2) / 2;
            }

            return median;
        }

        private int getSmallerValueAndIncrement (int[] nums1, int[] nums2) {
            if ((j == nums2.length) || (i < nums1.length && nums1[i] <= nums2[j])) {
                return nums1[i++];
            } else {
                return nums2[j++];
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P4MedianOfTwoSortedArrays().new Solution();
        
    } 
}