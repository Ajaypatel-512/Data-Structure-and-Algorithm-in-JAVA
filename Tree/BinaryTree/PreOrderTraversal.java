package Tree.BinaryTree;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderTraversal {
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

        List<Integer> result = preorderTraversal(root2);
        System.out.println(result); // Output: [1, 3, 2]
    }

    //Solution 1: Using Recursion
    // Time Complexity: O(n), where n is the number of nodes in the tree.
    // Space Complexity: O(h), where h is the height of the tree due to recursion stack.
    private static List<Integer> preorderTraversal(TreeNode root2) {
        List<Integer> result = new ArrayList<>();
        preorderHelper(root2, result);
        return result;
    }

    private static void preorderHelper(TreeNode root2, List<Integer> result) {
        if (root2 == null) {
            return;
        }
        result.add(root2.val); // Visit the root
        preorderHelper(root2.left, result); // Traverse left subtree
        preorderHelper(root2.right, result); // Traverse right subtree
    }


    //Solution 2: Using Iteration with Stack
    // Time Complexity: O(n), where n is the number of nodes in the tree.
    // Space Complexity: O(n) in the worst case for the stack.
    private static List<Integer> preorderTraversalIterative(TreeNode root2) {
        List<Integer> result = new ArrayList<>();
        if (root2 == null) return result;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root2);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            result.add(current.val); // Visit the root

            // Push right child first so that left child is processed next
            if (current.right != null) stack.push(current.right);
            if (current.left != null) stack.push(current.left);
        }
        return result;
    }
}
