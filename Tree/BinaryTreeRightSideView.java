package Tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {
    /**
     * 199. Binary Tree Right Side View
     * Given the root of a binary tree, imagine yourself standing on the right side of it,
     * return the values of the nodes you can see ordered from top to bottom.
     *
     * Example 1:
     *
     * Input: root = [1,2,3,null,5,null,4]
     *
     * Output: [1,3,4]
     *
     * Explanation:
     *
     *
     *
     * Example 2:
     *
     * Input: root = [1,2,3,4,null,null,null,5]
     *
     * Output: [1,3,4,5]
     *
     * Explanation:
     *
     *
     *
     * Example 3:
     *
     * Input: root = [1,null,3]
     *
     * Output: [1,3]
     *
     * Example 4:
     *
     * Input: root = []
     *
     * Output: []
     *
     *
     *
     * Constraints:
     *
     * The number of nodes in the tree is in the range [0, 100].
     * -100 <= Node.val <= 100
     * */
    public static void main(String[] args) {
        // Example usage
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        System.out.println(rightSideView(root)); // Output: [1, 3, 4]
    }

    //Solution 1: Using DFS (Depth First Search)
    //Time Complexity: O(n), where n is the number of nodes in the tree.
    //Space Complexity: O(h), where h is the height of the tree (due to recursion stack).
    public static List<Integer> rightSideView(TreeNode root) {
        int level = 0;
        List<Integer> result = new ArrayList<>();
        rightSideViewHelper(root, level, result);
        return result;
    }

    private static void rightSideViewHelper(TreeNode root, int level, List<Integer> result) {
        if (root == null) return;
        if (level == result.size()) {
            result.add(root.val);
        }
        rightSideViewHelper(root.right, level + 1, result);
        rightSideViewHelper(root.left, level + 1, result);
    }
}
