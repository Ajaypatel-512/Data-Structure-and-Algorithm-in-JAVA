package Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindLargestValueInEachTreeRow {
    /**
     * 515. Find Largest Value in Each Tree Row
     * Given the root of a binary tree, return an array of the largest value in each row of the tree (0-indexed).
     *
     * Example 1:
     * Input: root = [1,3,2,5,3,null,9]
     * Output: [1,3,9]
     * Example 2:
     *
     * Input: root = [1,2,3]
     * Output: [1,3]
     *
     * Constraints:
     *
     * The number of nodes in the tree will be in the range [0, 104].
     * -231 <= Node.val <= 231 - 1
     * */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);

        System.out.println(largestValues(root));
    }

    //Solution 1 Using Level Order Traversal (BFS)
    //T.C : O(n)
    //S.C : O(n)
    public static List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> result = new LinkedList<>();
        if (root == null) return result;
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i=0; i<size; i++){
                TreeNode node = queue.poll();
                max = Math.max(max, node.val);
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }
            result.add(max);
        }
        return result;
    }
}
