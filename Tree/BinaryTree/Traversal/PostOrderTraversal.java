package Tree.BinaryTree.Traversal;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversal {
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

        List<Integer> result = postOrderTraversalIterativeOneStack(root2);
        System.out.println(result); // Output: [1, 3, 2]
    }

    // Solution 1: Using Recursion
    // Time Complexity: O(n), where n is the number of nodes in the tree.
    // Space Complexity: O(h), where h is the height of the tree due to recursion stack.
    private static List<Integer> postorderTraversal(TreeNode root2) {
        List<Integer> result = new ArrayList<>();
        postorderHelper(root2, result);
        return result;
    }

    private static void postorderHelper(TreeNode root2, List<Integer> result) {
        if (root2 == null) return;

        postorderHelper(root2.left, result);  // Traverse left subtree
        postorderHelper(root2.right, result); // Traverse right subtree
        result.add(root2.val); // Visit the root
    }

    // Solution 2: Using Iteration with 2 Stack
    // Time Complexity: O(n), where n is the number of nodes in the tree.
    // Space Complexity: O(2n), where n is the number of nodes in the tree due to the use of two stacks.
    private static List<Integer> postOrderTraversalIterative(TreeNode root) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        List<Integer> result = new ArrayList<>();

        if (root == null) return result;
        stack1.push(root);

        while (!stack1.isEmpty()) {
            root = stack1.pop();
            stack2.push(root); // Push the node to stack2 after popping from stack1

            if(root.left != null) stack1.push(root.left);
            if(root.right != null) stack1.push(root.right);
        }

        while (!stack2.isEmpty()) result.add(stack2.pop().val);
        return result;
    }

    // Solution 3: Using Iteration with 1 Stack
    // Time Complexity: O(n), where n is the number of nodes in the tree.
    // Space Complexity: O(2n), where h is the height of the tree due to the stack.
    private static List<Integer> postOrderTraversalIterativeOneStack(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        if (current == null) return result;

        while (current != null || !stack.isEmpty()) {
            if(current != null) {
                stack.push(current);
                current = current.left; // Go to the leftmost node
            } else {
                TreeNode temp = stack.peek().right;
                if (temp == null) {
                    temp = stack.pop();
                    result.add(temp.val); // Visit the node if it has no right child
                    while (!stack.isEmpty() && temp == stack.peek().right) {
                        temp = stack.pop();
                        result.add(temp.val); // Visit the node if it has no right child
                    }
                } else {
                    current = temp; // Move to the right child
                }
            }
        }
        return result;
    }
}
