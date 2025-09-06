package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class IsGraphBipartite {
    /**
     * 785. Is Graph Bipartite?
     * Medium
     * Topics
     * premium lock icon
     * Companies
     * There is an undirected graph with n nodes, where each node is numbered between 0 and n - 1. You are given a 2D array graph, where graph[u] is an array of nodes that node u is adjacent to. More formally, for each v in graph[u], there is an undirected edge between node u and node v. The graph has the following properties:
     *
     * There are no self-edges (graph[u] does not contain u).
     * There are no parallel edges (graph[u] does not contain duplicate values).
     * If v is in graph[u], then u is in graph[v] (the graph is undirected).
     * The graph may not be connected, meaning there may be two nodes u and v such that there is no path between them.
     * A graph is bipartite if the nodes can be partitioned into two independent sets A and B such that every edge in the graph connects a node in set A and a node in set B.
     *
     * Return true if and only if it is bipartite.
     *
     *
     *
     * Example 1:
     *
     *
     * Input: graph = [[1,2,3],[0,2],[0,1,3],[0,2]]
     * Output: false
     * Explanation: There is no way to partition the nodes into two independent sets such that every edge connects a node in one and a node in the other.
     * Example 2:
     *
     *
     * Input: graph = [[1,3],[0,2],[1,3],[0,2]]
     * Output: true
     * Explanation: We can partition the nodes into two sets: {0, 2} and {1, 3}.
     *
     *
     * Constraints:
     *
     * graph.length == n
     * 1 <= n <= 100
     * 0 <= graph[u].length < n
     * 0 <= graph[u][i] <= n - 1
     * graph[u] does not contain u.
     * All the values of graph[u] are unique.
     * If graph[u] contains v, then graph[v] contains u.
     * */
    public static void main(String[] args) {
        int[][] graph = {{1,3},{0,2},{1,3},{0,2}};
        System.out.println(isBipartite(graph));
    }

    //Solution 1: BFS
    //Time Complexity: O(V + E)
    //Space Complexity: O(V)
    public static boolean check(int start, int V, int color[]) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start] = 0;

        while(!q.isEmpty()) {
            int node = q.peek();
            q.remove();

            for(int it : adj.get(node)) {
                // if the adjacent node is yet not colored
                // you will give the opposite color of the node
                if(color[it] == -1) {
                    color[it] = 1 - color[node];
                    q.add(it);
                }
                // is the adjacent guy having the same color
                // someone did color it on some other path
                else if(color[it] == color[node]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isBipartite(int[][] graph) {
        int V = graph.length;

        int color[] = new int[V];
        for(int i = 0; i < V; i++) {
            color[i] = -1;
        }

        for(int i = 0; i < V; i++) {
            if(color[i] == -1) {
                if(check(i, V, color) == false) {
                    return false;
                }
            }
        }
        return true;
    }

    //Solution 2: DFS
    //Time Complexity: O(V + E)
    //Space Complexity: O(V)
    public static boolean dfs(int node, int col, int color[], ArrayList<ArrayList<Integer>> adj) {
        color[node] = col;

        for(int it : adj.get(node)) {
            if(color[it] == -1) {
                if(dfs(it, 1 - col, color, adj) == false) {
                    return false;
                }
            }
            else if(color[it] == col) {
                return false;
            }
        }
        return true;
    }

    public static boolean isBipartiteDFS(int[][] graph) {
        int V = graph.length;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < V; i++) {
            for(int j = 0; j < graph[i].length; j++) {
                adj.get(i).add(graph[i][j]);
                adj.get(graph[i][j]).add(i);
            }
        }

        int color[] = new int[V];
        for(int i = 0; i < V; i++) {
            color[i] = -1;
        }

        for(int i = 0; i < V; i++) {
            if(color[i] == -1) {
                if(dfs(i, 0, color, adj) == false) {
                    return false;
                }
            }
        }
        return true;
    }


}
