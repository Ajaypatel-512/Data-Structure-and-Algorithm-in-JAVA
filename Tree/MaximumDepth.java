package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MaximumDepth {
    /**
     * 104. Maximum Depth of Binary Tree
     * Easy
     * Topics
     * premium lock icon
     * Companies
     * Given the root of a binary tree, return its maximum depth.
     *
     * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
     * Example 1:
     *
     *
     * Input: root = [3,9,20,null,null,15,7]
     * Output: 3
     * Example 2:
     *
     * Input: root = [1,null,2]
     * Output: 2
     *
     *
     * Constraints:
     *
     * The number of nodes in the tree is in the range [0, 104].
     * -100 <= Node.val <= 100
     * */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(maxDepth(root)); // Output: 3
    }

    //Solution 1: using recursion
    // Time Complexity: O(n) where n is the number of nodes in the tree
    // Space Complexity: O(h) where h is the height of the tree (due to recursion stack)
    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int lh = maxDepth(root.left);
        int rh = maxDepth(root.right);

        return 1+Math.max(lh, rh);
    }

    //Solution 2: using iteration (DFS)
    // Time Complexity: O(n) where n is the number of nodes in the tree
    // Space Complexity: O(h) where h is the height of the tree (due to stack)
    private static class Pair {
        TreeNode node;
        int state;

        private Pair(TreeNode node, int state) {
            this.node = node;
            this.state = state;
        }
    }


    public static int maxDepthUsingIterativeDFS(TreeNode root){
        if (root == null) return 0;
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, 1));
        int maxDepth = 0;
        while (!stack.isEmpty()){
            Pair current = stack.pop();
            TreeNode node = current.node;
            int currdepth = current.state;
            if (node != null) {
                maxDepth = Math.max(maxDepth, currdepth);
                stack.push(new Pair(node.left, currdepth + 1));
                stack.push(new Pair(node.right, currdepth + 1));
            }
        }
        return maxDepth;
    }


    //Solution 3: using iteration (BFS)
    // Time Complexity: O(n) where n is the number of nodes in the tree
    // Space Complexity: O(n) where n is the number of nodes in the tree (due to queue)
    public static  int maxDepthUsingBFS(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return 0;
        queue.add(root);
        int depth=0;

        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            depth++;
        }
        return depth;
    }




}
