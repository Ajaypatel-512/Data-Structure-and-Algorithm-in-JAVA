package Tree.BinaryTree;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

    /**
     * Given the root of a binary tree, return all root-to-leaf paths in any order.
     *
     * A leaf is a node with no children.
     *
     * Input: root = [1,2,3,null,5]
     * Output: ["1->2->5","1->3"]
     * Example 2:
     *
     * Input: root = [1]
     * Output: ["1"]
     * */

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode();

        System.out.println(binaryTreePaths(t1));
    }
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> a1 = new ArrayList<>();
        traverse(root, a1, "");
        return a1;
    }

    private static void traverse(TreeNode root, List<String> a1, String s) {
        if(root == null){
            return;
        }

        if(root.left == null && root.right == null){
            a1.add(s + root.val);
            return;
        }

        traverse(root.left, a1, s + root.val+"->");
        traverse(root.right, a1, s + root.val+"->");
    }
}
