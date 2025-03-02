package Arrayss.Matrix;

import java.util.*;

public class MergeTwo2DArraysBySummingValues {
    /**
     * 2570. Merge Two 2D Arrays by Summing Values
     * You are given two 2D integer arrays nums1 and nums2.
     *
     * nums1[i] = [idi, vali] indicate that the number with the id idi has a value equal to vali.
     * nums2[i] = [idi, vali] indicate that the number with the id idi has a value equal to vali.
     * Each array contains unique ids and is sorted in ascending order by id.
     *
     * Merge the two arrays into one array that is sorted in ascending order by id, respecting the following conditions:
     *
     * Only ids that appear in at least one of the two arrays should be included in the resulting array.
     * Each id should be included only once and its value should be the sum of the values of this id in the two arrays. If the id does not exist in one of the two arrays, then assume its value in that array to be 0.
     * Return the resulting array. The returned array must be sorted in ascending order by id.
     *
     *
     *
     * Example 1:
     *
     * Input: nums1 = [[1,2],[2,3],[4,5]], nums2 = [[1,4],[3,2],[4,1]]
     * Output: [[1,6],[2,3],[3,2],[4,6]]
     * Explanation: The resulting array contains the following:
     * - id = 1, the value of this id is 2 + 4 = 6.
     * - id = 2, the value of this id is 3.
     * - id = 3, the value of this id is 2.
     * - id = 4, the value of this id is 5 + 1 = 6.
     * Example 2:
     *
     * Input: nums1 = [[2,4],[3,6],[5,5]], nums2 = [[1,3],[4,3]]
     * Output: [[1,3],[2,4],[3,6],[4,3],[5,5]]
     * Explanation: There are no common ids, so we just include each id with its value in the resulting list.
     *
     *
     * Constraints:
     *
     * 1 <= nums1.length, nums2.length <= 200
     * nums1[i].length == nums2[j].length == 2
     * 1 <= idi, vali <= 1000
     * Both arrays contain unique ids.
     * Both arrays are in strictly ascending order by id.
     * */
    public static void main(String[] args) {
        int[][] nums1 = {{1,2},{2,3},{4,5}};
        int[][] nums2 = {{1,4},{3,2},{4,1}};
        int[][] result = mergeArrays(nums1, nums2);
        for (int[] res : result) {
            System.out.println(res[0] + " " + res[1]);
        }
    }

    //Solution 1 - Using TreeMap
    //Time complexity: O(n + m + nlogn) where n is the length of nums1 and m is the length of nums2
    //Space complexity: O(n + m)
    public static int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        Map<Integer, Integer> map = new TreeMap<>(); // TreeMap to keep ids sorted

        for (int[] pair : nums1) {
            map.put(pair[0], map.getOrDefault(pair[0], 0) + pair[1]);
        }
        for (int[] pair : nums2) {
            map.put(pair[0], map.getOrDefault(pair[0], 0) + pair[1]);
        }

        List<int[]> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            result.add(new int[]{entry.getKey(), entry.getValue()});
        }

        return result.toArray(new int[0][]);
    }

    //Solution 2 - Using two pointers
    //Time complexity: O(n + m) where n is the length of nums1 and m is the length of nums2
    //Space complexity: O(n + m)
    public static int[][] mergeArrays2(int[][] nums1, int[][] nums2) {
        List<int[]> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i][0] == nums2[j][0]) {
                result.add(new int[]{nums1[i][0], nums1[i][1] + nums2[j][1]});
                i++;
                j++;
            } else if (nums1[i][0] < nums2[j][0]) {
                result.add(nums1[i]);
                i++;
            } else {
                result.add(nums2[j]);
                j++;
            }
        }

        while (i < nums1.length) {
            result.add(nums1[i++]);
        }

        while (j < nums2.length) {
            result.add(nums2[j++]);
        }

        return result.toArray(new int[0][]);
    }

    //Solution 1 - Using PriorityQueue
    //Time complexity: O(nlogn) where n is the length of nums1 and m is the length of nums2
    //Space complexity: O(n + m)
    public static int[][] mergeArrays3(int[][] nums1, int[][] nums2) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (int[] pair : nums1) minHeap.offer(pair);
        for (int[] pair : nums2) minHeap.offer(pair);

        List<int[]> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            int[] first = minHeap.poll();
            if (!result.isEmpty() && result.get(result.size() - 1)[0] == first[0]) {
                result.get(result.size() - 1)[1] += first[1];
            } else {
                result.add(first);
            }
        }

        return result.toArray(new int[0][]);
    }

}
