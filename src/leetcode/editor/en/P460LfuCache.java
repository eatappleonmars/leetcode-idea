//Design and implement a data structure for a Least Frequently Used (LFU) cache.
// 
//
// Implement the LFUCache class: 
//
// 
// LFUCache(int capacity) Initializes the object with the capacity of the data 
//structure. 
// int get(int key) Gets the value of the key if the key exists in the cache. 
//Otherwise, returns -1. 
// void put(int key, int value) Update the value of the key if present, or 
//inserts the key if not already present. When the cache reaches its capacity, it 
//should invalidate and remove the least frequently used key before inserting a new 
//item. For this problem, when there is a tie (i.e., two or more keys with the same 
//frequency), the least recently used key would be invalidated. 
// 
//
// To determine the least frequently used key, a use counter is maintained for 
//each key in the cache. The key with the smallest use counter is the least 
//frequently used key. 
//
// When a key is first inserted into the cache, its use counter is set to 1 (
//due to the put operation). The use counter for a key in the cache is incremented 
//either a get or put operation is called on it. 
//
// The functions get and put must each run in O(1) average time complexity. 
//
// 
// Example 1: 
//
// 
//Input
//["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", 
//"get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
//Output
//[null, null, null, 1, null, -1, 3, null, -1, 3, 4]
//
//Explanation
//// cnt(x) = the use counter for key x
//// cache=[] will show the last used order for tiebreakers (leftmost element 
//is  most recent)
//LFUCache lfu = new LFUCache(2);
//lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
//lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
//lfu.get(1);      // return 1
//                 // cache=[1,2], cnt(2)=1, cnt(1)=2
//lfu.put(3, 3);   // 2 is the LFU key because cnt(2)=1 is the smallest, 
//invalidate 2.
//                 // cache=[3,1], cnt(3)=1, cnt(1)=2
//lfu.get(2);      // return -1 (not found)
//lfu.get(3);      // return 3
//                 // cache=[3,1], cnt(3)=2, cnt(1)=2
//lfu.put(4, 4);   // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1
//.
//                 // cache=[4,3], cnt(4)=1, cnt(3)=2
//lfu.get(1);      // return -1 (not found)
//lfu.get(3);      // return 3
//                 // cache=[3,4], cnt(4)=1, cnt(3)=3
//lfu.get(4);      // return 4
//                 // cache=[4,3], cnt(4)=2, cnt(3)=3
// 
//
// 
// Constraints: 
//
// 
// 0 <= capacity <= 10⁴ 
// 0 <= key <= 10⁵ 
// 0 <= value <= 10⁹ 
// At most 2 * 10⁵ calls will be made to get and put. 
// 
//
// 
// Related Topics Hash Table Linked List Design Doubly-Linked List 👍 3086 👎 20
//2


package leetcode.editor.en;

// 2022-04-04 17:12:18

import java.util.HashMap;
import java.util.Map;

public class P460LfuCache {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class LFUCache {

        class LFUNode {
            int key, val, frequency;
            LFUNode prev, next; // double linked

            LFUNode(int key, int val) {
                this.key = key;
                this.val = val;
                this.frequency = 1;
            }

            void insert(LFUNode prev, LFUNode next) {
                prev.next = this;
                this.prev = prev;
                this.next = next;
                next.prev = this;
            }

            void removeSelf() {
                this.prev.next = this.next;
                this.next.prev = this.prev;
            }
        }

        class LFUBlock {
            int size;
            LFUNode headNode, tailNode;

            LFUBlock() {
                this.size = 0;
                this.headNode = new LFUNode(-1, -1);
                this.tailNode = new LFUNode(-1, -1);

                this.headNode.next = this.tailNode;
                this.tailNode.prev = this.headNode;
            }

            // Add node to the block as the first node
            void add(LFUNode node) {
                this.size++;
                node.insert(this.headNode, this.headNode.next);
            }

            // Remove node from block
            void remove(LFUNode node) {
                this.size--;
                node.removeSelf();
            }

            // Remove the last node from block
            LFUNode removeLastNode() {
                LFUNode last = this.tailNode.prev;
                remove(last);
                return last;
            }
        }

        private int minFrequency;
        private final int capacity;
        Map<Integer, LFUNode> cacheMap; // { key : LFUNode }
        Map<Integer, LFUBlock> frequencyMap; // { frequency : LFUBlock }

        // Main entry method
        public LFUCache(int capacity) {
            this.minFrequency = 0;
            this.capacity = capacity;
            this.cacheMap = new HashMap<>(capacity);
            this.frequencyMap = new HashMap<>();
        }

        public int get(int key) {
            if (this.capacity == 0) {
                return -1;
            }
            LFUNode node = this.cacheMap.get(key);
            if (node == null) {
                return -1;
            }
            update(node);
            return node.val;
        }

        public void put(int key, int value) {
            if (this.capacity == 0) {
                return;
            }
            LFUNode node = this.cacheMap.get(key);
            if (node != null) {
                node.val = value;
                update(node);
                return;
            }
            // Evict least frequent, least recently used node
            if (this.cacheMap.size() == this.capacity) {
                LFUNode lastNode = this.frequencyMap.get(this.minFrequency).removeLastNode();
                this.cacheMap.remove(lastNode.key);
            }
            // Create new node
            node = new LFUNode(key, value);
            this.cacheMap.put(key, node);
            this.minFrequency = 1;
            addNodeToBlock(node);
        }

        private void update(LFUNode node) {
            // Remove node from its current block
            LFUBlock currBlock = this.frequencyMap.get(node.frequency);
            currBlock.remove(node);
            if (node.frequency == this.minFrequency && currBlock.size == 0) {
                this.minFrequency++;
            }
            node.frequency++;
            addNodeToBlock(node);
        }

        private void addNodeToBlock(LFUNode node) {
            LFUBlock targetBlock = this.frequencyMap.computeIfAbsent(node.frequency, freq -> new LFUBlock());
            targetBlock.add(node);
        }
    }

    /**
     * Your LFUCache object will be instantiated and called as such:
     * LFUCache obj = new LFUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */
    //leetcode submit region end(Prohibit modification and deletion)
}