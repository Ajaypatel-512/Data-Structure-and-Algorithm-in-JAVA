package Graph;

import java.util.ArrayList;
import java.util.List;

public class GraphRepresentation {
    /**
     * Input given
     * n: number of vertices/ nodes
     * m: number of edges
     * M lines
     *
     * example
     * int n = 5;
     * int m = 6;
     * int[][] edges = {1, 2}, {1, 3}, {2, 4}, {3, 4}, {4, 5}, {5, 1}};
     *
     * */

    public static void main(String[] args) {

    }

    //Solution 1: store in matrix
    //Time Complexity: O(n^2)
    //Space Complexity: O(n^2)
    public static void matrixRepresentation(int n,int m, int[][] edges) {
        //take 2 D matrix
        int[][] matrix = new int[n+1][n+1];
        //initialize all with 0
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = 0;
            }
        }
        //add 1 for each edge/intersection
        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            matrix[u][v] = 1;
            matrix[v][u] = 1; //for undirected graph
        }

        //print matrix
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    //Solution 2: store in adjacency list
    //Time Complexity: O(n + m)
    //Space Complexity: O(n + m)
    public static void adjacencyListRepresentation(int n, int m, int[][] edges) {
        //take array of lists
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }
        //add edges to the list
        // 0 - {}
        // 1 - {2, 3, 5}
        // 2 - {1, 4}
        // 3 - {1, 4}
        // 4 - {2, 3, 5}
        // 5 - {1, 4}
        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adjList.get(u).add(v);
            adjList.get(v).add(u); //for undirected graph
        }

        //print adjacency list
        for (int i = 1; i <= n; i++) {
            System.out.print("Vertex " + i + ": ");
            for (int j : adjList.get(i)) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    //Solution 3: for weighted graph use pair for storing edges with weight
    public static void weightedGraphRepresentation(int n, int m, int[][] edges, int[] weights) {
        //take array of lists
        List<List<int[]>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }
        //add edges to the list with weight
        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int weight = weights[i];
            adjList.get(u).add(new int[]{v, weight});
            adjList.get(v).add(new int[]{u, weight}); //for undirected graph
        }

        //print adjacency list with weights
        for (int i = 1; i <= n; i++) {
            System.out.print("Vertex " + i + ": ");
            for (int[] edge : adjList.get(i)) {
                System.out.print("(" + edge[0] + ", " + edge[1] + ") ");
            }
            System.out.println();
        }
    }

}
