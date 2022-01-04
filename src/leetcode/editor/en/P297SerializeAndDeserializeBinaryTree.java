//Serialization is the process of converting a data structure or object into a 
//sequence of bits so that it can be stored in a file or memory buffer, or 
//transmitted across a network connection link to be reconstructed later in the same or 
//another computer environment. 
//
// Design an algorithm to serialize and deserialize a binary tree. There is no 
//restriction on how your serialization/deserialization algorithm should work. You 
//just need to ensure that a binary tree can be serialized to a string and this 
//string can be deserialized to the original tree structure. 
//
// Clarification: The input/output format is the same as how LeetCode 
//serializes a binary tree. You do not necessarily need to follow this format, so please be 
//creative and come up with different approaches yourself. 
//
// 
// Example 1: 
//
// 
//Input: root = [1,2,3,null,null,4,5]
//Output: [1,2,3,null,null,4,5]
// 
//
// Example 2: 
//
// 
//Input: root = []
//Output: []
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 10⁴]. 
// -1000 <= Node.val <= 1000 
// 
// Related Topics String Tree Depth-First Search Breadth-First Search Design 
//Binary Tree 👍 5745 👎 231


package leetcode.editor.en;

// 2022-01-04 13:35:45

import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Function;

public class P297SerializeAndDeserializeBinaryTree {
    
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    private static final String NULL = "*";
    private static final String DELIMITER = ",";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();

        if (root == null) {
            return sb.toString();
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            final int levelSize = queue.size();
            boolean allLeaves = true;
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    sb.append(NULL).append(DELIMITER);
                    continue;
                }

                sb.append(node.val).append(DELIMITER);
                queue.offer(node.left);
                queue.offer(node.right);

                allLeaves = allLeaves && (node.left == null && node.right == null);
            }
            
            if (allLeaves) {
                break;
            }
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] array = data.split(DELIMITER);

        TreeNode root = new TreeNode(Integer.parseInt(array[0]));
        Queue<TreeNode> queue = new LinkedList<>();

        Function<String, TreeNode> helper = (strTreeNode) -> {
            TreeNode node = strTreeNode.equals(NULL) ? null : new TreeNode(Integer.parseInt(strTreeNode));
            queue.offer(node);
            return node;
        };

        int i = 1;
        queue.offer(root);
        while (!queue.isEmpty() && i < array.length) {
            TreeNode parent = queue.poll();
            if (parent == null) {
                continue;
            }
            if (i < array.length) {
                parent.left = helper.apply(array[i++]);
            }
            if (i < array.length) {
                parent.right = helper.apply(array[i++]);
            }
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {

    } 
}