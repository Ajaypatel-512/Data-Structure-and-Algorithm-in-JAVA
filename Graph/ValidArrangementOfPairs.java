package Graph;

import java.util.*;

public class ValidArrangementOfPairs {

    /**
     * 2097. Valid Arrangement of Pairs
     * You are given a 0-indexed 2D integer array pairs where pairs[i] = [starti, endi]. An arrangement of pairs is valid if for every index i where 1 <= i < pairs.length, we have endi-1 == starti.
     *
     * Return any valid arrangement of pairs.
     *
     * Note: The inputs will be generated such that there exists a valid arrangement of pairs.
     *
     *
     *
     * Example 1:
     *
     * Input: pairs = [[5,1],[4,5],[11,9],[9,4]]
     * Output: [[11,9],[9,4],[4,5],[5,1]]
     * Explanation:
     * This is a valid arrangement since endi-1 always equals starti.
     * end0 = 9 == 9 = start1
     * end1 = 4 == 4 = start2
     * end2 = 5 == 5 = start3
     * Example 2:
     *
     * Input: pairs = [[1,3],[3,2],[2,1]]
     * Output: [[1,3],[3,2],[2,1]]
     * Explanation:
     * This is a valid arrangement since endi-1 always equals starti.
     * end0 = 3 == 3 = start1
     * end1 = 2 == 2 = start2
     * The arrangements [[2,1],[1,3],[3,2]] and [[3,2],[2,1],[1,3]] are also valid.
     * Example 3:
     *
     * Input: pairs = [[1,2],[1,3],[2,1]]
     * Output: [[1,2],[2,1],[1,3]]
     * Explanation:
     * This is a valid arrangement since endi-1 always equals starti.
     * end0 = 2 == 2 = start1
     * end1 = 1 == 1 = start2
     *
     *
     * Constraints:
     *
     * 1 <= pairs.length <= 105
     * pairs[i].length == 2
     * 0 <= starti, endi <= 109
     * starti != endi
     * No two pairs are exactly the same.
     * There exists a valid arrangement of pairs.
     *
     * */

    public static void main(String[] args) {
        int[][] arr = {{5,1},{4,5},{11,9},{9,4}};
        int[][] result = validArrangement(arr);
        for (int i=0; i<result.length; i++){
            if (i==result.length-1){
                System.out.print(Arrays.toString(result[i]));
            } else {
                System.out.print(Arrays.toString(result[i]) + "-->");
            }
        }
    }

    // Solution 1 Using DFS - Hierholzer's Algorithm to find Euler Path
    //T.C : O(V+E) for normal DFS
    //S.C : O(V+E)
    public static int[][] validArrangement(int[][] pairs) {
        Map<Integer, List<Integer>> adj = new HashMap<>();

        Map<Integer, Integer> indegree = new HashMap<>();
        Map<Integer, Integer> outdegree = new HashMap<>();

        for (int[] edge : pairs) {
            int u = edge[0];
            int v = edge[1];

            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            outdegree.put(u, outdegree.getOrDefault(u, 0) + 1);
            indegree.put(v, indegree.getOrDefault(v, 0) + 1);
        }

        int startNode = pairs[0][0];
        for (int node : adj.keySet()) {
            if (outdegree.getOrDefault(node, 0) - indegree.getOrDefault(node, 0) == 1) {
                startNode = node;
                break;
            }
        }

        List<Integer> eulerPath = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(startNode);

        while (!stack.isEmpty()) {
            int curr = stack.peek();
            if (adj.containsKey(curr) && !adj.get(curr).isEmpty()) {
                int neighbor = adj.get(curr).remove(adj.get(curr).size() - 1);
                stack.push(neighbor);
            } else {
                eulerPath.add(curr);
                stack.pop();
            }
        }

        Collections.reverse(eulerPath);
        int[][] result = new int[eulerPath.size() - 1][2];
        for (int i = 0; i < eulerPath.size() - 1; i++) {
            result[i][0] = eulerPath.get(i);
            result[i][1] = eulerPath.get(i + 1);
        }

        return result;
    }
}
