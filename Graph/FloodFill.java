package Graph;

public class FloodFill {
    /**
     * 733. Flood Fill
     * You are given an image represented by an m x n grid of integers image,
     * where image[i][j] represents the pixel value of the image. You are also given three integers sr, sc, and color.
     * Your task is to perform a flood fill on the image starting from the pixel image[sr][sc].
     *
     * To perform a flood fill:
     *
     * Begin with the starting pixel and change its color to color.
     * Perform the same process for each pixel that is directly adjacent (pixels that share a side with the original pixel,
     * either horizontally or vertically) and shares the same color as the starting pixel.
     * Keep repeating this process by checking neighboring pixels of the updated pixels and modifying their color if it matches the original color of the starting pixel.
     * The process stops when there are no more adjacent pixels of the original color to update.
     * Return the modified image after performing the flood fill.
     *
     * Example 1:
     *
     * Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
     * Output: [[2,2,2],[2,2,0],[2,0,1]]
     *
     * Explanation:
     *
     * From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), all pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.
     *
     * Note the bottom corner is not colored 2, because it is not horizontally or vertically connected to the starting pixel.
     *
     * Example 2:
     *
     * Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, color = 0
     *
     * Output: [[0,0,0],[0,0,0]]
     *
     * Explanation:
     *
     * The starting pixel is already colored with 0, which is the same as the target color. Therefore, no changes are made to the image.
     *
     *
     *
     * Constraints:
     *
     * m == image.length
     * n == image[i].length
     * 1 <= m, n <= 50
     * 0 <= image[i][j], color < 216
     * 0 <= sr < m
     * 0 <= sc < n
     *
     * */
    public static void main(String[] args) {
        int[][] image = {
            {1, 1, 1},
            {1, 1, 0},
            {1, 0, 1}
        };
        int sr = 1, sc = 1, color = 2;

        int[][] result = floodFill(image, sr, sc, color);
        for (int[] row : result) {
            for (int pixel : row) {
                System.out.print(pixel + " ");
            }
            System.out.println();
        }
    }

    //Solution 1: Using DFS
    // Time Complexity: O(m * n) where m is the number of rows and n is the number of columns in the image.
    // Space Complexity: O(m * n) for the recursion stack in the worst case.
    public static int[][] floodFill(int[][] image, int sr, int sc, int newcolor) {
        int iniColor = image[sr][sc];
        int[][] ans = image;
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};
        dfs(sr, sc, ans, image, newcolor, delRow, delCol, iniColor);
        return ans;
    }

    private static void dfs(int sr, int sc, int[][] ans, int[][] image, int newColor, int[] delRow, int[] delCol, int iniColor) {
        ans[sr][sc] = newColor;
        int n = image.length;
        int m = image[0].length;
        for (int i=0; i<4; i++){
            int nRow = sr + delRow[i];
            int nCol = sc + delCol[i];
            if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m &&
                image[nRow][nCol] == iniColor && ans[nRow][nCol] != newColor) {
                dfs(nRow, nCol, ans, image, newColor, delRow, delCol, iniColor);
            }
        }
    }


    //Solution 2: Using DFS (Simpler Version)
    // Time Complexity: O(m * n) where m is the number of rows and n is the number of columns in the image.
    // Space Complexity: O(m * n) for the recursion stack in the worst case.
    public int[][] floodFill2(int[][] image, int sr, int sc, int newColor) {
        int originalColor = image[sr][sc];

        // If the starting pixel already has the new color, no need to process
        if (originalColor == newColor) {
            return image;
        }

        // Start DFS
        dfs2(image, sr, sc, originalColor, newColor);
        return image;
    }

    private void dfs2(int[][] image, int r, int c, int originalColor, int newColor) {
        // Boundary check + check if same as original color
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length
                || image[r][c] != originalColor) {
            return;
        }

        // Change the color
        image[r][c] = newColor;

        // Explore neighbors (up, down, left, right)
        dfs2(image, r - 1, c, originalColor, newColor); // up
        dfs2(image, r + 1, c, originalColor, newColor); // down
        dfs2(image, r, c - 1, originalColor, newColor); // left
        dfs2(image, r, c + 1, originalColor, newColor); // right
    }
}
