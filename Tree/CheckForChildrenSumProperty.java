package Tree;

public class CheckForChildrenSumProperty {
    /**
     * Check for Children Sum Property in a Binary Tree
     * Given a binary tree, the task is to check for every node, its value is equal to the sum of values of its immediate left and right child. For NULL values, consider the value to be 0. Also, leaves are considered to follow the property.
     *
     * Example:
     *
     * Input:
     *
     * Check-for-Children-Sum-Property-in-a-Binary-Tree_2
     *
     * Output: 1
     * Explanation: The above binary tree follows the Children Sum Property.
     *
     * Input:
     *
     * Check-for-Children-Sum-Property-in-a-Binary-Tree_1
     *
     * Output: 0
     * Explanation: The above binary tree doesn't follows the Children Sum Property as 5 + 2 != 8
     * */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(40);
        root.left = new TreeNode(10);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(30);
        root.right.right = new TreeNode(40);

        checkChildrenSumProperty(root);
        System.out.println("Children Sum Property is satisfied." + root);
    }

    //Soltuion 1: Recursive approach to check and adjust the Children Sum Property
    //Time Complexity: O(n), where n is the number of nodes in the tree
    //Space Complexity: O(h), where h is the height of the tree due to recursion stack
    private static void checkChildrenSumProperty(TreeNode root) {
        if (root == null) return;
        int child = 0;
        if (root.left != null) child += root.left.val;
        if (root.right != null) child += root.right.val;

        if (child >= root.val) {
            root.val = child;
        } else {
            if (root.left != null) root.left.val = root.val;
            else if (root.right != null) root.right.val = root.val;
        }
        checkChildrenSumProperty(root.left);
        checkChildrenSumProperty(root.right);

        int total = 0;
        if(root.left != null) total += root.left.val;
        if(root.right != null) total += root.right.val;
        if (root.left != null || root.right != null) root.val = total;
    }


}
