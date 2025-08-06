package Tree;

public class CheckIfTreeIsBalancedBinaryTree {
    /**
     * 110. Balanced Binary Tree
     * Easy
     * Topics
     * premium lock icon
     * Companies
     * Given a binary tree, determine if it is height-balanced.
     * Example 1:
     *
     *
     * Input: root = [3,9,20,null,null,15,7]
     * Output: true
     * Example 2:
     *
     *
     * Input: root = [1,2,2,3,3,null,null,4,4]
     * Output: false
     * Example 3:
     *
     * Input: root = []
     * Output: true
     *
     *
     * Constraints:
     *
     * The number of nodes in the tree is in the range [0, 5000].
     * -104 <= Node.val <= 104
     * */
    public static void main(String[] args) {
        // Example usage
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(isBalanced(root)); // Output: true
    }

    //Solution 1: Using DFS recursion to check balance
    //Time Complexity: O(n), where n is the number of nodes in the tree.
    //Space Complexity: O(h), where h is the height of the tree due to recursion stack.
    public static boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    private static int checkHeight(TreeNode root) {
        if (root == null) return 0;
        int lh = checkHeight(root.left);
        int rh = checkHeight(root.right);
        if (lh == -1 || rh == -1 || Math.abs(lh - rh) > 1) {
            return -1; // Not balanced
        }
        return Math.max(lh, rh) + 1; // Height of the current node
    }
}
