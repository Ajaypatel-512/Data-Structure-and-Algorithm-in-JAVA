package Tree;

import java.util.HashMap;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    /**
     * 106. Construct Binary Tree from Inorder and Postorder Traversal
     * Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.
     *
     *
     *
     * Example 1:
     *
     *
     * Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
     * Output: [3,9,20,null,null,15,7]
     * Example 2:
     *
     * Input: inorder = [-1], postorder = [-1]
     * Output: [-1]
     *
     *
     * Constraints:
     *
     * 1 <= inorder.length <= 3000
     * postorder.length == inorder.length
     * -3000 <= inorder[i], postorder[i] <= 3000
     * inorder and postorder consist of unique values.
     * Each value of postorder also appears in inorder.
     * inorder is guaranteed to be the inorder traversal of the tree.
     * postorder is guaranteed to be the postorder traversal of the tree.
     * */
    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        TreeNode root = buildTree(inorder, postorder);
        System.out.println(root.val); // Output: 3
    }

    //Solution 1: Using HashMap to store inorder indices for quick access
    //Time Complexity: O(n), where n is the number of nodes in the tree
    //Space Complexity: O(n), for the HashMap to store inorder indices
    private static TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length) {
            return null;
        }
        HashMap<Integer,Integer> hm = new HashMap<>();
        for (int i=0; i<inorder.length; i++) {
            hm.put(inorder[i], i);
        }
        return buildTreeHelper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, hm);
    }

    private static TreeNode buildTreeHelper(int[] inorder, int inStart, int inEnd, int[] postorder, int posStart, int posEnd, HashMap<Integer, Integer> hm) {
        if (inStart > inEnd || posStart > posEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[posEnd]);
        int inRoot = hm.get(root.val);
        int numLeft = inRoot - inStart;
        root.left = buildTreeHelper(inorder, inStart, inRoot - 1, postorder, posStart, posStart + numLeft - 1, hm);
        root.right = buildTreeHelper(inorder, inRoot + 1, inEnd, postorder, posStart + numLeft, posEnd - 1, hm);
        return root;
    }
}
