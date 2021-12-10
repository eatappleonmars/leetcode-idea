package utils;

import java.util.LinkedList;
import java.util.Queue;
import java.util.function.BiFunction;

public class TreeNode {

    private static final String NULL = "#";
    private static final String SPACE = " ";

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
                    sb.append(NULL).append(SPACE);
                } else {
                    sb.append(node.val).append(SPACE);
                    queue.offer(node.left);
                    queue.offer(node.right);
                    containsNonNull = (node.left != null || node.right != null);
                }
            }
        }
        return sb.toString();
    }
}
