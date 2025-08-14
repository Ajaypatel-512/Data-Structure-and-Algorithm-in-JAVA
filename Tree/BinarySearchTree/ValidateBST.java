package Tree.BinarySearchTree;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class ValidateBST {
    /**
     * 98. Validate Binary Search Tree
     * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
     *
     * A valid BST is defined as follows:
     *
     * The left subtree of a node contains only nodes with keys strictly less than the node's key.
     * The right subtree of a node contains only nodes with keys strictly greater than the node's key.
     * Both the left and right subtrees must also be binary search trees.
     *
     *
     * Example 1:
     *
     *
     * Input: root = [2,1,3]
     * Output: true
     * Example 2:
     *
     *
     * Input: root = [5,1,4,null,null,3,6]
     * Output: false
     * Explanation: The root node's value is 5 but its right child's value is 4.
     *
     *
     * Constraints:
     *
     * The number of nodes in the tree is in the range [1, 104].
     * -231 <= Node.val <= 231 - 1
     * */
    public static void main(String[] args) {
        // Example usage
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        
        System.out.println(isValidBST(root)); // Output: true
    }

    //Solution: In-order traversal of a BST should yield a sorted list of values.
    // Time Complexity: O(n) + O(n) where n is the number of nodes in the tree
    // Space Complexity: O(n) for storing the in-order traversal values in a list
    private static boolean isValidBST(TreeNode root) {
        List<Integer> inOrderList = new ArrayList<>();
        inOrderTraversal(root, inOrderList);
        for (int i = 1; i < inOrderList.size(); i++) {
            if (inOrderList.get(i) <= inOrderList.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    private static void inOrderTraversal(TreeNode root, List<Integer> inOrderList) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left, inOrderList);
        inOrderList.add(root.val);
        inOrderTraversal(root.right, inOrderList);
    }
}
