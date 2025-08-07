package Tree;

import java.util.*;

public class TopView {
    public static void main(String[] args) {
        /**
         * Top View of Binary Tree
         * You are given a binary tree, and your task is to return its top view. The top view of a binary tree is the set of nodes visible when the tree is viewed from the top.
         *
         * Note:
         *
         * Return the nodes from the leftmost node to the rightmost node.
         * If two nodes are at the same position (horizontal distance) and are outside the shadow of the tree, consider the leftmost node only.
         * Examples:
         *
         * Input: root[] = [1, 2, 3]
         *
         * Output: [2, 1, 3]
         * Input: root[] = [10, 20, 30, 40, 60, 90, 100]
         *
         * Output: [40, 20, 10, 30, 100]
         * Explanation: The root 10 is visible.
         * On the left, 40 is the leftmost node and visible, followed by 20.
         * On the right, 30 and 100 are visible. Thus, the top view is 40 20 10 30 100.
         * Input: root[] = [1, 2, 3, N, 4, N, N, N, 5, N, 6]
         *        1
         *      /   \
         *     2     3
         *      \
         *       4
         *        \
         *         5
         *          \
         *           6
         * Output: [2, 1, 3, 6]
         * Explanation: Node 1 is the root and visible.
         * Node 2 is the left child and visible from the left side.
         * Node 3 is the right child and visible from the right side.
         * Nodes 4, 5, and 6 are vertically aligned, but only the lowest node 6 is visible from the top view. Thus, the top view is 2 1 3 6.
         * Constraints:
         * 1 ≤ number of nodes ≤ 105
         * 1 ≤ node->data ≤ 105
         *
         * */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<Integer> result = printTopView(root);
        System.out.println("Top view of the tree: " + result);
    }

    static class Pair {
        TreeNode node;
        int horizontalDistance;

        Pair(TreeNode node, int horizontalDistance) {
            this.node = node;
            this.horizontalDistance = horizontalDistance;
        }
    }

    //Solution 1: Using BFS and a HashMap to store the first node at each horizontal distance
    // Time Complexity: O(N), where N is the number of nodes in the tree.
    // Space Complexity: O(N), for the queue and the map.
    public static List<Integer> printTopView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Map<Integer,Integer> map = new HashMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()){
            Pair it = queue.poll();
            int horizontalDistance = it.horizontalDistance;
            TreeNode node = it.node;
            if (map.get(horizontalDistance) == null) map.put(horizontalDistance, node.val);
            if (node.left != null) queue.offer(new Pair(node.left, horizontalDistance - 1));
            if (node.right != null) queue.offer(new Pair(node.right, horizontalDistance + 1));
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ans.add(entry.getValue());
        }
        return ans;
    }

}
