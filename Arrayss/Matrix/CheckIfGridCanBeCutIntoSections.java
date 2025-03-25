package Arrayss.Matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckIfGridCanBeCutIntoSections {
    /**
     * 3394. Check if Grid can be Cut into Sections
     * You are given an integer n representing the dimensions of an n x n grid, with the origin at the bottom-left corner of the grid. You are also given a 2D array of coordinates rectangles, where rectangles[i] is in the form [startx, starty, endx, endy], representing a rectangle on the grid. Each rectangle is defined as follows:
     *
     * (startx, starty): The bottom-left corner of the rectangle.
     * (endx, endy): The top-right corner of the rectangle.
     * Note that the rectangles do not overlap. Your task is to determine if it is possible to make either two horizontal or two vertical cuts on the grid such that:
     *
     * Each of the three resulting sections formed by the cuts contains at least one rectangle.
     * Every rectangle belongs to exactly one section.
     * Return true if such cuts can be made; otherwise, return false.
     *
     *
     *
     * Example 1:
     *
     * Input: n = 5, rectangles = [[1,0,5,2],[0,2,2,4],[3,2,5,3],[0,4,4,5]]
     *
     * Output: true
     *
     * Explanation:
     *
     *
     *
     * The grid is shown in the diagram. We can make horizontal cuts at y = 2 and y = 4. Hence, output is true.
     *
     * Example 2:
     *
     * Input: n = 4, rectangles = [[0,0,1,1],[2,0,3,4],[0,2,2,3],[3,0,4,3]]
     *
     * Output: true
     *
     * Explanation:
     *
     *
     *
     * We can make vertical cuts at x = 2 and x = 3. Hence, output is true.
     *
     * Example 3:
     *
     * Input: n = 4, rectangles = [[0,2,2,4],[1,0,3,2],[2,2,3,4],[3,0,4,2],[3,2,4,4]]
     *
     * Output: false
     *
     * Explanation:
     *
     * We cannot make two horizontal or two vertical cuts that satisfy the conditions. Hence, output is false.
     *
     *
     *
     * Constraints:
     *
     * 3 <= n <= 109
     * 3 <= rectangles.length <= 105
     * 0 <= rectangles[i][0] < rectangles[i][2] <= n
     * 0 <= rectangles[i][1] < rectangles[i][3] <= n
     * No two rectangles overlap.
     * */
    public static void main(String[] args) {
        int n = 5;
        int[][] rectangles = {{1,0,5,2},{0,2,2,4},{3,2,5,3},{0,4,4,5}};
        System.out.println(checkValidCuts(n, rectangles));
    }

    //Solution 1 - Using merge intervals
    //Time Complexity: O(nlogn)
    //Space Complexity: O(n)
    public static boolean checkValidCuts(int n, int[][] rectangles) {
        List<int[]> hor = new ArrayList<>();
        List<int[]> vert = new ArrayList<>();

        for (int[] coord : rectangles) {
            int x1 = coord[0];
            int y1 = coord[1];
            int x2 = coord[2];
            int y2 = coord[3];

            hor.add(new int[]{x1, x2});
            vert.add(new int[]{y1, y2});
        }

        int[][] horArray = hor.toArray(new int[hor.size()][]);
        int[][] vertArray = vert.toArray(new int[vert.size()][]);

        int[][] result1 = merge(horArray);
        if (result1.length >= 3) {
            return true;
        }

        int[][] result2 = merge(vertArray);
        return result2.length >= 3;

    }

    public static int[][] merge(int[][] rectangles) {
        int n = rectangles.length;
        Arrays.sort(rectangles, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> result = new ArrayList<>();
        result.add(rectangles[0]);

        for (int i = 1; i < n; i++) {
            if (rectangles[i][0] < result.get(result.size() - 1)[1]) { // Overlapping
                result.get(result.size() - 1)[1] = Math.max(result.get(result.size() - 1)[1], rectangles[i][1]);
            } else {
                result.add(rectangles[i]);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
