package Tree;

import java.util.ArrayList;
import java.util.List;

public class RootToNodePath {
    /**
     * Print Root-to-Leaf Paths in a Binary Tree
     *  Example 1:
     * 				Input:Binary Tree: 1 2 3 4 5 -1 -1 -1 -1, Node: 7
     *
     * 				Output:[1, 2, 5, 7]
     * 				Explanation:
     *
     * 				Example 2:
     * 				Input:Binary Tree: [1, 2, 3, -1, -1, 4, 5, -1, -1, 6]
     *
     * 				Output : [1, 3, 5, 6]
     * 				Explanation:
     *
     * */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        int target = 7;
        System.out.println("Root to Node Path: " + solve(root, target));
    }

    //Solution 1: Using In-order Traversal
    //Time Complexity: O(n)
    //Space Complexity: O(h) where h is the height of the tree
    private static boolean getPath(TreeNode root, List<Integer> result, int target) {
        if (root == null) return false;
        result.add(root.val);
        if (root.val == target) return true;
        if (getPath(root.left, result, target) || getPath(root.right, result, target)) {
            return true;
        }
        result.remove(result.size() - 1); // backtrack if not found
        return false;
    }

    private static List<Integer> solve(TreeNode root, int target){
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        getPath(root, result, target);
        return result;
    }


}
