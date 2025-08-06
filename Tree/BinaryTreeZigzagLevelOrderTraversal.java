package Tree;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {
    /**
     * 103. Binary Tree Zigzag Level Order Traversal
     * Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).
     * Example 1:
     * Input: root = [3,9,20,null,null,15,7]
     * Output: [[3],[20,9],[15,7]]
     * Example 2:
     *
     * Input: root = [1]
     * Output: [[1]]
     * Example 3:
     *
     * Input: root = []
     * Output: []
     *
     * Constraints:
     *
     * The number of nodes in the tree is in the range [0, 2000].
     * -100 <= Node.val <= 100
     * */
    public static void main(String[] args) {
        // Example usage
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> list = zigzagLevelOrder(root);
        for (List<Integer> level : list) {
            System.out.println(level);
        }
    }

    //Solution 1: Using BFS with a queue to traverse the tree level by level, toggling the order of insertion for each level.
    // Time Complexity: O(n), where n is the number of nodes in the tree.
    // Space Complexity: O(n), where n is the maximum number of nodes at any level in the tree (the width of the tree).
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();
        if(root == null) return result;

        queue.offer(root);
        boolean leftToRight = true;

        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList<>(size);
            for (int i=0; i<size; i++){
                TreeNode node = queue.poll();
                if (leftToRight) {
                    level.add(node.val); // Add from left to right
                } else {
                    level.add(0, node.val); // Add from right to left
                }
                if (node.left != null) {
                    queue.offer(node.left); // Add left child to queue
                }
                if (node.right != null) {
                    queue.offer(node.right); // Add right child to queue
                }
            }
        leftToRight = !leftToRight; // Toggle direction for next level
        result.add(level);
        }
        return result;
    }
}
