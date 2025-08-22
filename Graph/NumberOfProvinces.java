package Graph;

import java.util.ArrayList;

public class NumberOfProvinces {
    /**
     * 547. Number of Provinces
     * There are n cities. Some of them are connected, while some are not.
     * If city a is connected directly with city b, and city b is connected directly with city c,
     * then city a is connected indirectly with city c.
     *
     * A province is a group of directly or indirectly connected cities and no other cities outside of the group.
     *
     * You are given an n x n matrix isConnected where isConnected[i][j] = 1
     * if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.
     *
     * Return the total number of provinces.
     * Example 1:
     *
     * Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
     * Output: 2
     * Example 2:
     *
     * Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
     * Output: 3
     *
     * Constraints:
     *
     * 1 <= n <= 200
     * n == isConnected.length
     * n == isConnected[i].length
     * isConnected[i][j] is 1 or 0.
     * isConnected[i][i] == 1
     * isConnected[i][j] == isConnected[j][i]
     * */
    public static void main(String[] args) {
        int[][] isConnected = {
            {1, 1, 0},
            {1, 1, 0},
            {0, 0, 1}
        };
        System.out.println(findCircleNum(isConnected)); // Output: 2
    }


    //Solution 1: Using DFS to find connected components
    //Time Complexity: O(n) + O(v+2e) ~ O(n) where n is the number of cities, v is the number of vertices (cities), e is the number of edges (connections).
    //Space Complexity: O(n) + O(n) for the visited array and the boolean array used in DFS.
    private static int findCircleNum(int[][] isConnected) {
        int v = isConnected.length;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i=0; i<v; i++){
            adjList.add(new ArrayList<>());
        }

        for (int i=0; i<v; i++){
            for (int j=0; j<v; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }

        int[] vis = new int[v];
        int count = 0;
        for(int i=0; i<v; i++){
            if(vis[i] == 0){
                count++;
                dfs(i, vis, adjList);
            }
        }

        return count;
    }

    private static void dfs(int i, int[] vis, ArrayList<ArrayList<Integer>> adjList) {
        vis[i] = 1;
        for (Integer neighbor : adjList.get(i)) {
            if (vis[neighbor] == 0) {
                dfs(neighbor, vis, adjList);
            }
        }
    }

}
