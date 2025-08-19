package Tree.BinarySearchTree;

import Tree.TreeNode;

public class ConstructBinarySearchTreeFromPreorderTraversal {
    /**
     * 1008. Construct Binary Search Tree from Preorder Traversal
     * Given an array of integers preorder, which represents the preorder traversal of a BST (i.e., binary search tree), construct the tree and return its root.
     *
     * It is guaranteed that there is always possible to find a binary search tree with the given requirements for the given test cases.
     *
     * A binary search tree is a binary tree where for every node, any descendant of Node.left has a value strictly less than Node.val, and any descendant of Node.right has a value strictly greater than Node.val.
     *
     * A preorder traversal of a binary tree displays the value of the node first, then traverses Node.left, then traverses Node.right.
     *
     *
     *
     * Example 1:
     *
     *
     * Input: preorder = [8,5,1,7,10,12]
     * Output: [8,5,10,1,7,null,12]
     * Example 2:
     *
     * Input: preorder = [1,3]
     * Output: [1,null,3]
     *
     *
     * Constraints:
     *
     * 1 <= preorder.length <= 100
     * 1 <= preorder[i] <= 1000
     * All the values of preorder are unique.
     * */
    public static void main(String[] args) {
        // Example usage
        int[] preorder = {8, 5, 1, 7, 10, 12};
        TreeNode root = bstFromPreorder(preorder);
        // You can add code to print or verify the constructed tree
        System.out.println(root.val + ", " + root.left.val + ", " + root.right.val);

    }

    //Solution 1: Using a recursive approach to construct the BST from the preorder traversal.
    // Time Complexity: O(n) where n is the number of nodes in the tree
    // Space Complexity: O(n) for the recursive stack space
    public static TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder, Integer.MAX_VALUE, new int[]{0});
    }

    private static TreeNode bstFromPreorder(int[] preorder, int maxValue, int[] arr) {
        if (arr[0] == preorder.length || preorder[arr[0]] > maxValue) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[arr[0]++]);
        node.left = bstFromPreorder(preorder, node.val, arr);
        node.right = bstFromPreorder(preorder, maxValue, arr);
        return node;
    }
}
