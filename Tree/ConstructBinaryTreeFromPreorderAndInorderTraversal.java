package Tree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    /**
     * 105. Construct Binary Tree from Preorder and Inorder Traversal
     * Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.
     *
     *
     *
     * Example 1:
     *
     *
     * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
     * Output: [3,9,20,null,null,15,7]
     * Example 2:
     *
     * Input: preorder = [-1], inorder = [-1]
     * Output: [-1]
     *
     *
     * Constraints:
     *
     * 1 <= preorder.length <= 3000
     * inorder.length == preorder.length
     * -3000 <= preorder[i], inorder[i] <= 3000
     * preorder and inorder consist of unique values.
     * Each value of inorder also appears in preorder.
     * preorder is guaranteed to be the preorder traversal of the tree.
     * inorder is guaranteed to be the inorder traversal of the tree.
     * */
    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode root = buildTree(preorder, inorder);
        System.out.println(root.val); // Output: 3
    }

    //Solution 1: Using HashMap to store inorder indices for quick access
    //Time Complexity: O(n), where n is the number of nodes in the tree
    //Space Complexity: O(n), for the HashMap to store inorder indices
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        TreeNode root = buildTreeHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
        return root;
    }

    private static TreeNode buildTreeHelper(int[] preorder, int preStart, int preEnd,
                                            int[] inorder, int inStart, int intEnd,
                                            Map<Integer, Integer> map) {
        if (preStart > preEnd || inStart > intEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = map.get(root.val);
        int numLeft = inRoot - inStart;

        root.left = buildTreeHelper(preorder, preStart + 1, preStart + numLeft,
                inorder, inStart, inRoot - 1, map);
        root.right = buildTreeHelper(preorder, preStart + numLeft + 1, preEnd,
                inorder, inRoot + 1, intEnd, map);
        return root;
    }


}
