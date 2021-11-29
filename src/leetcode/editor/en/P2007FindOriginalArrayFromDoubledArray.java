//An integer array original is transformed into a doubled array changed by 
//appending twice the value of every element in original, and then randomly shuffling 
//the resulting array. 
//
// Given an array changed, return original if changed is a doubled array. If 
//changed is not a doubled array, return an empty array. The elements in original 
//may be returned in any order. 
//
// 
// Example 1: 
//
// 
//Input: changed = [1,3,4,2,6,8]
//Output: [1,3,4]
//Explanation: One possible original array could be [1,3,4]:
//- Twice the value of 1 is 1 * 2 = 2.
//- Twice the value of 3 is 3 * 2 = 6.
//- Twice the value of 4 is 4 * 2 = 8.
//Other original arrays could be [4,3,1] or [3,1,4].
// 
//
// Example 2: 
//
// 
//Input: changed = [6,3,0,1]
//Output: []
//Explanation: changed is not a doubled array.
// 
//
// Example 3: 
//
// 
//Input: changed = [1]
//Output: []
//Explanation: changed is not a doubled array.
// 
//
// 
// Constraints: 
//
// 
// 1 <= changed.length <= 10⁵ 
// 0 <= changed[i] <= 10⁵ 
// 
// Related Topics Array Hash Table Greedy Sorting 👍 281 👎 27


package leetcode.editor.en;

// 2021-11-28 16:07:09

import java.util.Map;
import java.util.TreeMap;

public class P2007FindOriginalArrayFromDoubledArray {
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] findOriginalArray(int[] changed) {
        int len = changed.length;
        if (len == 0 || len % 2 != 0) {
            return new int[0];
        }

        int[] original = new int[len / 2];
        Map<Integer, Integer> map = new TreeMap<>();

        for (int n : changed) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        int i = 0;
        for (int n : map.keySet()) {
            int count_n = map.get(n);
            // 0 is special because 2*0=0. It will ruin the frequency check below
            if (n == 0) {
                i += count_n >> 1;
                continue;
            }
            // frequency check
            int m = n << 1; // m = 2n
            int count_m = map.getOrDefault(m, 0);
            // In addition to <n, m> pairs, there could be other <m, 2m> pairs, hence check > instead of ==
            if (count_n > count_m) { // frequency check fails
                return new int[0];
            }
            // frequency check succeeds, add n to result
            for (int j = 0; j < count_n; j++) {
                original[i] = n;
                i++;
            }
            // Update entry for m.
            // Attention: cannot use map.put() here due to ConcurrentModificationException
            // caused by adding(put) element while iteration the map
            map.replace(m, count_m - count_n);
        }

        return original;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P2007FindOriginalArrayFromDoubledArray().new Solution();
        final int[] changes = {6,3,0,1};
        final int[] original = sol.findOriginalArray(changes);
        for (int n : original) {
            System.out.println(n);
        }
    } 
}