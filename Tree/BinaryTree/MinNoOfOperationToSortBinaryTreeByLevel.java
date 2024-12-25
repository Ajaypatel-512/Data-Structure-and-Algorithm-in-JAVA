package Tree;

import java.util.*;

public class MinNoOfOperationToSortBinaryTreeByLevel {
    /**
     * 2471. Minimum Number of Operations to Sort a Binary Tree by Level
     * You are given the root of a binary tree with unique values.
     *
     * In one operation, you can choose any two nodes at the same level and swap their values.
     *
     * Return the minimum number of operations needed to make the values at each level sorted in a strictly increasing order.
     *
     * The level of a node is the number of edges along the path between it and the root node.
     *
     *
     *
     * Example 1:
     *
     *
     * Input: root = [1,4,3,7,6,8,5,null,null,null,null,9,null,10]
     * Output: 3
     * Explanation:
     * - Swap 4 and 3. The 2nd level becomes [3,4].
     * - Swap 7 and 5. The 3rd level becomes [5,6,8,7].
     * - Swap 8 and 7. The 3rd level becomes [5,6,7,8].
     * We used 3 operations so return 3.
     * It can be proven that 3 is the minimum number of operations needed.
     * Example 2:
     *
     *
     * Input: root = [1,3,2,7,6,5,4]
     * Output: 3
     * Explanation:
     * - Swap 3 and 2. The 2nd level becomes [2,3].
     * - Swap 7 and 4. The 3rd level becomes [4,6,5,7].
     * - Swap 6 and 5. The 3rd level becomes [4,5,6,7].
     * We used 3 operations so return 3.
     * It can be proven that 3 is the minimum number of operations needed.
     * Example 3:
     *
     *
     * Input: root = [1,2,3,4,5,6]
     * Output: 0
     * Explanation: Each level is already sorted in increasing order so return 0.
     *
     *
     * Constraints:
     *
     * The number of nodes in the tree is in the range [1, 105].
     * 1 <= Node.val <= 105
     * All the values of the tree are unique.
     * */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(5);
        root.left.left.right = new TreeNode(9);
        root.right.right.right = new TreeNode(10);
        System.out.println(minimumOperations(root));
    }

    //Solution 1 Using BFS
    //Time Complexity: O(nlogn)
    //Space Complexity: O(n)
    public static int minimumOperations(TreeNode root){
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int operations = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();

            for (int i=0; i<size; i++){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }

            operations += calculateMinSwaps(list);
        }
        return operations;
    }

    private static int calculateMinSwaps(List<Integer> arr) {
        int n = arr.size();
        int[] sorted = arr.stream().sorted().mapToInt(i -> i).toArray();
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) indexMap.put(arr.get(i), i);

        boolean[] visited = new boolean[n];
        int swaps = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] || arr.get(i) == sorted[i]) continue;

            int cycleSize = 0;
            int x = i;
            while (!visited[x]) {
                visited[x] = true;
                x = indexMap.get(sorted[x]);
                cycleSize++;
            }
            swaps += cycleSize - 1;
        }
        return swaps;
    }

}
