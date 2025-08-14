package Tree.BinarySearchTree;

import Tree.TreeNode;

public class FloorInBST {
    public static void main(String[] args) {
        // Example usage
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        int val = 5;
        int result = findFloor(root, val);
        System.out.println(result);
    }

    // Solution 1: iterative approach
    // Time Complexity: O(h) where h is the height of the tree
    // Space Complexity: O(1) since we are not using any extra space
    private static int findFloor(TreeNode root, int val) {
        int floor = Integer.MIN_VALUE;
        while (root != null) {
            if (root.val == val) {
                floor = root.val;
                return floor;
            }
            if (val < root.val) {
                root = root.left;
            } else {
                floor = root.val; // Update floor if current node's value is less than val
                root = root.right; // Move to the right subtree
            }
        }
        return floor;
    }
}
