package Tree;

import java.util.*;

public class VerticalOrderTraversalOfABinaryTree {
    /**
     * 987. Vertical Order Traversal of a Binary Tree
     * Given the root of a binary tree, calculate the vertical order traversal of the binary tree.
     *
     * For each node at position (row, col), its left and right children will be at positions (row + 1, col - 1) and (row + 1, col + 1) respectively. The root of the tree is at (0, 0).
     *
     * The vertical order traversal of a binary tree is a list of top-to-bottom orderings for each column index starting from the leftmost column and ending on the rightmost column. There may be multiple nodes in the same row and same column. In such a case, sort these nodes by their values.
     *
     * Return the vertical order traversal of the binary tree.
     *
     *
     *
     * Example 1:
     *
     *
     * Input: root = [3,9,20,null,null,15,7]
     * Output: [[9],[3,15],[20],[7]]
     * Explanation:
     * Column -1: Only node 9 is in this column.
     * Column 0: Nodes 3 and 15 are in this column in that order from top to bottom.
     * Column 1: Only node 20 is in this column.
     * Column 2: Only node 7 is in this column.
     * Example 2:
     *
     *
     * Input: root = [1,2,3,4,5,6,7]
     * Output: [[4],[2],[1,5,6],[3],[7]]
     * Explanation:
     * Column -2: Only node 4 is in this column.
     * Column -1: Only node 2 is in this column.
     * Column 0: Nodes 1, 5, and 6 are in this column.
     *           1 is at the top, so it comes first.
     *           5 and 6 are at the same position (2, 0), so we order them by their value, 5 before 6.
     * Column 1: Only node 3 is in this column.
     * Column 2: Only node 7 is in this column.
     * Example 3:
     *
     *
     * Input: root = [1,2,3,4,6,5,7]
     * Output: [[4],[2],[1,5,6],[3],[7]]
     * Explanation:
     * This case is the exact same as example 2, but with nodes 5 and 6 swapped.
     * Note that the solution remains the same since 5 and 6 are in the same location and should be ordered by their values.
     *
     *
     * Constraints:
     *
     * The number of nodes in the tree is in the range [1, 1000].
     * 0 <= Node.val <= 1000
     * */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> result = verticalTraversal(root);
        for (List<Integer> list : result) {
            System.out.println(list);
        }

    }

    static class Tuple {
        int row;
        int col;
        TreeNode node;

        public Tuple(int row, int col, TreeNode node) {
            this.row = row;
            this.col = col;
            this.node = node;
        }
    }

    //Solution 1: Using BFS and TreeMap
    // Time Complexity: O(N log N), where N is the number of nodes in the tree.
    // Space Complexity: O(N), for storing the nodes in the TreeMap and the queue.
    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Tuple> queue = new LinkedList<>();
        TreeMap<Integer, TreeMap<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();
        queue.offer(new Tuple(0, 0, root));

        while (!queue.isEmpty()){
            Tuple tuple = queue.poll();
            int x = tuple.row;
            int y = tuple.col;
            TreeNode node = tuple.node;

            if (!map.containsKey(x)) map.put(x, new TreeMap<>());
            if (!map.get(x).containsKey(y)) map.get(x).put(y, new PriorityQueue<>());
            map.get(x).get(y).offer(node.val);

            if (node.left != null) queue.offer(new Tuple(x-1, y+1, node.left));
            if (node.right != null) queue.offer(new Tuple(x+1, y+1, node.right));
        }

        List<List<Integer>> result = new ArrayList<>();
        for (TreeMap<Integer,PriorityQueue<Integer>> ys: map.values()) {
            result.add(new ArrayList<>());
            for (PriorityQueue<Integer> pq : ys.values()) {
                while (!pq.isEmpty()) {
                    result.get(result.size() - 1).add(pq.poll());
                }
            }
        }
        return result;
    }
}
