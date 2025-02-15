package Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumNumberOfKdivisibleComponents {
    /**
     * 2872. Maximum Number of K-Divisible Components
     *
     * There is an undirected tree with n nodes labeled from 0 to n - 1. You are given the integer n and a 2D integer array edges of length n - 1, where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the tree.
     *
     * You are also given a 0-indexed integer array values of length n, where values[i] is the value associated with the ith node, and an integer k.
     *
     * A valid split of the tree is obtained by removing any set of edges, possibly empty, from the tree such that the resulting components all have values that are divisible by k, where the value of a connected component is the sum of the values of its nodes.
     *
     * Return the maximum number of components in any valid split.
     *
     *
     *
     * Example 1:
     *
     *
     * Input: n = 5, edges = [[0,2],[1,2],[1,3],[2,4]], values = [1,8,1,4,4], k = 6
     * Output: 2
     * Explanation: We remove the edge connecting node 1 with 2. The resulting split is valid because:
     * - The value of the component containing nodes 1 and 3 is values[1] + values[3] = 12.
     * - The value of the component containing nodes 0, 2, and 4 is values[0] + values[2] + values[4] = 6.
     * It can be shown that no other valid split has more than 2 connected components.
     * Example 2:
     *
     *
     * Input: n = 7, edges = [[0,1],[0,2],[1,3],[1,4],[2,5],[2,6]], values = [3,0,6,1,5,2,1], k = 3
     * Output: 3
     * Explanation: We remove the edge connecting node 0 with 2, and the edge connecting node 0 with 1. The resulting split is valid because:
     * - The value of the component containing node 0 is values[0] = 3.
     * - The value of the component containing nodes 2, 5, and 6 is values[2] + values[5] + values[6] = 9.
     * - The value of the component containing nodes 1, 3, and 4 is values[1] + values[3] + values[4] = 6.
     * It can be shown that no other valid split has more than 3 connected components.
     *
     *
     * Constraints:
     *
     * 1 <= n <= 3 * 104
     * edges.length == n - 1
     * edges[i].length == 2
     * 0 <= ai, bi < n
     * values.length == n
     * 0 <= values[i] <= 109
     * 1 <= k <= 109
     * Sum of values is divisible by k.
     * The input is generated such that edges represents a valid tree.
     * */
    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{0,2},{1,2},{1,3},{2,4}};
        int[] values = {1,8,1,4,4};
        int k = 6;
        System.out.println(maxKDivisibleComponents(n,edges,values,k));
    }

    private static int ans;
    private static List<Integer>[] g;
    private static int[] values;
    private static int k;
    public static int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        g = new List[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] e : edges) {
            int a = e[0], b = e[1];
            g[a].add(b);
            g[b].add(a);
        }
        MaximumNumberOfKdivisibleComponents.values = values;
        MaximumNumberOfKdivisibleComponents.k = k;
        dfs(0, -1);
        return ans;
    }

    private static long dfs(int i, int fa) {
        long s = values[i];
        for (int j : g[i]) {
            if (j != fa) {
                s += dfs(j, i);
            }
        }
        ans += s % k == 0 ? 1 : 0;
        return s;
    }


    public int maxKDivisibleComponents2(int n, int[][] edges, int[] values, int k) {
        // adjacency list from edges
        List<Integer>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];
            adjList[node1].add(node2);
            adjList[node2].add(node1);
        }
        int[] componentCount = new int[1];
        dfs(0, -1, adjList, values, k, componentCount);
        return componentCount[0];
    }

    long dfs(int currentNode, int parentNode, List<Integer>[] adjList,
             int[] nodeValues, int k, int[] componentCount) {
        long sum = 0;
        for (int neighborNode : adjList[currentNode]) {
            if (neighborNode != parentNode) {
                //check the sum
                sum += dfs(neighborNode,currentNode,adjList,nodeValues,k,componentCount);
            }
        }
        sum += nodeValues[currentNode];
        if (sum%k == 0) {
            componentCount[0]++;
            sum=0;
        }
        return sum;
    }

}
