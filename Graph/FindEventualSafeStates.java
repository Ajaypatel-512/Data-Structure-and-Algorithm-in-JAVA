package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindEventualSafeStates {
    /**
     * 802. Find Eventual Safe States
     * There is a directed graph of n nodes with each node labeled from 0 to n - 1. The graph is represented by a 0-indexed 2D integer array graph where graph[i] is an integer array of nodes adjacent to node i, meaning there is an edge from node i to each node in graph[i].
     *
     * A node is a terminal node if there are no outgoing edges. A node is a safe node if every possible path starting from that node leads to a terminal node (or another safe node).
     *
     * Return an array containing all the safe nodes of the graph. The answer should be sorted in ascending order.
     *
     *
     *
     * Example 1:
     *
     * Illustration of graph
     * Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
     * Output: [2,4,5,6]
     * Explanation: The given graph is shown above.
     * Nodes 5 and 6 are terminal nodes as there are no outgoing edges from either of them.
     * Every path starting at nodes 2, 4, 5, and 6 all lead to either node 5 or 6.
     * Example 2:
     *
     * Input: graph = [[1,2,3,4],[1,2],[3,4],[0,4],[]]
     * Output: [4]
     * Explanation:
     * Only node 4 is a terminal node, and every path starting at node 4 leads to node 4.
     *
     *
     * Constraints:
     *
     * n == graph.length
     * 1 <= n <= 104
     * 0 <= graph[i].length <= n
     * 0 <= graph[i][j] <= n - 1
     * graph[i] is sorted in a strictly increasing order.
     * The graph may contain self-loops.
     * The number of edges in the graph will be in the range [1, 4 * 104].
     * */
    public static void main(String[] args) {
        int[][] graph = {{1,2},{2,3},{5},{0},{5},{},{}};
        System.out.println(eventualSafeNodes(graph));
    }

    //Solution 1 : Using DFS
    //Time Complexity : O(V+E)
    //Space Complexity : O(V)
    public  static List<Integer> eventualSafeNodes(int[][] graph) {
        HashMap<Integer,Boolean> map = new HashMap<>();
        int n = graph.length;
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(dfs(i,graph,map)){
                res.add(i);
            }
        }
        return res;
    }
    public static boolean dfs(int node, int[][] graph, HashMap<Integer,Boolean> map){
        if(map.containsKey(node)){
            return map.get(node);
        }

        map.put(node,false);
        for(int neighbour : graph[node]){
            if(!dfs(neighbour, graph, map)){
                return false;
            }
        }
        map.put(node,true);
        return true;
    }
}
