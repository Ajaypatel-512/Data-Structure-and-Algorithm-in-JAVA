package Arrayss.Matrix;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindNumberOfDistinctColorsAmongBalls {
    /**
     * 3160. Find the Number of Distinct Colors Among the Balls
     * You are given an integer limit and a 2D array queries of size n x 2.
     *
     * There are limit + 1 balls with distinct labels in the range [0, limit]. Initially, all balls are uncolored. For every query in queries that is of the form [x, y], you mark ball x with the color y. After each query, you need to find the number of distinct colors among the balls.
     *
     * Return an array result of length n, where result[i] denotes the number of distinct colors after ith query.
     *
     * Note that when answering a query, lack of a color will not be considered as a color.
     *
     *
     *
     * Example 1:
     *
     * Input: limit = 4, queries = [[1,4],[2,5],[1,3],[3,4]]
     *
     * Output: [1,2,2,3]
     *
     * Explanation:
     *
     *
     *
     * After query 0, ball 1 has color 4.
     * After query 1, ball 1 has color 4, and ball 2 has color 5.
     * After query 2, ball 1 has color 3, and ball 2 has color 5.
     * After query 3, ball 1 has color 3, ball 2 has color 5, and ball 3 has color 4.
     * Example 2:
     *
     * Input: limit = 4, queries = [[0,1],[1,2],[2,2],[3,4],[4,5]]
     *
     * Output: [1,2,2,3,4]
     *
     * Explanation:
     *
     *
     *
     * After query 0, ball 0 has color 1.
     * After query 1, ball 0 has color 1, and ball 1 has color 2.
     * After query 2, ball 0 has color 1, and balls 1 and 2 have color 2.
     * After query 3, ball 0 has color 1, balls 1 and 2 have color 2, and ball 3 has color 4.
     * After query 4, ball 0 has color 1, balls 1 and 2 have color 2, ball 3 has color 4, and ball 4 has color 5.
     *
     *
     * Constraints:
     *
     * 1 <= limit <= 109
     * 1 <= n == queries.length <= 105
     * queries[i].length == 2
     * 0 <= queries[i][0] <= limit
     * 1 <= queries[i][1] <= 109
     * */
    public static void main(String[] args) {
        int limit = 4;
        int[][] queries = {{1,4},{2,5},{1,3},{3,4}};
        System.out.println(queryResults(limit, queries));
    }

    //Solution 1 : Using HashMap
    //Time Complexity: O(n)
    //Space Complexity: O(n) Memory Limit Exceeded
    public static int[] queryResults(int limit, int[][] queries) {
        int n = queries.length;
        int[] result = new int[n];

        Map<Integer, Integer> colormp = new HashMap<>();
        int[] ballArr = new int[limit + 1];
        Arrays.fill(ballArr, -1);

        for (int i = 0; i < n; i++) {
            int ball = queries[i][0];
            int color = queries[i][1];

            if (ballArr[ball] != -1) { // already colored ball
                int prevColor = ballArr[ball];
                colormp.put(prevColor, colormp.get(prevColor) - 1);

                if (colormp.get(prevColor) == 0) {
                    colormp.remove(prevColor);
                }
            }

            ballArr[ball] = color;
            colormp.put(color, colormp.getOrDefault(color, 0) + 1);

            result[i] = colormp.size();
        }

        return result;
    }

    //Solution 2 : Using Array
    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public static int[] queryResults2(int limit, int[][] queries) {
        int n = queries.length;
        int[] result = new int[n];

        Map<Integer, Integer> colormp = new HashMap<>();
        Map<Integer, Integer> ballmp = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int ball = queries[i][0];
            int color = queries[i][1];

            if (ballmp.containsKey(ball)) {
                int prevColor = ballmp.get(ball);
                colormp.put(prevColor, colormp.get(prevColor) - 1);

                if (colormp.get(prevColor) == 0) {
                    colormp.remove(prevColor);
                }
            }

            ballmp.put(ball, color);
            colormp.put(color, colormp.getOrDefault(color, 0) + 1);

            result[i] = colormp.size();
        }

        return result;
    }
}
