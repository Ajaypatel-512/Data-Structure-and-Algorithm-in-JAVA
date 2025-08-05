package Tree.BinaryTree.Traversal;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PrerInPostOrderTraversalInSingleInstance {

    public static class Pair {
        TreeNode node;
        int state;

        public Pair(TreeNode node, int state) {
            this.node = node;
            this.state = state;
        }
    }

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

        // Call the method to get preorder, inorder, and postorder traversals
        List<Integer> preOrder = new ArrayList<>();
        List<Integer> inOrder = new ArrayList<>();
        List<Integer> postOrder = new ArrayList<>();
        preorderInorderPostorderTraversal(root2, preOrder, inOrder, postOrder);
        System.out.println("Preorder: " + preOrder); // Output: [1, 2, 4, 6, 7, 5, 3, 8, 9]
        System.out.println("Inorder: " + inOrder);   // Output: [6, 4, 7, 2, 5, 1, 3, 8, 9]
        System.out.println("Postorder: " + postOrder); // Output: [6, 4, 7, 2, 5, 9, 8, 3, 1]

    }

    // Solution: Using Iteration with Single Stack
    // Time Complexity: O(3n), where n is the number of nodes in the tree.
    // Space Complexity: O(3h), where h is the height of the tree due to the stack.
    private static void preorderInorderPostorderTraversal(TreeNode root, List<Integer> preOrder, List<Integer> inOrder, List<Integer> postOrder) {
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, 1));
        if (root == null) return;

        while (!stack.isEmpty()) {
            Pair it = stack.pop();

            // this is part of pre order
            // increment 1 to 2
            // push the left side of the tree
            if (it.state == 1) {
                preOrder.add(it.node.val); // Preorder: Visit the root
                it.state++;
                stack.push(it); // Push back to stack with incremented state
                if(it.node.left != null) {
                    stack.push(new Pair(it.node.left, 1)); // Push left child with state 1
                }
            }

            // this is part of in order
            // increment 2 to 3
            // push the right side of the tree
            else if(it.state == 2){
                inOrder.add(it.node.val); // Inorder: Visit the root
                it.state++;
                stack.push(it); // Push back to stack with incremented state
                if (it.node.right != null) {
                    stack.push(new Pair(it.node.right, 1)); // Push right child with state 1
                }
            }

            // this is part of post order
            // do not push the node back to the stack
            else {
                postOrder.add((it.node.val)); // Postorder: Visit the root
            }
        }
    }
}
