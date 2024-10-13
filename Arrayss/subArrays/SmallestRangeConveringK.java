package Arrayss.subArrays;

import java.util.List;

public class SmallestRangeConveringK {

    /**
     * 632. Smallest Range Covering Elements from K Lists
     * Hard
     * You have k lists of sorted integers in non-decreasing order. Find the smallest range that includes at least one number from each of the k lists.
     *
     * We define the range [a, b] is smaller than range [c, d] if b - a < d - c or a < c if b - a == d - c.
     *
     * Example 1:
     *
     * Input: nums = [[4,10,15,24,26],[0,9,12,20],[5,18,22,30]]
     * Output: [20,24]
     * Explanation:
     * List 1: [4, 10, 15, 24,26], 24 is in range [20,24].
     * List 2: [0, 9, 12, 20], 20 is in range [20,24].
     * List 3: [5, 18, 22, 30], 22 is in range [20,24].
     * Example 2:
     *
     * Input: nums = [[1,2,3],[1,2,3],[1,2,3]]
     * Output: [1,1]
     * */
    public static void main(String[] args) {
        int[][] nums = {{4,10,15,24,26},{0,9,12,20},{5,18,22,30}};
    }

    public static int[] smallestRange(List<List<Integer>> nums) {
        int len = nums.size();
        int[] listIndex = new int[len];
        int[] resultRange = new int[2];

        while (true){
            int minElement = Integer.MIN_VALUE;
            int maxElement = Integer.MAX_VALUE;
            int minElementIdx = 0;

            for (int i = 0; i < len; i++) {
                int listIdex = i;
                int eleIdx = listIndex[i];
                int element = nums.get(listIdex).get(eleIdx);

                if (element < minElement) {
                    minElement = element;
                    minElementIdx = listIdex;
                }

                if (element > maxElement) {
                    maxElement = element;
                }
            }

            if (maxElement - minElement < resultRange[1] - resultRange[0]) {
                resultRange[0] = minElement;
                resultRange[1] = maxElement;
            }

            int nextIdx = listIndex[minElementIdx] + 1;
            if (nextIdx >= nums.get(minElement).size()) {
                break;
            }

            listIndex[minElementIdx] = nextIdx;
        }
        return resultRange;
    }
}
