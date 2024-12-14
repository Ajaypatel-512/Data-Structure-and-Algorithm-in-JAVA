package Arrayss.subArrays;

import java.util.PriorityQueue;
import java.util.TreeMap;

public class ContinuousSubArray {

    /**
     * 2762. Continuous Subarrays
     * You are given a 0-indexed integer array nums. A subarray of nums is called continuous if:
     *
     * Let i, i + 1, ..., j be the indices in the subarray. Then, for each pair of indices i <= i1, i2 <= j, 0 <= |nums[i1] - nums[i2]| <= 2.
     * Return the total number of continuous subarrays.
     *
     * A subarray is a contiguous non-empty sequence of elements within an array.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [5,4,2,4]
     * Output: 8
     * Explanation:
     * Continuous subarray of size 1: [5], [4], [2], [4].
     * Continuous subarray of size 2: [5,4], [4,2], [2,4].
     * Continuous subarray of size 3: [4,2,4].
     * Thereare no subarrys of size 4.
     * Total continuous subarrays = 4 + 3 + 1 = 8.
     * It can be shown that there are no more continuous subarrays.
     *
     *
     * Example 2:
     *
     * Input: nums = [1,2,3]
     * Output: 6
     * Explanation:
     * Continuous subarray of size 1: [1], [2], [3].
     * Continuous subarray of size 2: [1,2], [2,3].
     * Continuous subarray of size 3: [1,2,3].
     * Total continuous subarrays = 3 + 2 + 1 = 6.
     *
     *
     * Constraints:
     *
     * 1 <= nums.length <= 105
     * 1 <= nums[i] <= 109
     * */

    public static void main(String[] args) {
        int[] nums = {5,4,2,4};
        System.out.println(continuousSubarrays(nums));
    }

    //Solution 1 (Using Ordered Map)
    //T.C : ~O(n)
    //S.C :  ~O(1)
    public static long continuousSubarrays(int[] nums) {
        int n = nums.length;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int i = 0, j = 0;
        long count = 0;

        while (j < n) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            while (Math.abs(map.lastKey() - map.firstKey()) > 2) {
                map.put(nums[i], map.get(nums[i]) - 1);
                if (map.get(nums[i]) == 0) {
                    map.remove(nums[i]);
                }
                i++;
            }

            count += j - i + 1;
            j++;
        }

        return count;
    }


    public static long continuousSubarrays2(int[] nums) {
        int n = nums.length;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));

        int i = 0, j = 0;
        long count = 0;

        while (j < n) {
            minHeap.offer(new int[]{nums[j], j});
            maxHeap.offer(new int[]{nums[j], j});

            while (Math.abs(maxHeap.peek()[0] - minHeap.peek()[0]) > 2) {
                i++;

                while (!maxHeap.isEmpty() && maxHeap.peek()[1] < i) {
                    maxHeap.poll();
                }

                while (!minHeap.isEmpty() && minHeap.peek()[1] < i) {
                    minHeap.poll();
                }
            }

            count += j - i + 1;
            j++;
        }

        return count;
    }
}
