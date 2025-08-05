package Tree.BinaryTree;

import Tree.TreeNode;

public class DFSTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println("Pre-order Traversal:");
        preOrderTraversal(root);

        System.out.println("\nIn-order Traversal:");
        inOrderTraversal(root);

        System.out.println("\nPost-order Traversal:");
        postOrderTraversal(root);
    }

    private static void preOrderTraversal(TreeNode root) {
        if(root == null) {
            return;
        }

        System.out.print(root.val + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);

    }

    private static void inOrderTraversal(TreeNode root) {
        if(root == null) {
            return;
        }

        inOrderTraversal(root.left);
        System.out.print(root.val + " ");
        inOrderTraversal(root.right);
    }

    private static void postOrderTraversal(TreeNode root) {
        if(root == null) {
            return;
        }

        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.val + " ");
    }


}
