package Arrayss;

public class MinimumRecolorsToGetKConsecutiveBlackBlocks {
    /**
     * 2379. Minimum Recolors to Get K Consecutive Black Blocks
     * You are given a 0-indexed string blocks of length n, where blocks[i] is either 'W' or 'B', representing the color of the ith block. The characters 'W' and 'B' denote the colors white and black, respectively.
     *
     * You are also given an integer k, which is the desired number of consecutive black blocks.
     *
     * In one operation, you can recolor a white block such that it becomes a black block.
     *
     * Return the minimum number of operations needed such that there is at least one occurrence of k consecutive black blocks.
     *
     *
     *
     * Example 1:
     *
     * Input: blocks = "WBBWWBBWBW", k = 7
     * Output: 3
     * Explanation:
     * One way to achieve 7 consecutive black blocks is to recolor the 0th, 3rd, and 4th blocks
     * so that blocks = "BBBBBBBWBW".
     * It can be shown that there is no way to achieve 7 consecutive black blocks in less than 3 operations.
     * Therefore, we return 3.
     * Example 2:
     *
     * Input: blocks = "WBWBBBW", k = 2
     * Output: 0
     * Explanation:
     * No changes need to be made, since 2 consecutive black blocks already exist.
     * Therefore, we return 0.
     *
     *
     * Constraints:
     *
     * n == blocks.length
     * 1 <= n <= 100
     * blocks[i] is either 'W' or 'B'.
     * 1 <= k <= n
     * */
    public static void main(String[] args) {
        String blocks = "BWWWBB";
        int k = 6;
        System.out.println(minimumRecolors(blocks, k));
    }

    //Solution 1 - Brute Force
    //Time Complexity - O(n*k)
    //Space Complexity - O(1)
    public static int minimumRecolors(String blocks, int k) {
        int n = blocks.length();
        int result = k;

        for (int i = 0; i <= n - k; i++) {
            int W = 0;
            for (int j = i; j - i + 1 <= k; j++) {
                if (blocks.charAt(j) == 'W') {
                    W++;
                }
            }
            result = Math.min(result, W);
        }

        return result;
    }

    //Solution 2 - Sliding Window
    //Time Complexity - O(n)
    //Space Complexity - O(1)
    public static int minimumRecolors2(String blocks, int k) {
        int n = blocks.length();
        int i = 0;
        int j = 0;

        int ops = k;
        int W = 0;

        while (j < n) {
            if (blocks.charAt(j) == 'W') {
                W++;
            }

            if (j - i + 1 == k) {
                ops = Math.min(ops, W);

                if (blocks.charAt(i) == 'W') {
                    W--;
                }
                i++;
            }
            j++;
        }

        return ops;
    }

}
