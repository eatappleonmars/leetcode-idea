//You are given a nested list of integers nestedList. Each element is either an 
//integer or a list whose elements may also be integers or other lists. 
//
// The depth of an integer is the number of lists that it is inside of. For 
//example, the nested list [1,[2,2],[[3],2],1] has each integer's value set to its 
//depth. Let maxDepth be the maximum depth of any integer. 
//
// The weight of an integer is maxDepth - (the depth of the integer) + 1. 
//
// Return the sum of each integer in nestedList multiplied by its weight. 
//
// 
// Example 1: 
//
// 
//Input: nestedList = [[1,1],2,[1,1]]
//Output: 8
//Explanation: Four 1's with a weight of 1, one 2 with a weight of 2.
//1*1 + 1*1 + 2*2 + 1*1 + 1*1 = 8
// 
//
// Example 2: 
//
// 
//Input: nestedList = [1,[4,[6]]]
//Output: 17
//Explanation: One 1 at depth 3, one 4 at depth 2, and one 6 at depth 1.
//1*3 + 4*2 + 6*1 = 17
// 
//
// 
// Constraints: 
//
// 
// 1 <= nestedList.length <= 50 
// The values of the integers in the nested list is in the range [-100, 100]. 
// The maximum depth of any integer is less than or equal to 50. 
// 
// Related Topics Stack Depth-First Search Breadth-First Search 👍 972 👎 292


package leetcode.editor.en;

// 2022-05-05 14:09:47

import utils.NestedInteger;

import java.util.List;

public class P364NestedListWeightSumIi {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * // This is the interface that allows for creating nested lists.
     * // You should not implement it, or speculate about its implementation
     * public interface NestedInteger {
     *     // Constructor initializes an empty nested list.
     *     public NestedInteger();
     *
     *     // Constructor initializes a single integer.
     *     public NestedInteger(int value);
     *
     *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
     *     public boolean isInteger();
     *
     *     // @return the single integer that this NestedInteger holds, if it holds a single integer
     *     // Return null if this NestedInteger holds a nested list
     *     public Integer getInteger();
     *
     *     // Set this NestedInteger to hold a single integer.
     *     public void setInteger(int value);
     *
     *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
     *     public void add(NestedInteger ni);
     *
     *     // @return the nested list that this NestedInteger holds, if it holds a nested list
     *     // Return empty list if this NestedInteger holds a single integer
     *     public List<NestedInteger> getList();
     * }
     */
    class Solution {
        public int depthSumInverse(List<NestedInteger> nestedList) {
            int maxDepth = getMaxDepth(nestedList);
            System.out.println("maxDepth: " + maxDepth);
            return computeWeight(nestedList, 0, maxDepth);
        }

        private int getMaxDepth(List<NestedInteger> nestedList) {
            if (nestedList == null || nestedList.isEmpty()) {
                return 0;
            }
            int maxDepth = 0;
            for (NestedInteger nestedInteger : nestedList) {
                maxDepth = Math.max(maxDepth, getMaxDepth(nestedInteger));
            }
            return maxDepth;
        }

        private int getMaxDepth(NestedInteger nestedInteger) {
            if (nestedInteger.isInteger()) {
                return 1;
            }
            return 1 + getMaxDepth(nestedInteger.getList());
        }

        /**
         * @param currDepth is the depth of list itself.
         *                  Top level list has depth == 0 because top level integer within list has depth == 1
         */
        private int computeWeight(List<NestedInteger> nestedList, int currDepth, int maxDepth) {
            return nestedList == null || nestedList.isEmpty() ? 0 :
                    nestedList.stream()
                            .mapToInt(nestedInteger -> computeWeight(nestedInteger, currDepth + 1, maxDepth))
                            .sum();
        }

        private int computeWeight(NestedInteger nestedInteger, int currDepth, int maxDepth) {
            if (nestedInteger.isInteger()) {
                return nestedInteger.getInteger() * (maxDepth - currDepth + 1);
            }
            return computeWeight(nestedInteger.getList(), currDepth, maxDepth);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P364NestedListWeightSumIi().new Solution();
        
    } 
}