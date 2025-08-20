package Tree.BinarySearchTree;

import Tree.TreeNode;
import com.sun.source.tree.Tree;

public class LargestBSTInABinaryTree {
    /**
     * Given a Binary Tree, the task is to return the size of the largest subtree which is also a Binary Search Tree (BST).
     * If the complete Binary Tree is BST, then return the size of the whole tree.
     *
     * */
    public static void main(String[] args) {
        // Example usage
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.right.right = new TreeNode(20);
        root.right.left = new TreeNode(6);

        LargestBSTInABinaryTree largestBST = new LargestBSTInABinaryTree();
        int result = largestBST.largestBst(root);
        System.out.println("Size of the largest BST subtree: " + result); // Should print 3
    }


    //Solution 1: Using Recursion
    // Time Complexity: O(n^2) in the worst case (when the tree is skewed, checking each node against all others)
    // Space Complexity: O(h) where h is the height of the tree (due to recursion stack)
    static boolean isValidBst(TreeNode root, int minValue, int maxValue) {
        if (root == null) {
            return true;
        }
        if (root.val >= maxValue || root.val <= minValue) {
            return false;
        }
        return isValidBst(root.left, minValue, root.val) &&
                isValidBst(root.right, root.val, maxValue);
    }

    // Returns size of a tree
    static int size(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + size(root.left) + size(root.right);
    }

    // Finds the size of the largest BST
    static int largestBst(TreeNode root) {
        // If tree is empty
        if (root == null) {
            return 0;
        }
        // If whole tree is BST
        if (isValidBst
                (root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
            return size(root);
        }
        // If whole tree is not BST
        return Math.max(largestBst(root.left), largestBst(root.right));
    }

}
