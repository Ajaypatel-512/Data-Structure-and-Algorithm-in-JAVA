package Tree.BinarySearchTree;

import Tree.TreeNode;

public class LowestCommonAncestorBST {
    /**
     * 235. Lowest Common Ancestor of a Binary Search Tree
     * Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.
     *
     * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
     * Example 1:
     *
     *
     * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
     * Output: 6
     * Explanation: The LCA of nodes 2 and 8 is 6.
     * Example 2:
     *
     *
     * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
     * Output: 2
     * Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
     * Example 3:
     *
     * Input: root = [2,1], p = 2, q = 1
     * Output: 2
     *
     *
     * Constraints:
     *
     * The number of nodes in the tree is in the range [2, 105].
     * -109 <= Node.val <= 109
     * All Node.val are unique.
     * p != q
     * p and q will exist in the BST.
     * */
    public static void main(String[] args) {
        // Example usage
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);

        TreeNode p = root.left; // Node with value 2
        TreeNode q = root.right; // Node with value 8

        System.out.println(lowestCommonAncestor(root, p, q).val); // Output: 6
    }

    //Solution 1: Using the properties of BST, we can find the LCA by comparing the values of p and q with the current node's value.
    // Time Complexity: O(h) where h is the height of the tree
    // Space Complexity: O(1) for the recursive stack space
    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        int curr = root.val;
        if (curr < p.val && curr < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        if (curr > p.val && curr > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        return root; // This is the LCA
    }

    //Solution 2: Iterative approach
    // Time Complexity: O(h) where h is the height of the tree
    // Space Complexity: O(1) for the iterative approach
    private static TreeNode lowestCommonAncestorIterative(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            int curr = root.val;
            if (curr < p.val && curr < q.val) {
                root = root.right;
            } else if (curr > p.val && curr > q.val) {
                root = root.left;
            } else {
                return root; // This is the LCA
            }
        }
        return null; // If no LCA found
    }


}
