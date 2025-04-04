package Tree;

public class LowestCommonAncestorOfDeepestLeaves {
    /**
     * 1123. Lowest Common Ancestor of Deepest Leaves
     * Given the root of a binary tree, return the lowest common ancestor of its deepest leaves.
     *
     * Recall that:
     *
     * The node of a binary tree is a leaf if and only if it has no children
     * The depth of the root of the tree is 0. if the depth of a node is d, the depth of each of its children is d + 1.
     * The lowest common ancestor of a set S of nodes, is the node A with the largest depth such that every node in S is in the subtree with root A.
     *
     *
     * Example 1:
     *
     *
     * Input: root = [3,5,1,6,2,0,8,null,null,7,4]
     * Output: [2,7,4]
     * Explanation: We return the node with value 2, colored in yellow in the diagram.
     * The nodes coloured in blue are the deepest leaf-nodes of the tree.
     * Note that nodes 6, 0, and 8 are also leaf nodes, but the depth of them is 2, but the depth of nodes 7 and 4 is 3.
     * Example 2:
     *
     * Input: root = [1]
     * Output: [1]
     * Explanation: The root is the deepest node in the tree, and it's the lca of itself.
     * Example 3:
     *
     * Input: root = [0,1,3,null,2]
     * Output: [2]
     * Explanation: The deepest leaf node in the tree is 2, the lca of one node is itself.
     *
     *
     * Constraints:
     *
     * The number of nodes in the tree will be in the range [1, 1000].
     * 0 <= Node.val <= 1000
     * The values of the nodes in the tree are unique.
     * */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        System.out.println(lcaDeepestLeaves(root).val); // Output: 2
    }

    //Solution 1 - DFS
    // Time Complexity: O(n)
    // Space Complexity: O(h) where h is the height of the tree
    public static TreeNode lcaDeepestLeaves(TreeNode root) {
        int h = height(root);
        TreeNode left = lca(root.left, h, 2);
        TreeNode right = lca(root.right, h, 2);
        return left == null ? (right == null ? root : right) : (right != null ? root : left);
    }
    private static TreeNode lca(TreeNode node, int h, int ch) {
        if (node == null)
            return null;

        if (h == ch) {
            return node;
        }

        TreeNode l = lca(node.left, h, ch + 1);
        TreeNode r = lca(node.right, h, ch + 1);
        if (l == null) {
            return r;
        }
        return r == null ? l : node;
    }

    private static int height(TreeNode root) {
        if (root == null)
            return 0;
        int l = height(root.left);
        int r = height(root.right);
        return Math.max(l, r) + 1;
    }

}
