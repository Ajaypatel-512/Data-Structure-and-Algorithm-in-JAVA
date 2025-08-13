package Tree;

import java.util.Stack;

public class flattenBinaryTreeToLinkedList {
    /**
     * 114. Flatten Binary Tree to Linked List
     * Given the root of a binary tree, flatten the tree into a "linked list":
     *
     * The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
     * The "linked list" should be in the same order as a pre-order traversal of the binary tree.
     *
     *
     * Example 1:
     *
     *
     * Input: root = [1,2,5,3,4,null,6]
     * Output: [1,null,2,null,3,null,4,null,5,null,6]
     * Example 2:
     *
     * Input: root = []
     * Output: []
     * Example 3:
     *
     * Input: root = [0]
     * Output: [0]
     *
     *
     * Constraints:
     *
     * The number of nodes in the tree is in the range [0, 2000].
     * -100 <= Node.val <= 100
     *
     *
     * Follow up: Can you flatten the tree in-place (with O(1) extra space)?
     * */
    public static void main(String[] args) {
        // Example usage
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        flatten(root);

        // Print the flattened tree
        TreeNode current = root;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.right;
        }
    }

    //Solution 1: Recursive Approach
    //Time Complexity: O(n), where n is the number of nodes in the tree.
    //Space Complexity: O(h), where h is the height of the tree due to recursion stack.
    static TreeNode prev = null;
    public static void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }

    //Solution 2: Iterative Approach
    // Time Complexity: O(n), where n is the number of nodes in the tree.
    // Space Complexity: O(h), where h is the height of the tree due to the stack used for traversal.
    static Stack<TreeNode> stack = new Stack<>();
    public static void flattenIterative(TreeNode root) {
        if (root == null) return;
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();

            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
            if (!stack.isEmpty()) {
                current.right = stack.peek();
            }
            current.left = null;
        }
    }
}
