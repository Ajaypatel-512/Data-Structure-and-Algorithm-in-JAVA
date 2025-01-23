package Arrayss.Matrix;

import java.util.Arrays;

public class CountServersThatCommunicate {
    /**
     * You are given a map of a server center, represented as a m * n integer matrix grid, where 1 means that on that cell there is a server and 0 means that it is no server. Two servers are said to communicate if they are on the same row or on the same column.
     *
     * Return the number of servers that communicate with any other server.
     *
     *
     *
     * Example 1:
     *
     *
     *
     * Input: grid = [[1,0],[0,1]]
     * Output: 0
     * Explanation: No servers can communicate with others.
     * Example 2:
     *
     *
     *
     * Input: grid = [[1,0],[1,1]]
     * Output: 3
     * Explanation: All three servers can communicate with at least one other server.
     * Example 3:
     *
     *
     *
     * Input: grid = [[1,1,0,0],[0,0,1,0],[0,0,1,0],[0,0,0,1]]
     * Output: 4
     * Explanation: The two servers in the first row can communicate with each other. The two servers in the third column can communicate with each other. The server at right bottom corner can't communicate with any other server.
     *
     *
     * Constraints:
     *
     * m == grid.length
     * n == grid[i].length
     * 1 <= m <= 250
     * 1 <= n <= 250
     * grid[i][j] == 0 or 1
     * */
    public static void main(String[] args) {
        int[][] grid = {{1,0},{1,1}};
        System.out.println(countServers(grid));
    }

    //Solution 1 : Brute Force
    //Time Complexity : O(m*n*(m+n))
    //Space Complexity : O(1)
    public static int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if (grid[i][j] == 1){
                    boolean canCommunicate = false;

                    for (int col=0; col<n; col++) {
                        if (grid[i][col] == 1 && col != j) {
                            canCommunicate = true;
                            break;
                        }
                    }

                    if (!canCommunicate){
                        for (int row=0; row<m; row++) {
                            if (grid[row][j] == 1 && row != i) {
                                canCommunicate = true;
                                break;
                            }
                        }
                    }

                    if (canCommunicate) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    //Solution 1 : Better Approach
    //Time Complexity : O(m*n)
    //Space Complexity : O(m+n)
    public static int countServers2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] indexColCount = new int[n];
        int[] indexRowCount = new int[m];

        // Preprocessing
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1) {
                    indexColCount[col]++;
                    indexRowCount[row]++;
                }
            }
        }

        int resultServers = 0;
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1 && (indexColCount[col] > 1 || indexRowCount[row] > 1)) {
                    resultServers++;
                }
            }
        }
        return resultServers;
    }


    //Solution 3 : Best Approach
    //Time Complexity : O(m*n)
    //Space Complexity : O(m+n)
    public static int countServers3(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] colServerCount = new int[n];
        int[] rowAkelaServerCol = new int[m];
        Arrays.fill(rowAkelaServerCol, -1);

        int resultServers = 0;

        for (int row = 0; row < m; row++) {
            int countServersRow = 0;
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1) {
                    countServersRow++;
                    colServerCount[col]++;
                    rowAkelaServerCol[row] = col;
                }
            }

            if (countServersRow > 1) {
                resultServers += countServersRow;
                rowAkelaServerCol[row] = -1; // no akela server in this row
            }
        }

        // Check Akela servers in each row
        for (int row = 0; row < m; row++) {
            if (rowAkelaServerCol[row] != -1) {
                int col = rowAkelaServerCol[row];
                if (colServerCount[col] > 1) {
                    resultServers++;
                }
            }
        }

        return resultServers;
    }
}
