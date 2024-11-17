package Arrayss;

import java.util.Deque;
import java.util.LinkedList;

public class ShortestSubArrayWithSumAtLeastK {
    /**
     * 862. Shortest Subarray with Sum at Least K
     *
     * Companies
     * Given an integer array nums and an integer k, return the length of the shortest non-empty subarray of nums with a sum of at least k. If there is no such subarray, return -1.
     *
     * A subarray is a contiguous part of an array.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1], k = 1
     * Output: 1
     * Example 2:
     *
     * Input: nums = [1,2], k = 4
     * Output: -1
     * Example 3:
     *
     * Input: nums = [2,-1,2], k = 3
     * Output: 3
     * */

    public static void main(String[] args) {
        int[] nums = {1};
        int k = 1;
        System.out.println(shortestSubarray(nums,k));
    }

    //Approach (Using sliding window + monotonic deque
    //T.C : O(n)
    //S.C : O(n)
    public static int shortestSubarray(int[] nums, int k) {
        int N = nums.length;

        Deque<Integer> deq = new LinkedList<>();
        long[] cumulativeSum = new long[N];

        int result = Integer.MAX_VALUE;
        int j = 0;

        while (j < N) {
            if (j == 0)
                cumulativeSum[j] = nums[j];
            else
                cumulativeSum[j] = cumulativeSum[j - 1] + nums[j];

            if (cumulativeSum[j] >= k)
                result = Math.min(result, j + 1);

            while (!deq.isEmpty() && cumulativeSum[j] - cumulativeSum[deq.peekFirst()] >= k) {
                result = Math.min(result, j - deq.peekFirst());
                deq.pollFirst();
            }

            while (!deq.isEmpty() && cumulativeSum[j] <= cumulativeSum[deq.peekLast()]) {
                deq.pollLast();
            }

            deq.offerLast(j);
            j++;
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
