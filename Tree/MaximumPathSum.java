package Tree;

public class MaximumPathSum {
    /**
     * 124. Binary Tree Maximum Path Sum
     * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
     *
     * The path sum of a path is the sum of the node's values in the path.
     *
     * Given the root of a binary tree, return the maximum path sum of any non-empty path.
     * Example 1:
     *
     * Input: root = [1,2,3]
     * Output: 6
     * Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
     * Example 2:
     *
     * Input: root = [-10,9,20,null,null,15,7]
     * Output: 42
     * Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.
     *
     * Constraints:
     *
     * The number of nodes in the tree is in the range [1, 3 * 104].
     * -1000 <= Node.val <= 1000
     * */

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(-10);
        t1.left = new TreeNode(9);
        t1.right = new TreeNode(20);
        t1.right.left = new TreeNode(15);
        t1.right.right = new TreeNode(7);

        System.out.println(maxPathSum1(t1));
    }

    //Solution 1: Using DFS
    //Time Complexity: O(n) where n is the number of nodes in the tree.
    //Space Complexity: O(h) where h is the height of the tree due to recursion stack.
    public static int maxPathSum1(TreeNode root) {
        int[] maxSum = new int[]{Integer.MIN_VALUE};
        maxPathSum(root,maxSum);
       return maxSum[0];
    }

    public static int maxPathSum(TreeNode root,int[] maxSum) {
        if (root == null) return 0;

        int lh = Math.max(0,maxPathSum(root.left,maxSum));
        int rh = Math.max(0,maxPathSum(root.right,maxSum));
        maxSum[0] = Math.max(maxSum[0], root.val + lh+ rh);
        return root.val + Math.max(lh, rh);
    }
}
