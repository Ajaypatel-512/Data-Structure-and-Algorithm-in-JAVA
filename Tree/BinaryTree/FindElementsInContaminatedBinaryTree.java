package Tree.BinaryTree;

import Tree.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class FindElementsInContaminatedBinaryTree {
    /**
     * 1261. Find Elements in a Contaminated Binary Tree
     * Given a binary tree with the following rules:
     *
     * root.val == 0
     * For any treeNode:
     * If treeNode.val has a value x and treeNode.left != null, then treeNode.left.val == 2 * x + 1
     * If treeNode.val has a value x and treeNode.right != null, then treeNode.right.val == 2 * x + 2
     * Now the binary tree is contaminated, which means all treeNode.val have been changed to -1.
     *
     * Implement the FindElements class:
     *
     * FindElements(TreeNode* root) Initializes the object with a contaminated binary tree and recovers it.
     * bool find(int target) Returns true if the target value exists in the recovered binary tree.
     *
     *
     * Example 1:
     *
     *
     * Input
     * ["FindElements","find","find"]
     * [[[-1,null,-1]],[1],[2]]
     * Output
     * [null,false,true]
     * Explanation
     * FindElements findElements = new FindElements([-1,null,-1]);
     * findElements.find(1); // return False
     * findElements.find(2); // return True
     * Example 2:
     *
     *
     * Input
     * ["FindElements","find","find","find"]
     * [[[-1,-1,-1,-1,-1]],[1],[3],[5]]
     * Output
     * [null,true,true,false]
     * Explanation
     * FindElements findElements = new FindElements([-1,-1,-1,-1,-1]);
     * findElements.find(1); // return True
     * findElements.find(3); // return True
     * findElements.find(5); // return False
     * Example 3:
     *
     *
     * Input
     * ["FindElements","find","find","find","find"]
     * [[[-1,null,-1,-1,null,-1]],[2],[3],[4],[5]]
     * Output
     * [null,true,false,false,true]
     * Explanation
     * FindElements findElements = new FindElements([-1,null,-1,-1,null,-1]);
     * findElements.find(2); // return True
     * findElements.find(3); // return False
     * findElements.find(4); // return False
     * findElements.find(5); // return True
     *
     *
     * Constraints:
     *
     * TreeNode.val == -1
     * The height of the binary tree is less than or equal to 20
     * The total number of nodes is between [1, 104]
     * Total calls of find() is between [1, 104]
     * 0 <= target <= 106
     * */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(-1);
        root.right = new TreeNode(-1);
        root.right.right = new TreeNode(-1);
        root.right.right.right = new TreeNode(-1);
        root.right.right.right.right = new TreeNode(-1);
        FindElements(root);
        System.out.println(find(1));
    }

    //Solution 1 : Using DFS
    //Time Complexity : O(n)
    //Space Complexity : O(n)
    static Set<Integer> set = new HashSet<>();
    static void dfs(TreeNode root, int x){
        if (root == null )
            return;

        root.val = x;
        set.add(x);
        dfs(root.left, 2*x+1);
        dfs(root.right, 2*x+2);
    }
    public static void FindElements(TreeNode root) {
        set.clear();
        dfs(root, 0);
    }

    public static boolean find(int target) {
        return set.contains(target);
    }
}
