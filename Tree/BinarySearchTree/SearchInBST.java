package Tree.BinarySearchTree;

import Tree.TreeNode;

public class SearchInBST {
    /**
     * 700. Search in a Binary Search Tree
     * You are given the root of a binary search tree (BST) and an integer val.
     *
     * Find the node in the BST that the node's value equals val and return the subtree rooted with that node. If such a node does not exist, return null.
     *
     *
     *
     * Example 1:
     *
     *
     * Input: root = [4,2,7,1,3], val = 2
     * Output: [2,1,3]
     * Example 2:
     *
     *
     * Input: root = [4,2,7,1,3], val = 5
     * Output: []
     *
     *
     * Constraints:
     *
     * The number of nodes in the tree is in the range [1, 5000].
     * 1 <= Node.val <= 107
     * root is a binary search tree.
     * 1 <= val <= 107
     * */
    public static void main(String[] args) {
        // Example usage
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        int val = 2;
        TreeNode result = searchBST(root, val);
        System.out.println(result != null ? result.val : "null");
    }

    //Solution 1: recursive approach
    // Time Complexity: O(log n) on average, O(n) in the worst case (unbalanced tree)
    // Space Complexity: O(h) where h is the height of the tree (due to recursion stack)
    private static TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) {
            return root;
        } else if (root.val > val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }


}
