package Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumTimeTakenToBURNTheBinaryTreeFromANode {
    /**
     * Burning Tree
     * Difficulty: HardAccuracy: 53.53%Submissions: 123K+Points: 8
     * Given a binary tree and a target node, determine the minimum time required to burn the entire tree if the target node is set on fire. In one second, the fire spreads from a node to its left child, right child, and parent.
     * Note: The tree contains unique values.
     *
     * Examples :
     *
     * Input: root[] = [1, 2, 3, 4, 5, 6, 7], target = 2
     *
     * Output: 3
     * Explanation: Initially 2 is set to fire at 0 sec
     * At 1 sec: Nodes 4, 5, 1 catches fire.
     * At 2 sec: Node 3 catches fire.
     * At 3 sec: Nodes 6, 7 catches fire.
     * It takes 3s to burn the complete tree.
     * Input: root[] = [1, 2, 3, 4, 5, N, 7, 8, N, 10], target = 10
     *
     * Output: 5
     * Explanation: Initially 10 is set to fire at 0 sec
     * At 1 sec: Node 5 catches fire.
     * At 2 sec: Node 2 catches fire.
     * At 3 sec: Nodes 1 and 4 catches fire.
     * At 4 sec: Node 3 and 8 catches fire.
     * At 5 sec: Node 7 catches fire.
     * It takes 5s to burn the complete tree.
     * Constraints:
     * 1 ≤ number of nodes ≤ 105
     * 1 ≤ node->data ≤ 105
     * */
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        root.left = new BinaryTreeNode<>(2);
        root.right = new BinaryTreeNode<>(3);
        root.left.left = new BinaryTreeNode<>(4);
        root.left.right = new BinaryTreeNode<>(5);
        root.right.right = new BinaryTreeNode<>(6);

        int startNode = 2; // Burning starts from node 2
        int time = timeToBurnTree(root, startNode);
        System.out.println("Minimum time to burn the tree: " + time);
    }

    static class BinaryTreeNode<T> {
        T data;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;

        BinaryTreeNode(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

        // Step 1: Map each node to its parent & find target node
        private static BinaryTreeNode<Integer> bfsToMapParents(BinaryTreeNode<Integer> root,
                                                               HashMap<BinaryTreeNode<Integer>, BinaryTreeNode<Integer>> mpp, int start) {
            Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
            q.offer(root);
            BinaryTreeNode<Integer> res = new BinaryTreeNode<>(-1);

            while (!q.isEmpty()) {
                BinaryTreeNode<Integer> node = q.poll();
                if (node.data == start)
                    res = node;
                if (node.left != null) {
                    mpp.put(node.left, node);
                    q.offer(node.left);
                }
                if (node.right != null) {
                    mpp.put(node.right, node);
                    q.offer(node.right);
                }
            }
            return res;
        }

        // Step 2: Find max distance from target using BFS (burning simulation)
        private static int findMaxDistance(HashMap<BinaryTreeNode<Integer>, BinaryTreeNode<Integer>> mpp,
                                           BinaryTreeNode<Integer> target) {
            Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
            q.offer(target);
            HashMap<BinaryTreeNode<Integer>, Integer> vis = new HashMap<>();
            vis.put(target, 1);
            int maxi = 0;

            while (!q.isEmpty()) {
                int sz = q.size();
                int fl = 0;

                for (int i = 0; i < sz; i++) {
                    BinaryTreeNode<Integer> node = q.poll();

                    if (node.left != null && vis.get(node.left) == null) {
                        fl = 1;
                        vis.put(node.left, 1);
                        q.offer(node.left);
                    }

                    if (node.right != null && vis.get(node.right) == null) {
                        fl = 1;
                        vis.put(node.right, 1);
                        q.offer(node.right);
                    }

                    if (mpp.get(node) != null && vis.get(mpp.get(node)) == null) {
                        fl = 1;
                        vis.put(mpp.get(node), 1);
                        q.offer(mpp.get(node));
                    }
                }
                if (fl == 1)
                    maxi++;
            }
            return maxi;
        }

        // Step 3: Main function to find burn time
        public static int timeToBurnTree(BinaryTreeNode<Integer> root, int start) {
            HashMap<BinaryTreeNode<Integer>, BinaryTreeNode<Integer>> mpp = new HashMap<>();
            BinaryTreeNode<Integer> target = bfsToMapParents(root, mpp, start);
            return findMaxDistance(mpp, target);
        }
}
