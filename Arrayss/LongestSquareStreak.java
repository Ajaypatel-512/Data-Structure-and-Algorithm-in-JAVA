package Arrayss;

import java.util.HashMap;
import java.util.Map;

public class LongestSquareStreak {
    /**
     * 2501. Longest Square Streak in an Array
     *
     * You are given an integer array nums. A subsequence of nums is called a square streak if:
     *
     * The length of the subsequence is at least 2, and
     * after sorting the subsequence, each element (except the first element) is the square of the previous number.
     * Return the length of the longest square streak in nums, or return -1 if there is no square streak.
     *
     * A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.
     *
     * Example 1:
     *
     * Input: nums = [4,3,6,16,8,2]
     * Output: 3
     * Explanation: Choose the subsequence [4,16,2]. After sorting it, it becomes [2,4,16].
     * - 4 = 2 * 2.
     * - 16 = 4 * 4.
     * Therefore, [4,16,2] is a square streak.
     * It can be shown that every subsequence of length 4 is not a square streak.
     * Example 2:
     *
     * Input: nums = [2,3,5,6,7]
     * Output: -1
     * Explanation: There is no square streak in nums so return -1.
     * */

    public static void main(String[] args) {
        int[] nums = {4,3,6,16,8,2};
        System.out.println(longestSquareStreak(nums));
    }

    //Solution 1 O(n) O(n)
    public  static int longestSquareStreak(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int max = 0;

        for(int n:nums){
            if(map.containsKey(n)) continue;
            double dsqrt = Math.sqrt(n);
            int sqrt = (Math.floor(dsqrt)==dsqrt) ? (int)dsqrt:-1;
            double dsq = Math.pow(n,2);
            int sqr =  (dsq <= 100000d) && (Math.floor(dsq)==dsq)? (int)dsq:-1;

            int parity = map.containsKey(sqrt) ? map.get(sqrt):0;
            parity += map.containsKey(sqr) ? map.get(sqr):0;

            map.put(n,1+parity);
            if(map.containsKey(sqrt)){
                map.put(sqrt,1+parity);
            }
            if(map.containsKey(sqr)){
                map.put(sqr,1+parity);
            }
            max = Math.max(max,1+parity);
        }
        //System.out.println(map);
        return max==1?-1:max;
    }
}
