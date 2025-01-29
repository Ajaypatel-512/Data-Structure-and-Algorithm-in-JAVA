package Graph;

import java.util.*;

public class RedundantConnection {
    /**
     * 684. Redundant Connection
     * In this problem, a tree is an undirected graph that is connected and has no cycles.
     *
     * You are given a graph that started as a tree with n nodes labeled from 1 to n, with one additional edge added. The added edge has two different vertices chosen from 1 to n, and was not an edge that already existed. The graph is represented as an array edges of length n where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the graph.
     *
     * Return an edge that can be removed so that the resulting graph is a tree of n nodes. If there are multiple answers, return the answer that occurs last in the input.
     *
     *
     *
     * Example 1:
     *
     *
     * Input: edges = [[1,2],[1,3],[2,3]]
     * Output: [2,3]
     * Example 2:
     *
     *
     * Input: edges = [[1,2],[2,3],[3,4],[1,4],[1,5]]
     * Output: [1,4]
     *
     *
     * Constraints:
     *
     * n == edges.length
     * 3 <= n <= 1000
     * edges[i].length == 2
     * 1 <= ai < bi <= edges.length
     * ai != bi
     * There are no repeated edges.
     * The given graph is connected.
     * */
    public static void main(String[] args) {
        int[][] edges = {{1,2},{1,3},{2,3}};
        System.out.println(Arrays.toString(findRedundantConnection(edges)));
    }

    //Solution 1 : Using DFS
    //Time Complexity: O(n^2)
    //Space Complexity: O(n)
    public static int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        Map<Integer, List<Integer>> adj = new HashMap<>();

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];

            if (adj.containsKey(u) && adj.containsKey(v)) {
                boolean[] visited = new boolean[n + 1];
                if (dfs(adj, u, v, visited)) {
                    return edge;
                }
            }

            adj.putIfAbsent(u, new ArrayList<>());
            adj.putIfAbsent(v, new ArrayList<>());
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        return new int[0];
    }

    public static boolean dfs(Map<Integer, List<Integer>> adj, int u, int v, boolean[] visited) {
        visited[u] = true;
        if (u == v) {
            return true;
        }
        for (int ngbr : adj.get(u)) {
            if (visited[ngbr]) continue;
            if (dfs(adj, ngbr, v, visited)) {
                return true;
            }
        }
        return false;
    }

}
