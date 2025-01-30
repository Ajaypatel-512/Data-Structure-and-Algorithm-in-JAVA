package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DivideNodesIntoTheMaximumNumberOfGroups {
    /**
     * 2493. Divide Nodes Into the Maximum Number of Groups
     * You are given a positive integer n representing the number of nodes in an undirected graph. The nodes are labeled from 1 to n.
     *
     * You are also given a 2D integer array edges, where edges[i] = [ai, bi] indicates that there is a bidirectional edge between nodes ai and bi. Notice that the given graph may be disconnected.
     *
     * Divide the nodes of the graph into m groups (1-indexed) such that:
     *
     * Each node in the graph belongs to exactly one group.
     * For every pair of nodes in the graph that are connected by an edge [ai, bi], if ai belongs to the group with index x, and bi belongs to the group with index y, then |y - x| = 1.
     * Return the maximum number of groups (i.e., maximum m) into which you can divide the nodes. Return -1 if it is impossible to group the nodes with the given conditions.
     *
     *
     *
     * Example 1:
     *
     *
     * Input: n = 6, edges = [[1,2],[1,4],[1,5],[2,6],[2,3],[4,6]]
     * Output: 4
     * Explanation: As shown in the image we:
     * - Add node 5 to the first group.
     * - Add node 1 to the second group.
     * - Add nodes 2 and 4 to the third group.
     * - Add nodes 3 and 6 to the fourth group.
     * We can see that every edge is satisfied.
     * It can be shown that that if we create a fifth group and move any node from the third or fourth group to it, at least on of the edges will not be satisfied.
     * Example 2:
     *
     * Input: n = 3, edges = [[1,2],[2,3],[3,1]]
     * Output: -1
     * Explanation: If we add node 1 to the first group, node 2 to the second group, and node 3 to the third group to satisfy the first two edges, we can see that the third edge will not be satisfied.
     * It can be shown that no grouping is possible.
     *
     *
     * Constraints:
     *
     * 1 <= n <= 500
     * 1 <= edges.length <= 104
     * edges[i].length == 2
     * 1 <= ai, bi <= n
     * ai != bi
     * There is at most one edge between any pair of vertices.
     * */
    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {{1, 2}, {1, 4}, {1, 5}, {2, 6}, {2, 3}, {4, 6}};
        System.out.println(magnificentSets(n, edges));
    }

    public static int magnificentSets(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        n++; // Increment to use 1-based indexing

        // Initialize adjacency list
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Build the graph
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        // Step 1: Check if the graph is bipartite
        if (!isBipartite(adj, n)) {
            return -1; // If not bipartite, return -1
        }

        // Step 2: Compute BFS depth for each node
        int[] bfsDepth = new int[n];
        for (int i = 1; i < n; i++) {
            bfsDepth[i] = bfsDepthFinder(adj, i);
        }

        // Step 3: DFS traversal to sum up maximum depths
        int[] visited = new int[n];
        int groupCount = 0;
        for (int i = 1; i < n; i++) {
            if (visited[i] == 0) {
                groupCount += dfs(adj, visited, bfsDepth, i);
            }
        }
        return groupCount;
    }

    // DFS to find the maximum depth in the connected component
    private static int dfs(List<List<Integer>> adj, int[] visited, int[] bfsDepth, int node) {
        visited[node] = 1;
        int maxDepth = bfsDepth[node];

        for (int neighbor : adj.get(node)) {
            if (visited[neighbor] == 0) {
                maxDepth = Math.max(maxDepth, dfs(adj, visited, bfsDepth, neighbor));
            }
        }
        return maxDepth;
    }

    // BFS to find the depth of a given node
    private static int bfsDepthFinder(List<List<Integer>> adj, int start) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, 1});
        int[] visited = new int[adj.size()];
        visited[start] = 1;
        int[] last = new int[2];

        while (!queue.isEmpty()) {
            last = queue.poll();
            for (int neighbor : adj.get(last[0])) {
                if (visited[neighbor] == 0) {
                    visited[neighbor] = 1;
                    queue.add(new int[]{neighbor, last[1] + 1});
                }
            }
        }
        return last[1];
    }

    // Check if the graph is bipartite
    private static boolean isBipartite(List<List<Integer>> adj, int n) {
        int[] color = new int[n];
        for (int i = 0; i < n; i++) {
            if (color[i] == 0 && !bfsCheck(adj, color, i)) {
                return false;
            }
        }
        return true;
    }

    // BFS helper for bipartite check
    private static boolean bfsCheck(List<List<Integer>> adj, int[] color, int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        color[node] = 1;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            int nextColor = (color[current] == 1) ? 2 : 1;

            for (int neighbor : adj.get(current)) {
                if (color[neighbor] == 0) {
                    color[neighbor] = nextColor;
                    queue.add(neighbor);
                } else if (color[neighbor] != nextColor) {
                    return false;
                }
            }
        }
        return true;
    }
    
}
