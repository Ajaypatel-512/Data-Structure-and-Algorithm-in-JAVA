package Tree.BinaryTree;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ReverseOddLevelsOfBinaryTree {
    /**
     * 2415. Reverse Odd Levels of Binary Tree
     * Given the root of a perfect binary tree, reverse the node values at each odd level of the tree.
     *
     * For example, suppose the node values at level 3 are [2,1,3,4,7,11,29,18], then it should become [18,29,11,7,4,3,1,2].
     * Return the root of the reversed tree.
     *
     * A binary tree is perfect if all parent nodes have two children and all leaves are on the same level.
     *
     * The level of a node is the number of edges along the path between it and the root node.
     *
     *
     *
     * Example 1:
     *
     *
     * Input: root = [2,3,5,8,13,21,34]
     * Output: [2,5,3,8,13,21,34]
     * Explanation:
     * The tree has only one odd level.
     * The nodes at level 1 are 3, 5 respectively, which are reversed and become 5, 3.
     * Example 2:
     *
     *
     * Input: root = [7,13,11]
     * Output: [7,11,13]
     * Explanation:
     * The nodes at level 1 are 13, 11, which are reversed and become 11, 13.
     * Example 3:
     *
     * Input: root = [0,1,2,0,0,0,0,1,1,1,1,2,2,2,2]
     * Output: [0,2,1,0,0,0,0,2,2,2,2,1,1,1,1]
     * Explanation:
     * The odd levels have non-zero values.
     * The nodes at level 1 were 1, 2, and are 2, 1 after the reversal.
     * The nodes at level 3 were 1, 1, 1, 1, 2, 2, 2, 2, and are 2, 2, 2, 2, 1, 1, 1, 1 after the reversal.
     *
     *
     * Constraints:
     *
     * The number of nodes in the tree is in the range [1, 214].
     * 0 <= Node.val <= 105
     * root is a perfect binary tree.
     * */
    public static void main(String[] args) {
        //2,3,5,8,13,21,34
        TreeNode root = new TreeNode();
        root.val = 2;
        root.left = new TreeNode(3);
        root.right = new TreeNode(5);

        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(13);

        root.right.left = new TreeNode(21);
        root.right.right = new TreeNode(34);

        System.out.println(reverseOddLevels(root));
    }

    //Solution 1 Using Level Order Traversal (BFS)
    //T.C : O(n + k/2)
    //S.C : O(n)
    public static TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int level = 0;
        queue.offer(root);

        while (!queue.isEmpty()){
            int size = queue.size();
            List<TreeNode> list = new ArrayList<>();
            for (int i=0; i<size; i++){
                TreeNode node = queue.poll();
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
                if (level%2!=0){
                    list.add(node);
                }
            }

            if (level%2 != 0){
                int r=0;
                int l=list.size()-1;
                while (r<l){
                    int temp = list.get(r).val;
                    list.get(r).val = list.get(l).val;
                    list.get(l).val = temp;
                    r++;
                    l--;
                }
            }
            level++;
        }
        return root;
    }
}
