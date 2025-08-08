package Tree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MaximumWidth {
    /**
     * 662. Maximum Width of Binary Tree
     * Given the root of a binary tree, return the maximum width of the given tree.
     * The maximum width of a tree is the maximum width among all levels.
     * The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes), where the null nodes between the end-nodes that would be present in a complete binary tree extending down to that level are also counted into the length calculation.
     * It is guaranteed that the answer will in the range of a 32-bit signed integer.
     * Example 1:
     *
     * Input: root = [1,3,2,5,3,null,9]
     * Output: 4
     * Explanation: The maximum width exists in the third level with length 4 (5,3,null,9).
     * Example 2:
     * Input: root = [1,3,2,5,null,null,9,6,null,7]
     * Output: 7
     * Explanation: The maximum width exists in the fourth level with length 7 (6,null,null,null,null,null,7).
     * Example 3:
     *
     * Input: root = [1,3,2,5]
     * Output: 2
     * Explanation: The maximum width exists in the second level with length 2 (3,2).
     *
     * Constraints:
     * The number of nodes in the tree is in the range [1, 3000].
     * -100 <= Node.val <= 100
     * */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);

        System.out.println(widthOfBinaryTree(root)); // Output: 4
    }

    static class Pair {
        TreeNode node;
        int num;

        Pair(TreeNode node, int num) {
            this.node = node;
            this.num = num;
        }
    }

    //Solution 1: Using BFS with a queue to track the indices of nodes
    //Time Complexity: O(n), where n is the number of nodes in the tree
    //Space Complexity: O(n), for the queue used in BFS
    public static int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> queue = new LinkedList<>();
        if (root == null) return 0;
        int ans = 0;
        queue.add(new Pair(root, 0));


        while(!queue.isEmpty()){
            int size = queue.size();
            int min = queue.peek().num; // Get the first node's index in the current level
            int first = 0;
            int last = 0;
            for(int i=0; i<size; i++){
                int currId = queue.peek().num - min; // Normalize the index to prevent overflow
                TreeNode currNode = queue.peek().node;
                queue.poll();
                if(i == 0) first = currId; // First node's index in the current level
                if(i == size - 1) last = currId; // Last node's index in the current level
                if(currNode.left != null) {
                    queue.add(new Pair(currNode.left, currId * 2 + 1)); // Left child index
                }
                if(currNode.right != null) {
                    queue.add(new Pair(currNode.right, currId * 2 + 2)); // Right child index
                }
            }
            ans = Math.max(ans, last - first + 1); // Calculate the width of the current level
        }
        return ans; // Return the maximum width found
    }
}
