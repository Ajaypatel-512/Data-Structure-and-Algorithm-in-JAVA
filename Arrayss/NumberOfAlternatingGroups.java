package Arrayss;

public class NumberOfAlternatingGroups {
    /**
     * 3208. Alternating Groups II
     * There is a circle of red and blue tiles. You are given an array of integers colors and an integer k. The color of tile i is represented by colors[i]:
     *
     * colors[i] == 0 means that tile i is red.
     * colors[i] == 1 means that tile i is blue.
     * An alternating group is every k contiguous tiles in the circle with alternating colors (each tile in the group except the first and last one has a different color from its left and right tiles).
     *
     * Return the number of alternating groups.
     *
     * Note that since colors represents a circle, the first and the last tiles are considered to be next to each other.
     *
     *
     *
     * Example 1:
     *
     * Input: colors = [0,1,0,1,0], k = 3
     *
     * Output: 3
     *
     * Explanation:
     *
     *
     *
     * Alternating groups:
     *
     *
     *
     * Example 2:
     *
     * Input: colors = [0,1,0,0,1,0,1], k = 6
     *
     * Output: 2
     *
     * Explanation:
     *
     *
     *
     * Alternating groups:
     *
     *
     *
     * Example 3:
     *
     * Input: colors = [1,1,0,1], k = 4
     *
     * Output: 0
     *
     * Explanation:
     *
     *
     *
     *
     *
     * Constraints:
     *
     * 3 <= colors.length <= 105
     * 0 <= colors[i] <= 1
     * 3 <= k <= colors.length
     * */
    public static void main(String[] args) {
        int[] colors = {0,1,0,1,0};
        int k = 3;
        System.out.println(numberOfAlternatingGroups(colors, k));
    }

    //Solution 1 - Using Sliding Window
    //Time Complexity - O(n)
    //Space Complexity - O(1)
    public static int numberOfAlternatingGroups(int[] colors, int k) {
        int window = 1;
        int res = 0;
        int n = colors.length;
        int i = 0;
        int j = 1;
        while(i < colors.length) {
            if(colors[(j-1) % n] != colors[j%n]) {
                window++;
                j++;
            }else {
                i = j;
                j = i + 1;
                window = 1;
                continue;
            }

            if(window == k) {
                res++;
                if(colors[(j-1) % n] != colors[j%n]) {
                    i++;
                    window -= 1;
                }else {
                    i = j;
                    j = i + 1;
                    window = 1;
                }
            }
        }

        return res;
    }
}
