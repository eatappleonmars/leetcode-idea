//RandomizedCollection is a data structure that contains a collection of 
//numbers, possibly duplicates (i.e., a multiset). It should support inserting and 
//removing specific elements and also removing a random element. 
//
// Implement the RandomizedCollection class: 
//
// 
// RandomizedCollection() Initializes the empty RandomizedCollection object. 
// bool insert(int val) Inserts an item val into the multiset, even if the item 
//is already present. Returns true if the item is not present, false otherwise. 
// bool remove(int val) Removes an item val from the multiset if present. 
//Returns true if the item is present, false otherwise. Note that if val has multiple 
//occurrences in the multiset, we only remove one of them. 
// int getRandom() Returns a random element from the current multiset of 
//elements. The probability of each element being returned is linearly related to the 
//number of same values the multiset contains. 
// 
//
// You must implement the functions of the class such that each function works 
//on average O(1) time complexity. 
//
// Note: The test cases are generated such that getRandom will only be called 
//if there is at least one item in the RandomizedCollection. 
//
// 
// Example 1: 
//
// 
//Input
//["RandomizedCollection", "insert", "insert", "insert", "getRandom", "remove", 
//"getRandom"]
//[[], [1], [1], [2], [], [1], []]
//Output
//[null, true, false, true, 2, true, 1]
//
//Explanation
//RandomizedCollection randomizedCollection = new RandomizedCollection();
//randomizedCollection.insert(1);   // return true since the collection does 
//not contain 1.
//                                  // Inserts 1 into the collection.
//randomizedCollection.insert(1);   // return false since the collection 
//contains 1.
//                                  // Inserts another 1 into the collection. 
//Collection now contains [1,1].
//randomizedCollection.insert(2);   // return true since the collection does 
//not contain 2.
//                                  // Inserts 2 into the collection. 
//Collection now contains [1,1,2].
//randomizedCollection.getRandom(); // getRandom should:
//                                  // - return 1 with probability 2/3, or
//                                  // - return 2 with probability 1/3.
//randomizedCollection.remove(1);   // return true since the collection 
//contains 1.
//                                  // Removes 1 from the collection. 
//Collection now contains [1,2].
//randomizedCollection.getRandom(); // getRandom should return 1 or 2, both 
//equally likely.
// 
//
// 
// Constraints: 
//
// 
// -2³¹ <= val <= 2³¹ - 1 
// At most 2 * 10⁵ calls in total will be made to insert, remove, and getRandom.
// 
// There will be at least one element in the data structure when getRandom is 
//called. 
// 
// Related Topics Array Hash Table Math Design Randomized 👍 1584 👎 114


package leetcode.editor.en;

// 2022-04-09 14:42:30

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class P381InsertDeleteGetrandomO1DuplicatesAllowed {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class RandomizedCollection {

        private List<Integer> values;
        private Map<Integer, Set<Integer>> map; // { value : indexes }
        private Random random;

        public RandomizedCollection() {
            this.values = new ArrayList<>();
            this.map = new HashMap<>();
            this.random = new Random();
        }

        public boolean insert(int val) {
            Set<Integer> indexes = map.computeIfAbsent(val, v -> new HashSet<>());
            indexes.add(values.size());
            values.add(val);
            return indexes.size() == 1;
        }

        public boolean remove(int val) {
            Set<Integer> indexes = map.get(val);
            if (indexes == null || indexes.size() == 0) {
                return false;
            }
            // Remove value at index
            int index = indexes.iterator().next();
            indexes.remove(index);

            // Now index is empty. Move last element to index.
            int lastIndex = values.size() - 1;
            int lastValue = values.get(lastIndex);
            Set<Integer> lastValueIndexes = map.get(lastValue);

            values.set(index, lastValue);
            values.remove(lastIndex);

            lastValueIndexes.add(index);
            lastValueIndexes.remove(lastIndex);

            return true;
        }

        public int getRandom() {
            return values.get(random.nextInt(values.size()));
        }
    }

    /**
     * Your RandomizedCollection object will be instantiated and called as such:
     * RandomizedCollection obj = new RandomizedCollection();
     * boolean param_1 = obj.insert(val);
     * boolean param_2 = obj.remove(val);
     * int param_3 = obj.getRandom();
     */
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P381InsertDeleteGetrandomO1DuplicatesAllowed().new Solution();
        
    } 
}