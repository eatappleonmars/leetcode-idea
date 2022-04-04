//Design a data structure that follows the constraints of a Least Recently Used 
//(LRU) cache. 
//
// Implement the LRUCache class: 
//
// 
// LRUCache(int capacity) Initialize the LRU cache with positive size capacity. 
//
// int get(int key) Return the value of the key if the key exists, otherwise 
//return -1. 
// void put(int key, int value) Update the value of the key if the key exists. 
//Otherwise, add the key-value pair to the cache. If the number of keys exceeds 
//the capacity from this operation, evict the least recently used key. 
// 
//
// The functions get and put must each run in O(1) average time complexity. 
//
// 
// Example 1: 
//
// 
//Input
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//Output
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//Explanation
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // cache is {1=1}
//lRUCache.put(2, 2); // cache is {1=1, 2=2}
//lRUCache.get(1);    // return 1
//lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
//lRUCache.get(2);    // returns -1 (not found)
//lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
//lRUCache.get(1);    // return -1 (not found)
//lRUCache.get(3);    // return 3
//lRUCache.get(4);    // return 4
// 
//
// 
// Constraints: 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 10⁴ 
// 0 <= value <= 10⁵ 
// At most 2 * 10⁵ calls will be made to get and put. 
// 
// Related Topics Hash Table Linked List Design Doubly-Linked List 👍 12659 👎 4
//91


package leetcode.editor.en;

// 2022-04-04 09:32:20

import java.util.HashMap;
import java.util.Map;

public class P146LruCache {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache {

        class LRUNode {
            int key;
            int val;
            LRUNode prev;
            LRUNode next;

            LRUNode(int k, int v) {
                this.key = k;
                this.val = v;
            }
        }

        private final int capacity;
        private final Map<Integer, LRUNode> map;
        private final LRUNode head;
        private final LRUNode tail;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.map = new HashMap<>(capacity);
            this.head = new LRUNode(-1, -1);
            this.tail = new LRUNode(-1, -1);
            this.head.next = tail;
            this.tail.prev = head;
        }

        public int get(int key) {
            LRUNode node = map.get(key);
            if (node == null) {
                return -1;
            }
            moveToFirst(node);
            return node.val;
        }

        public void put(int key, int value) {
            LRUNode node = map.get(key);
            if (node != null) {
                node.val = value;
                moveToFirst(node);
            } else {
                LRUNode newNode = new LRUNode(key, value);
                addNode(newNode);
                map.put(key, newNode);

                if (map.size() > this.capacity) {
                    LRUNode last = this.tail.prev;
                    removeNodeFromList(last);
                    map.remove(last.key);
                }
            }
        }

        private void moveToFirst(LRUNode node) {
            removeNodeFromList(node);
            addNode(node);
        }

        private void removeNodeFromList(LRUNode node) {
            LRUNode prev = node.prev;
            LRUNode next = node.next;

            prev.next = next;
            next.prev = prev;
        }

        private void addNode(LRUNode node) {
            LRUNode first = this.head.next;

            node.prev = this.head;
            node.next = first;

            this.head.next = node;
            first.prev = node;
        }
    }

    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P146LruCache().new Solution();
        
    } 
}