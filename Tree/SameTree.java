package Tree;

public class SameTree {
    /**
     * 100. Same Tree
     * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
     *
     * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
     * Example 1:
     *
     * Input: p = [1,2,3], q = [1,2,3]
     * Output: true
     * Example 2:
     *
     * Input: p = [1,2], q = [1,null,2]
     * Output: false
     * Example 3:
     *
     * Input: p = [1,2,1], q = [1,1,2]
     * Output: false
     *
     * Constraints:
     *
     * The number of nodes in both trees is in the range [0, 100].
     * -104 <= Node.val <= 104
     * */
    public static void main(String[] args) {
        // Example usage
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);

        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);

        System.out.println(isSameTree(p, q)); // Output: true
    }

    // Solution 1: Recursive approach to check if two trees are the same
    // Time Complexity: O(n), where n is the number of nodes in the trees.
    // Space Complexity: O(h), where h is the height of the tree due to recursion stack.
    private static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null || q == null) return p==q;
        return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public boolean isSameTree2(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val != q.val) return false;
        return  isSameTree(p.left,q.left) &&
                isSameTree(p.right,q.right);
    }
}
