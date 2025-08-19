package Tree.BinarySearchTree;

import Tree.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class TwoSumIVInputIsABST {
    /**
     * 653. Two Sum IV - Input is a BST
     * Given the root of a binary search tree and an integer k, return true
     * if there exist two elements in the BST such that their sum is equal to k, or false otherwise.
     *
     *
     *
     * Example 1:
     *
     *
     * Input: root = [5,3,6,2,4,null,7], k = 9
     * Output: true
     * Example 2:
     *
     *
     * Input: root = [5,3,6,2,4,null,7], k = 28
     * Output: false
     *
     *
     * Constraints:
     *
     * The number of nodes in the tree is in the range [1, 104].
     * -104 <= Node.val <= 104
     * root is guaranteed to be a valid binary search tree.
     * -105 <= k <= 105
     * */
    public static void main(String[] args) {
        // Example usage
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);

        int k = 9;
        System.out.println(findTarget(root, k)); // Output: true
    }

    // Solution: Using HashSet to store the values we have seen so far
    // Time Complexity: O(n) where n is the number of nodes in the tree
    // Space Complexity: O(n) for storing the elements in the HashSet
    static Set<Integer> set = new HashSet<>();
    static boolean helper(TreeNode node, int k) {
        if (node == null) return false;
        if (set.contains(k - node.val)) {
            return true;
        }
        set.add(node.val);
        return helper(node.left, k) || helper(node.right, k);
    }

    public static boolean findTarget(TreeNode root, int k) {
        return helper(root, k);
    }
}
