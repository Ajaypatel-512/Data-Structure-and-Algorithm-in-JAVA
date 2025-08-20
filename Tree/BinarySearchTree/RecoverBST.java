package Tree.BinarySearchTree;

import Tree.TreeNode;

public class RecoverBST {
    /**
     * 99. Recover Binary Search Tree
     * You are given the root of a binary search tree (BST),
     * where the values of exactly two nodes of the tree were swapped by mistake. Recover the tree without changing its structure.
     *
     * Example 1:
     *
     * Input: root = [1,3,null,null,2]
     * Output: [3,1,null,null,2]
     * Explanation: 3 cannot be a left child of 1 because 3 > 1. Swapping 1 and 3 makes the BST valid.
     * Example 2:
     *
     *
     * Input: root = [3,1,4,null,null,2]
     * Output: [2,1,4,null,null,3]
     * Explanation: 2 cannot be in the right subtree of 3 because 2 < 3. Swapping 2 and 3 makes the BST valid.
     *
     *
     * Constraints:
     *
     * The number of nodes in the tree is in the range [2, 1000].
     * -231 <= Node.val <= 231 - 1
     *
     *
     * Follow up: A solution using O(n) space is pretty straight-forward. Could you devise a constant O(1) space solution?
     * */
    public static void main(String[] args) {
        // Example usage
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);

        RecoverBST recoverBST = new RecoverBST();
        recoverBST.recoverTree(root);

        // Output the recovered tree
        System.out.println(root.val); // Should print 3
        System.out.println(root.left.val); // Should print 1
        System.out.println(root.right.val); // Should print 2
    }

    //Solution 1: Using Inorder Traversal
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    static TreeNode first;
    static TreeNode second;
    static TreeNode prev;
    public static void recoverTree(TreeNode root) {
        helper(root);
        // Swap the values of the two misplaced nodes
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    public static void helper(TreeNode node) {
        if (node == null) return;

        // Traverse left subtree
        helper(node.left);

        // Detect swapped nodes
        if (prev != null && prev.val > node.val) {
            if (first == null) {
                first = prev;
            }
            second = node;
        }

        prev = node;

        // Traverse right subtree
        helper(node.right);
    }

}
