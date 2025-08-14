package Tree.BinarySearchTree;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KthSmallestElementInBST {
    /**
     * 230. Kth Smallest Element in a BST
     * Given the root of a binary search tree, and an integer k,
     * return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
     *
     * Example 1:
     * Input: root = [3,1,4,null,2], k = 1
     * Output: 1
     * Example 2:
     *
     * Input: root = [5,3,6,2,4,null,null,1], k = 3
     * Output: 3
     *
     * Constraints:
     *
     * The number of nodes in the tree is n.
     * 1 <= k <= n <= 104
     * 0 <= Node.val <= 104
     *
     *
     * Follow up: If the BST is modified often (i.e., we can do insert and delete operations) and you need to find the kth smallest frequently, how would you optimize?
     * */
    public static void main(String[] args) {
        // Example usage
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);

        int k = 1;
        int result = kthSmallest(root, k);
        System.out.println(result); // Output: 1
    }

    //Solution 1: Naive approach
    // Time Complexity: O(n) + O(k) where n is the number of nodes in the tree
    // Space Complexity: O(n) for storing the elements in a list
    public static int kthSmallest(TreeNode root, int k) {
        List<Integer> elements = new ArrayList<>();
        inOrderTraversal(root, elements);
        return elements.get(k - 1);
    }

    private static void inOrderTraversal(TreeNode root, List<Integer> elements) {
        if (root == null) return;
        inOrderTraversal(root.left, elements);
        elements.add(root.val);
        inOrderTraversal(root.right, elements);
    }

}
