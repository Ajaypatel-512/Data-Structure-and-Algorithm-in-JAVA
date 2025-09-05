package Graph;

public class SurroundedRegions {
    /**
     * 130. Surrounded Regions
     * Medium
     * Topics
     * premium lock icon
     * Companies
     * You are given an m x n matrix board containing letters 'X' and 'O', capture regions that are surrounded:
     *
     * Connect: A cell is connected to adjacent cells horizontally or vertically.
     * Region: To form a region connect every 'O' cell.
     * Surround: The region is surrounded with 'X' cells if you can connect the region with 'X' cells and none of the region cells are on the edge of the board.
     * To capture a surrounded region, replace all 'O's with 'X's in-place within the original board. You do not need to return anything.
     *
     *
     *
     * Example 1:
     *
     * Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
     *
     * Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
     *
     * Explanation:
     *
     *
     * In the above diagram, the bottom region is not captured because it is on the edge of the board and cannot be surrounded.
     *
     * Example 2:
     *
     * Input: board = [["X"]]
     *
     * Output: [["X"]]
     *
     *
     *
     * Constraints:
     *
     * m == board.length
     * n == board[i].length
     * 1 <= m, n <= 200
     * board[i][j] is 'X' or 'O'.
     * */
    public static void main(String[] args) {
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        solve(board);
        for (char[] row : board) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    //Solution 1: DFS
    //Time complexity: O(n*m) + O(n*m) ~ O(n*m) where n is the number of rows and m is the number of columns in the board.
    //Space complexity: O(n*m) + O(n*m) ~ O(n*m) where n is the number of rows and m is the number of columns in the board.
    public static void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        // step 1: create a visited array
        int vis[][] = new int[n][m];
        int delrow[] = {-1, 0, 1, 0};
        int delCol[] = {0, 1, 0, -1};

        // step 2: traverse first row and last row
        for (int j = 0; j < m; j++) {

            // first row
            if (vis[0][j] == 0 && board[0][j] == 'O') {
                dfs(0, j, vis, board, delrow, delCol);
            }

            // last row
            if (vis[n - 1][j] == 0 && board[n - 1][j] == 'O') {
                dfs(n - 1, j, vis, board, delrow, delCol);
            }
        }

        // step 3: traverse first column and last column
        for (int i = 0; i < n; i++) {

            // first column
            if (vis[i][0] == 0 && board[i][0] == 'O') {
                dfs(i, 0, vis, board, delrow, delCol);
            }

            // last column
            if (vis[i][m - 1] == 0 && board[i][m - 1] == 'O') {
                dfs(i, m - 1, vis, board, delrow, delCol);
            }
        }

        // step 4: replace all 'O' with 'X' and all 'X' with 'O'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 0 && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    static void dfs(int row, int col,int vis[][],
                    char mat[][], int delrow[], int delCol[]) {
        vis[row][col] = 1;
        int n = mat.length;
        int m = mat[0].length;

        // check for top, right, bottom, left
        for(int i = 0; i < 4; i++) {
            int nrow = row + delrow[i];
            int ncol = col + delCol[i];

            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m
                    && vis[nrow][ncol] == 0 && mat[nrow][ncol] == 'O') {
                dfs(nrow, ncol, vis, mat, delrow, delCol);
            }
        }
    }
}
