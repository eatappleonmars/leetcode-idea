//Design a data structure to store the strings' count with the ability to 
//return the strings with minimum and maximum counts. 
//
// Implement the AllOne class: 
//
// 
// AllOne() Initializes the object of the data structure. 
// inc(String key) Increments the count of the string key by 1. If key does not 
//exist in the data structure, insert it with count 1. 
// dec(String key) Decrements the count of the string key by 1. If the count of 
//key is 0 after the decrement, remove it from the data structure. It is 
//guaranteed that key exists in the data structure before the decrement. 
// getMaxKey() Returns one of the keys with the maximal count. If no element 
//exists, return an empty string "". 
// getMinKey() Returns one of the keys with the minimum count. If no element 
//exists, return an empty string "". 
// 
//
// 
// Example 1: 
//
// 
//Input
//["AllOne", "inc", "inc", "getMaxKey", "getMinKey", "inc", "getMaxKey", 
//"getMinKey"]
//[[], ["hello"], ["hello"], [], [], ["leet"], [], []]
//Output
//[null, null, null, "hello", "hello", null, "hello", "leet"]
//
//Explanation
//AllOne allOne = new AllOne();
//allOne.inc("hello");
//allOne.inc("hello");
//allOne.getMaxKey(); // return "hello"
//allOne.getMinKey(); // return "hello"
//allOne.inc("leet");
//allOne.getMaxKey(); // return "hello"
//allOne.getMinKey(); // return "leet"
// 
//
// 
// Constraints: 
//
// 
// 1 <= key.length <= 10 
// key consists of lowercase English letters. 
// It is guaranteed that for each call to dec, key is existing in the data 
//structure. 
// At most 5 * 10⁴ calls will be made to inc, dec, getMaxKey, and getMinKey. 
// 
// Related Topics Hash Table Linked List Design Doubly-Linked List 👍 1069 👎 13
//0


package leetcode.editor.en;

// 2022-04-07 09:14:35

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class P432AllOoneDataStructure {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class AllOne {

        class Node {
            String s;
            int count;
            Node prev, next; // double linked
            Node(String key) {
                this.s = key;
                this.count = 1;
            }
        }

        class Block {
            int size;
            Node head, tail;
            Block prev, next; // double linked

            Block() {
                this.size = 0;
                this.head = new Node("");
                this.tail = new Node("");
                this.head.next = this.tail;
                this.tail.prev = this.head;
            }

            Block(Block prev, Block next) {
                this();
                prev.next = this;
                this.prev = prev;
                this.next = next;
                next.prev = this;
            }

            String getString() {
                return this.head.next.s;
            }

            void add(Node node) {
                Node first = this.head.next;

                this.head.next = node;
                node.prev = this.head;
                node.next = first;
                first.prev = node;

                this.size++;
            }

            void remove(Node node) {
                node.prev.next = node.next;
                node.next.prev = node.prev;

                this.size--;
            }

            void isolateFromNeighbor() {
                this.prev.next = this.next;
                this.next.prev = this.prev;
            }
        }

        // Member fields
        private final Map<String, Node> nodeMap; // { string : Node }
        private final Map<Integer, Block> countMap; // { count : Block }
        private final Block  head, tail; // double linked

        public AllOne() {
            this.nodeMap = new HashMap<>();
            this.countMap = new HashMap<>(); // TODO: linked hash map?
            this.head = new Block();
            this.tail = new Block();
            this.head.next = this.tail;
            this.tail.prev = this.head;
        }

        public void inc(String key) {
            Node node = this.nodeMap.get(key);
            if (node == null) {
                createNode(key);
                return;
            }
            int currCount = node.count;
            Block currBlock = this.countMap.get(currCount);
            currBlock.remove(node);

            Block nextBlock = this.countMap.computeIfAbsent(currCount + 1, c -> new Block(currBlock.prev, currBlock));
            nextBlock.add(node);

            if (currBlock.size == 0) {
                currBlock.isolateFromNeighbor();
                this.countMap.remove(node.count);
            }

            node.count++;
        }

        // key guarantees to exist
        public void dec(String key) {
            Node node = this.nodeMap.get(key);
            int currCount = node.count;

            Block currBlock = this.countMap.get(currCount);
            currBlock.remove(node);

            if (currCount == 1) {
                this.nodeMap.remove(node.s);
            } else {
                Block nextBlock = this.countMap.computeIfAbsent(currCount - 1, c -> new Block(currBlock, currBlock.next));
                nextBlock.add(node);
            }

            if (currBlock.size == 0) {
                currBlock.isolateFromNeighbor();
                this.countMap.remove(node.count);
            }
            node.count--;
        }

        public String getMaxKey() {
            Block block = this.head.next;
            if (block == this.tail) {
                return "";
            }
            return block.getString();
        }

        public String getMinKey() {
            Block block = this.tail.prev;
            if (block == this.head) {
                return "";
            }
            return block.getString();
        }

        private void createNode(String key) {
            Node node = new Node(key);
            this.nodeMap.put(key, node);
            Block block = this.countMap.computeIfAbsent(1, c -> new Block(this.tail.prev, this.tail));
            block.add(node);
        }
    }

    /**
     * Your AllOne object will be instantiated and called as such:
     * AllOne obj = new AllOne();
     * obj.inc(key);
     * obj.dec(key);
     * String param_3 = obj.getMaxKey();
     * String param_4 = obj.getMinKey();
     */
    //leetcode submit region end(Prohibit modification and deletion)
}