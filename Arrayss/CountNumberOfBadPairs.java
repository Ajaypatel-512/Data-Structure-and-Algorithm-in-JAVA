package Arrayss;

import java.util.HashMap;
import java.util.Map;

public class CountNumberOfBadPairs {
    /**
     * 2364. Count Number of Bad Pairs
     * You are given a 0-indexed integer array nums. A pair of indices (i, j) is a bad pair if i < j and j - i != nums[j] - nums[i].
     *
     * Return the total number of bad pairs in nums.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [4,1,3,3]
     * Output: 5
     * Explanation: The pair (0, 1) is a bad pair since 1 - 0 != 1 - 4.
     * The pair (0, 2) is a bad pair since 2 - 0 != 3 - 4, 2 != -1.
     * The pair (0, 3) is a bad pair since 3 - 0 != 3 - 4, 3 != -1.
     * The pair (1, 2) is a bad pair since 2 - 1 != 3 - 1, 1 != 2.
     * The pair (2, 3) is a bad pair since 3 - 2 != 3 - 3, 1 != 0.
     * There are a total of 5 bad pairs, so we return 5.
     * Example 2:
     *
     * Input: nums = [1,2,3,4,5]
     * Output: 0
     * Explanation: There are no bad pairs.
     *
     *
     * Constraints:
     *
     * 1 <= nums.length <= 105
     * 1 <= nums[i] <= 109
     * */
    public static void main(String[] args) {
        int[] nums = {4, 1, 3, 3};
        System.out.println(countBadPairs(nums));
    }

    //Solution 1 - Bruteforce
    //Time Complexity - O(n^2)
    //Space Complexity - O(1)
    public static long countBadPairs(int[] nums) {
        int n = nums.length;
        long result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (j - i != nums[j] - nums[i]) {
                    result++;
                }
            }
        }

        return result;
    }

    //Solution 2 - Using HashMap
    //Time Complexity - O(n)
    //Space Complexity - O(n)
    public static long countBadPairs2(int[] nums) {
        int n = nums.length;
        long result = 0;

        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] - i;
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 1);

        for (int j = 1; j < n; j++) {
            int countOfNumsj = map.getOrDefault(nums[j], 0);
            int totalNumsBeforej = j;
            int badPairs = totalNumsBeforej - countOfNumsj;
            result += badPairs;

            map.put(nums[j], countOfNumsj + 1);
        }

        return result;
    }

    //Solution 3 - Using HashMap
    //Time Complexity - O(n)
    //Space Complexity - O(n)
    public static long countBadPairs3(int[] nums) {
        int n = nums.length;
        long result = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int diff = nums[i] - i;
            int totalPairsTillIndex = i;
            int goodPairs = mp.getOrDefault(diff, 0);

            result += (totalPairsTillIndex - goodPairs);

            mp.put(diff, goodPairs + 1);
        }

        return result;
    }
}
