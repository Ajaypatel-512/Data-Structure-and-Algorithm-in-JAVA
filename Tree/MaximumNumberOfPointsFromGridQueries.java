package Tree;

import java.util.*;

public class MaximumNumberOfPointsFromGridQueries {
    /**
     * 2503. Maximum Number of Points From Grid Queries
     * You are given an m x n integer matrix grid and an array queries of size k.
     *
     * Find an array answer of size k such that for each integer queries[i] you start in the top left cell of the matrix and repeat the following process:
     *
     * If queries[i] is strictly greater than the value of the current cell that you are in, then you get one point if it is your first time visiting this cell, and you can move to any adjacent cell in all 4 directions: up, down, left, and right.
     * Otherwise, you do not get any points, and you end this process.
     * After the process, answer[i] is the maximum number of points you can get. Note that for each query you are allowed to visit the same cell multiple times.
     *
     * Return the resulting array answer.
     *
     *
     *
     * Example 1:
     *
     *
     * Input: grid = [[1,2,3],[2,5,7],[3,5,1]], queries = [5,6,2]
     * Output: [5,8,1]
     * Explanation: The diagrams above show which cells we visit to get points for each query.
     * Example 2:
     *
     *
     * Input: grid = [[5,2,1],[1,1,2]], queries = [3]
     * Output: [0]
     * Explanation: We can not get any points because the value of the top left cell is already greater than or equal to 3.
     *
     *
     * Constraints:
     *
     * m == grid.length
     * n == grid[i].length
     * 2 <= m, n <= 1000
     * 4 <= m * n <= 105
     * k == queries.length
     * 1 <= k <= 104
     * 1 <= grid[i][j], queries[i] <= 106
     * */
    public static void main(String[] args) {
        int[][] grid = {{1,2,3},{2,5,7},{3,5,1}};
        int[] queries = {5,6,2};
        int[] res = maxPoints(grid, queries);
        System.out.println(Arrays.toString(res));
    }

    //Solution 1 : Using BFS
    //Time Complexity : O(n*m + k*n*m) = O(k*n*m) where n is number of rows, m is number of columns and k is number of queries
    //Space Complexity : O(n*m) where n is number of rows and m is number of columns
    static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    public static int[] maxPoints(int[][] grid, int[] queries) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0]-b[0]);
        for(int i=0; i<queries.length; i++){
            pq.add(new int[]{queries[i], i});
        }
        int res = 0;
        int[] resArr = new int[queries.length];
        q.add(new int[]{0,0});
        visited[0][0] = true;
        HashMap<Integer, Integer> resMap = new HashMap<>();
        while(!pq.isEmpty()){
            int currQ = pq.peek()[0];
            int currQInd = pq.peek()[1];
            pq.remove();
            if(resMap.containsKey(currQ)){
                resArr[currQInd] = resMap.get(currQ);
                continue;
            }
            Queue<int[]> sq = new LinkedList<>();
            while(!q.isEmpty()){
                int x = q.peek()[0];
                int y = q.peek()[1];
                q.remove();

                if(grid[x][y]<currQ){
                    res++;
                    for(int k=0; k<4; k++){
                        int xn = x + dir[k][0];
                        int yn = y + dir[k][1];
                        if(xn < 0 || xn >= n || yn < 0 || yn >= m || visited[xn][yn]){
                            continue;
                        }
                        visited[xn][yn] = true;
                        q.add(new int[]{xn, yn});
                    }
                }else{
                    sq.add(new int[]{x, y});
                }
            }
            resMap.put(currQ, res);
            resArr[currQInd] = res;
            q = sq;
        }
        return resArr;
    }

}
