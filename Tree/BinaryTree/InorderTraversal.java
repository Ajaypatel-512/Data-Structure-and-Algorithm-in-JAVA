package Tree.BinaryTree;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {
    /**
     * Given the root of a binary tree, return the inorder traversal of its nodes' values.
     *
     * Example 1:
     *
     * Input: root = [1,null,2,3]
     *
     * Output: [1,3,2]
     *
     * Explanation:
     *
     * Example 2:
     *
     * Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]
     *
     * Output: [4,2,6,5,7,1,3,9,8]
     *
     * Explanation:
     *
     * Example 3:
     *
     * Input: root = []
     *
     * Output: []
     *
     * Example 4:
     *
     * Input: root = [1]
     *
     * Output: [1]
     *
     *
     *
     * Constraints:
     *
     * The number of nodes in the tree is in the range [0, 100].
     * -100 <= Node.val <= 100
     *
     *
     * Follow up: Recursive solution is trivial, could you do it iteratively?
     * */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.left = new TreeNode(4);
        root2.left.right = new TreeNode(5);
        root2.right.right = new TreeNode(8);
        root2.left.left.left = new TreeNode(6);
        root2.left.left.right = new TreeNode(7);
        root2.right.right.left = new TreeNode(9);

        List<Integer> result = inorderTraversal(root2);
        System.out.println(result); // Output: [1, 3, 2]
    }

    //Solution 1: Recursive approach
    // Time Complexity: O(n), where n is the number of nodes in the tree.
    // Space Complexity: O(n) for the recursion stack in the worst case (skewed tree).
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        treeNode(root, result);
        return result;
    }

    private static void treeNode(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        treeNode(root.left, result);
        result.add(root.val);
        treeNode(root.right, result);
    }

    //Solution 2: Iterative approach using stack
    // Time Complexity: O(n), where n is the number of nodes in the tree.
    // Space Complexity: O(n) for the stack in the worst case (skewed tree).
    public static List<Integer> inorderTraversalIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {

            // Traverse to the leftmost node
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // Process the node
            current = stack.pop();
            result.add(current.val);

            // Move to the right node
            current = current.right;
        }

        return result;
    }
}
