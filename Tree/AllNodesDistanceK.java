package Tree;

import java.util.*;

public class AllNodesDistanceK {
    /**
     * 863. All Nodes Distance K in Binary Tree
     * Given the root of a binary tree, the value of a target node target, and an integer k, return an array of the values of all nodes that have a distance k from the target node.
     *
     * You can return the answer in any order.
     *
     *
     *
     * Example 1:
     *
     *
     * Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
     * Output: [7,4,1]
     * Explanation: The nodes that are a distance 2 from the target node (with value 5) have values 7, 4, and 1.
     * Example 2:
     *
     * Input: root = [1], target = 1, k = 3
     * Output: []
     *
     *
     * Constraints:
     *
     * The number of nodes in the tree is in the range [1, 500].
     * 0 <= Node.val <= 500
     * All the values Node.val are unique.
     * target is the value of one of the nodes in the tree.
     * 0 <= k <= 1000
     * */
    public static void main(String[] args) {
        // Example usage
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        TreeNode target = new TreeNode(5);
        int k = 2;

        System.out.println(distanceK(root, target, k)); // Output: [7, 4, 1]
    }

    // Solution 1: Using BFS to find all nodes at distance K from the target node
    // Time Complexity: O(n) + O(n), where n is the number of nodes in the tree
    // Space Complexity: O(n), for the queue and parent tracking map
    private static void markParents(TreeNode root, Map<TreeNode, TreeNode> parent_track, TreeNode target) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current.left != null) {
                parent_track.put(current.left, current);
                queue.offer(current.left);
            }
            if (current.right != null) {
                parent_track.put(current.right, current);
                queue.offer(current.right);
            }
        }
    }

    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parent_track = new HashMap<>();
        markParents(root, parent_track, root);

        Map<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        visited.put(target, true);
        int curr_level = 0;

        while (!queue.isEmpty()) { // Second BFS to go up to K level from target node and using our hashtable info
            int size = queue.size();
            if (curr_level == k) break;
            curr_level++;

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();

                if (current.left != null && visited.get(current.left) == null) {
                    queue.offer(current.left);
                    visited.put(current.left, true);
                }

                if (current.right != null && visited.get(current.right) == null) {
                    queue.offer(current.right);
                    visited.put(current.right, true);
                }

                if (parent_track.get(current) != null && visited.get(parent_track.get(current)) == null) {
                    queue.offer(parent_track.get(current));
                    visited.put(parent_track.get(current), true);
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            result.add(current.val);
        }

        return result;
    }
}
