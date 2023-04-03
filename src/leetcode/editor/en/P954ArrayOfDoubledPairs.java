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

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P954ArrayOfDoubledPairs {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canReorderDoubled(int[] arr) {
            // Sort the array
            Arrays.sort(arr);
            // Build the counting map
            Map<Integer, Integer> countMap = new HashMap<>();
            for (int n : arr) {
                countMap.put(n, countMap.getOrDefault(n, 0) + 1);
            }
            // Start from the smallest number which may be negative, example: [-4,-2]
            for (int i = 0; i < arr.length; i++) {
                int n1 = arr[i];
                int count1 = countMap.get(n1);
                if (count1 == 0) { // This indicates the number has been used for pairing
                    continue;
                }
                if (n1 < 0 && n1 % 2 != 0) { // example: cannot pair with -3 because -1.5 does not exist
                    return false;
                }
                int n2 = n1 < 0 ? n1 / 2 : n1 * 2;
                int count2 = countMap.getOrDefault(n2, 0);
                if (count2 == 0) { // no match
                    return false;
                }
                countMap.put(n1, count1 - 1);
                countMap.put(n2, count2 - 1);
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