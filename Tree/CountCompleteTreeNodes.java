package Tree;

public class CountCompleteTreeNodes {
    /**
     * 222. Count Complete Tree Nodes
     * Given the root of a complete binary tree, return the number of the nodes in the tree.
     *
     * According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
     *
     * Design an algorithm that runs in less than O(n) time complexity.
     *
     *
     *
     * Example 1:
     *
     *
     * Input: root = [1,2,3,4,5,6]
     * Output: 6
     * Example 2:
     *
     * Input: root = []
     * Output: 0
     * Example 3:
     *
     * Input: root = [1]
     * Output: 1
     *
     *
     * Constraints:
     *
     * The number of nodes in the tree is in the range [0, 5 * 104].
     * 0 <= Node.val <= 5 * 104
     * The tree is guaranteed to be complete.
     * */
    static int count = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        countNodes(root);
        System.out.println(count);
    }

    //Solution 1: Using DFS to count nodes
    // Time Complexity: O(n), where n is the number of nodes in the tree
    // Space Complexity: O(h), where h is the height of the tree due to recursion stack
    public static int countNodes(TreeNode root) {
        if(root == null) return count;
        count++;
        countNodes(root.left);
        countNodes(root.right);
        return count;
    }

    //Solution 2: Using left and right height to count nodes
    // Time Complexity: O(log^2 n), where n is the number of nodes in the tree
    // Space Complexity: O(h), where h is the height of the tree due to recursion stack
    public static int countNodes2(TreeNode root) {
       if (root == null) return 0;
       int left = getLeftHeight(root);
       int right = getRightHeight(root);

       if (left == right) return ((2<<(left))-1);
       else return countNodes2(root.left) + countNodes2(root.right)+1;
    }

    private static int getLeftHeight(TreeNode root) {
        int count=0;
        while (root.left != null) {
            count++;
            root = root.left;
        }
        return count;
    }

    private static int getRightHeight(TreeNode root) {
        int count=0;
        while (root.right != null) {
            count++;
            root = root.right;
        }
        return count;
    }

}
