package Tree;

import java.util.*;

public class BottomView {
    /**
     * Bottom View of Binary Tree
     * Difficulty: MediumAccuracy: 54.18%Submissions: 316K+Points: 4Average Time: 45m
     * Given a binary tree, return an array where elements represent the bottom view of the binary tree from left to right.
     *
     * Note: If there are multiple bottom-most nodes for a horizontal distance from the root, then the later one in the level order traversal is considered. For example, in the below diagram, 7 and 34 both are the bottommost nodes at a horizontal distance of 0 from the root, here 34 will be considered.
     *
     * For the above tree, the output should be 5 8 34 22 25
     *
     * Examples :
     *
     * Input: root[] = [1, 3, 2]
     *
     * Output: [3 1 2]
     * Explanation: First case represents a tree with 3 nodes and 2 edges where root is 1, left child of 1 is 3 and right child of 1 is 2.
     *
     * Thus bottom view of the binary tree will be 3 1 2.
     * Input: root[] = [10, 20, 30, 40, 60]
     *
     * Output: [40 20 60 30]
     * Constraints:
     * 1 <= number of nodes <= 105
     * 1 <= node->data <= 105
     * */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<Integer> result = printBottomView(root);
        System.out.println("Bottom view of the tree: " + result);
    }

    static class Pair {
        TreeNode node;
        int horizontalDistance;

        Pair(TreeNode node, int horizontalDistance) {
            this.node = node;
            this.horizontalDistance = horizontalDistance;
        }
    }

    //Solution 1: Using BFS with a HashMap to store the last node at each horizontal distance
    // Time Complexity: O(N), where N is the number of nodes in the tree.
    // Space Complexity: O(N), for the queue and the map.
    private static List<Integer> printBottomView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Map<Integer,Integer> map = new HashMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()){
            Pair it = queue.poll();
            int horizontalDistance = it.horizontalDistance;
            TreeNode node = it.node;
            map.put(horizontalDistance, node.val);
            if (node.left != null) queue.offer(new Pair(node.left, horizontalDistance - 1));
            if (node.right != null) queue.offer(new Pair(node.right, horizontalDistance + 1));
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ans.add(entry.getValue());
        }
        return ans;
    }
}
