package Tree.BinarySearchTree;

import Tree.TreeNode;

public class InorderPredecessorAndSuccessorInBST {
    /**
     * Inorder predecessor and successor in BST
     * You are given root node of the BST and an integer key.
     * You need to find the in-order successor and predecessor of the given key. If either predecessor or successor is not found, then set it to NULL.
     *
     * Examples :
     *
     * Input: root[] = [50, 30, 70, 20, 40, 60, 80], key = 65
     *
     * 12
     *
     * Output: 60 70
     * Explanation: In given BST the inorder predecessor of 65 is 60 and inorder successor of 65 is 70
     *
     * Input: root[] = [8, 1, 9, N, 4, N, 10, 3, N, N, N], key = 8
     *
     * Output: 4 9
     * Explanation: In the given BST the inorder predecessor of 8 is 4 and inorder successor of 8 is 9.
     * */
    public static void main(String[] args) {
        // Example usage
        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(30);
        root.right = new TreeNode(70);
        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(40);
        root.right.left = new TreeNode(60);
        root.right.right = new TreeNode(80);

        TreeNode key = new TreeNode(65);
        TreeNode result = indorderSuccessor(root, key);
    }

    //Solution 1: Using the properties of BST, we can find the inorder predecessor and successor by traversing the tree.
    // Time Complexity: O(h) where h is the height of the tree
    // Space Complexity: O(1) for the iterative approach
    private static TreeNode indorderSuccessor(TreeNode root, TreeNode key) {
        TreeNode successor = null;

        while (root != null) {
            if (root.val <= key.val) {
                root = root.right; // Move to the right subtree
            } else {
                successor = root; // Potential successor found
                root = root.left; // Move to the left subtree
            }
        }
        return successor; // Return the found successor
    }


}
