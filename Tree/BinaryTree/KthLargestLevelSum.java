package Tree.BinaryTree;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestLevelSum {
    /**
     * 2583. Kth Largest Sum in a Binary Tree
     *
     * You are given the root of a binary tree and a positive integer k.
     *
     * The level sum in the tree is the sum of the values of the nodes that are on the same level.
     *
     * Return the kth largest level sum in the tree (not necessarily distinct). If there are fewer than k levels in the tree, return -1.
     *
     * Note that two nodes are on the same level if they have the same distance from the root.
     *
     * Example 1:
     *
     *
     * Input: root = [5,8,9,2,1,3,7,4,6], k = 2
     * Output: 13
     * Explanation: The level sums are the following:
     * - Level 1: 5.
     * - Level 2: 8 + 9 = 17.
     * - Level 3: 2 + 1 + 3 + 7 = 13.
     * - Level 4: 4 + 6 = 10.
     * The 2nd largest level sum is 13.
     * Example 2:
     *
     *
     * Input: root = [1,2,null,3], k = 1
     * Output: 3
     * Explanation: The largest level sum is 3.
     * */
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode();
        int k = 2;

        System.out.println(kthLargestLevelSum(t1,k));
    }

    //Solution 1 Using BFS, PriorityQueue
    public static long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode> queue = new LinkedList<>();
        PriorityQueue<Long> pq = new PriorityQueue<>();

        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            long sum = 0l;
            for (int i=0; i<size; i++){
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }
            pq.offer(sum);
            if (pq.size() > k){
                pq.poll();
            }
        }
        if (pq.size() < k){
            return -1;
        }
        return pq.peek();
    }
}
