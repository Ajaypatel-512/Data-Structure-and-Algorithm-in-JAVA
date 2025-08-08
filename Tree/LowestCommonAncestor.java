package Tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LowestCommonAncestor {
    /**
     * 236. Lowest Common Ancestor of a Binary Tree
     * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
     *
     * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
     *
     * Example 1:
     *
     * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
     * Output: 3
     * Explanation: The LCA of nodes 5 and 1 is 3.
     * Example 2:
     *
     * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
     * Output: 5
     * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
     * Example 3:
     *
     * Input: root = [1,2], p = 1, q = 2
     * Output: 1
     *
     * Constraints:
     *
     * The number of nodes in the tree is in the range [2, 105].
     * -109 <= Node.val <= 109
     * All Node.val are unique.
     * p != q
     * p and q will exist in the tree.
     * */
    public static void main(String[] args) {
// Example usage
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        TreeNode p = root.left; // Node 5
        TreeNode q = root.right; // Node 1

        System.out.println(lowestCommonAncestor(root, p, q).val); // Output: 3
    }

    //Solution 1: Using Path Traversal
    // Time Complexity: O(n) where n is the number of nodes in the tree
    // Space Complexity: O(h) where h is the height of the tree (due to recursion stack and path storage) and 2 list to store paths
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> node1Path = new ArrayList<>();
        List<TreeNode> node2Path = new ArrayList<>();

        getPath(root, p, node1Path);
        getPath(root, q, node2Path);

        int i = 0;
        TreeNode lca = null;
        while (i < node1Path.size() && i < node2Path.size()) {
            if (node1Path.get(i) == node2Path.get(i)) {
                lca = node1Path.get(i);
            } else {
                break;
            }
            i++;
        }

        return lca;
    }

    private static boolean getPath(TreeNode root, TreeNode target, List<TreeNode> path) {
        if (root == null) return false;
        path.add(root);
        if (root == target) return true;
        if (getPath(root.left, target, path) || getPath(root.right, target, path)) {
            return true;
        }
        path.remove(path.size() - 1); // backtrack
        return false;
    }

    //Solution 2: Using Set to store ancestors
    // Time Complexity: O(n) where n is the number of nodes in the tree
    // Space Complexity: O(h) where h is the height of the tree (due to recursion stack and set storage)
    public static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);

        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return root; // If both left and right are not null, then root is the LCA
        }
    }

}
