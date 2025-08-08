package Tree;

public class SymmetricTree {
    /**
     * 101. Symmetric Tree
     * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
     * Example 1:
     *
     * Input: root = [1,2,2,3,4,4,3]
     * Output: true
     * Example 2:
     *
     *
     * Input: root = [1,2,2,null,3,null,3]
     * Output: false
     *
     * Constraints:
     *
     * The number of nodes in the tree is in the range [1, 1000].
     * -100 <= Node.val <= 100
     *
     *
     * Follow up: Could you solve it both recursively and iteratively?
     * */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println(isSymmetric(root)); // Output: true
    }

    private static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    private static boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;

        return (left.val == right.val) &&
                isMirror(left.left, right.right) &&
                isMirror(left.right, right.left);
    }
}
