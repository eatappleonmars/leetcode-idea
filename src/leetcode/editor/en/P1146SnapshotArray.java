//Implement a SnapshotArray that supports the following interface: 
//
// 
// SnapshotArray(int length) initializes an array-like data structure with the 
//given length. Initially, each element equals 0. 
// void set(index, val) sets the element at the given index to be equal to val. 
//
// int snap() takes a snapshot of the array and returns the snap_id: the total 
//number of times we called snap() minus 1. 
// int get(index, snap_id) returns the value at the given index, at the time we 
//took the snapshot with the given snap_id 
// 
//
// 
// Example 1: 
//
// 
//Input: ["SnapshotArray","set","snap","set","get"]
//[[3],[0,5],[],[0,6],[0,0]]
//Output: [null,null,0,null,5]
//Explanation: 
//SnapshotArray snapshotArr = new SnapshotArray(3); // set the length to be 3
//snapshotArr.set(0,5);  // Set array[0] = 5
//snapshotArr.snap();  // Take a snapshot, return snap_id = 0
//snapshotArr.set(0,6);
//snapshotArr.get(0,0);  // Get the value of array[0] with snap_id = 0, return 5
// 
//
// 
// Constraints: 
//
// 
// 1 <= length <= 50000 
// At most 50000 calls will be made to set, snap, and get. 
// 0 <= index < length 
// 0 <= snap_id < (the total number of times we call snap()) 
// 0 <= val <= 10^9 
// 
// Related Topics Array Hash Table Binary Search Design 👍 1212 👎 205


package leetcode.editor.en;

// 2021-11-28 12:43:00

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class P1146SnapshotArray {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class SnapshotArray {

        private int snapId; // next available snapshot id
        private List<TreeMap<Integer, Integer>> snapshotArray; // [<snapshotId : snapshotValue>]

        public SnapshotArray(int length) {
            this.snapId = 0;
            this.snapshotArray = new ArrayList<>(length);
            for (int i = 0; i < length; i++) {
                TreeMap<Integer, Integer> snapHistory = new TreeMap<>();
                // Problem statement doesn't mention such an edge case that snapshot can be taken before any set operation
                snapHistory.put(0, 0);
                this.snapshotArray.add(snapHistory);
            }
        }

        // When value changes, create a new or update an existing snapshot
        public void set(int index, int val) {
            this.snapshotArray.get(index).put(this.snapId, val);
        }

        // Only take the snap if value changes
        public int snap() {
            this.snapId++;
            return this.snapId - 1;
        }

        public int get(int index, int snap_id) {
            TreeMap<Integer, Integer> snapHistory = snapshotArray.get(index);
            return snapHistory.floorEntry(snap_id).getValue();
        }
    }

    /**
     * Your SnapshotArray object will be instantiated and called as such:
     * SnapshotArray obj = new SnapshotArray(length);
     * obj.set(index,val);
     * int param_2 = obj.snap();
     * int param_3 = obj.get(index,snap_id);
     */
    //leetcode submit region end(Prohibit modification and deletion)
}