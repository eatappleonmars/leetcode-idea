package utils;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.function.BiFunction;
import java.util.function.Function;

public class TreeNode {

    private static final String NULL = "#";
    private static final String DELIMITER = " ";

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {}

    public TreeNode(int val) { this.val = val; }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * Construct TreeNode given an array of Integer values
     */
    public TreeNode(Integer[] values) {

        // Helper function to construct a TreeNode
        final BiFunction<Integer, Integer[], TreeNode> builder = ((i, vals) -> {
            if (i >= vals.length || vals[i] == null) {
                return null;
            }
            return new TreeNode(vals[i]);
        });

        if (values != null && values.length > 0) {
            Queue<TreeNode> queue = new LinkedList<>();

            this.val = values[0];
            queue.offer(this);

            int i = 1;
            while (i < values.length) {
                TreeNode currRoot = queue.poll();
                if (currRoot == null) {
                    throw new RuntimeException("Error building TreeNode");
                }
                TreeNode lt = builder.apply(i++, values);
                if (lt != null) {
                    currRoot.left = lt;
                    queue.offer(lt);
                }
                TreeNode rt = builder.apply(i++, values);
                if (rt != null) {
                    currRoot.right = rt;
                    queue.offer(rt);
                }
            }
        }
    }

    /**
     * Print tree as a list of values, following level traversal order
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(this);

        boolean containsNonNull = true; // If all tree nodes are null in the next level, no need to print
        while (!queue.isEmpty() && containsNonNull) {
            int levelSize = queue.size();
            containsNonNull = false; // reset to false for each tree level
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    sb.append(NULL).append(DELIMITER);
                } else {
                    sb.append(node.val).append(DELIMITER);
                    queue.offer(node.left);
                    queue.offer(node.right);
                    containsNonNull = (node.left != null || node.right != null);
                }
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(Integer[] array) {
        
        TreeNode root = new TreeNode(array[0]);
        Queue<TreeNode> queue = new LinkedList<>();

        Function<Integer, TreeNode> helper = (integerValue) -> {
            TreeNode node = integerValue == null ? null : new TreeNode(integerValue);
            queue.offer(node);
            return node;
        };

        queue.offer(root);
        constructTreeFromArray(queue, array, helper);
        return root;
    }
    
    private <T> void constructTreeFromArray(Queue<TreeNode> queue, T[] array, Function<T, TreeNode> helper) {
        int i = 1;
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

        queue.offer(root);
        constructTreeFromArray(queue, array, helper);

        return root;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TreeNode other = (TreeNode) o;
        return equals(this, other);
    }

    private boolean equals(TreeNode thisNode, TreeNode otherNode) {
        if (thisNode == otherNode) {
            return true;
        }
        if (thisNode == null || otherNode == null) {
            return false;
        }
        return thisNode.val == otherNode.val && equals(thisNode.left, otherNode.left) && equals(thisNode.right, otherNode.right);
    }
}
