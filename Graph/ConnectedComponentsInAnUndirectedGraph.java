package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectedComponentsInAnUndirectedGraph {
    /**
     * Connected Components in an Undirected Graph
     *
     * Given an undirected graph with V vertices numbered from 0 to V-1 and E edges,
     * represented as a 2D array edges[][], where each entry edges[i] = [u, v] denotes an edge between vertices u and v.
     *
     * Your task is to return a list of all connected components. Each connected component should be represented as a list of its vertices, with all components returned in a collection where each component is listed separately.
     *
     * Note: You can return the components in any order, driver code will print the components in sorted order.
     *
     * Examples :
     *
     * Input: V = 5, edges[][] = [[0, 1], [2, 1], [3, 4]]
     * Output: [[0, 1, 2], [3, 4]]
     * Explanation:
     *
     * Input: V = 7, edges[][] = [[0, 1], [6, 0], [2, 4], [2, 3], [3, 4]]
     * Output: [[0, 1, 6], [2, 3, 4], [5]]
     * Explanation:
     *
     * Constraints:
     * 1 ≤ V ≤ 105
     * 1 ≤ edges.size() ≤ 105
     * 0 <= edges[i][0], edges[i][1] < V
     * */
    public static void main(String[] args) {
        // Example usage
        int[][] edges = {{0, 1}, {2, 1}, {3, 4}};
        System.out.println(findConnectedComponents(edges)); // Output: [[0, 1, 2], [3, 4]]
    }

    public static class Pair{
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    //Solution 1: Using BFS to find connected components
    //Time Complexity: O(n^2) for the adjacency matrix representation of the graph, where n is the number of vertices.
    //Space Complexity: O(n^2) for the adjacency matrix representation of the graph.
    private static int findConnectedComponents(int[][] edges) {
        int row = edges.length;
        int col = edges[0].length;

        int[][] vis = new int[row][col];
        int count = 0;
        for (int i=0; i<row; i++){
            for (int j=0; j<col; j++){
                if (vis[i][j] == 0 && edges[i][j] == 1) {
                    count++;
                    bfs(i, j, vis, edges);
                }
            }
        }
        return count;
    }

    private static void bfs(int ro, int co, int[][] vis, int[][] grid) {
        vis[ro][co] = 1;
        Queue<Pair> queue = new LinkedList<Pair>();
        queue.add(new Pair(ro, co));
        int n = grid.length;
        int m = grid[0].length;

        while(!queue.isEmpty()){
            int row = queue.peek().first;
            int col = queue.peek().second;
            queue.remove();

            // Check all 8 possible directions (up, down, left, right, and the 4 diagonals)
            for (int delRow = -1; delRow <= 1; delRow++) {
                for (int delCol = -1; delCol <= 1; delCol++) {
                    int nRow = row + delRow;
                    int nCol = col + delCol;

                    if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && grid[nRow][nCol] == 1 && vis[nRow][nCol] == 0) {
                        vis[nRow][nCol] = 1;
                        queue.add(new Pair(nRow, nCol));
                    }
                }
            }
        }
    }
}
