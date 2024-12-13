package Arrayss;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class FindScoreOfAnArrayAfterMarkingAllElements {

    /**
     * 2593. Find Score of an Array After Marking All Elements
     * You are given an array nums consisting of positive integers.
     *
     * Starting with score = 0, apply the following algorithm:
     *
     * Choose the smallest integer of the array that is not marked. If there is a tie, choose the one with the smallest index.
     * Add the value of the chosen integer to score.
     * Mark the chosen element and its two adjacent elements if they exist.
     * Repeat until all the array elements are marked.
     * Return the score you get after applying the above algorithm.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [2,1,3,4,5,2]
     * Output: 7
     * Explanation: We mark the elements as follows:
     * - 1 is the smallest unmarked element, so we mark it and its two adjacent elements: [2,1,3,4,5,2].
     * - 2 is the smallest unmarked element, so we mark it and its left adjacent element: [2,1,3,4,5,2].
     * - 4 is the only remaining unmarked element, so we mark it: [2,1,3,4,5,2].
     * Our score is 1 + 2 + 4 = 7.
     * Example 2:
     *
     * Input: nums = [2,3,5,1,3,2]
     * Output: 5
     * Explanation: We mark the elements as follows:
     * - 1 is the smallest unmarked element, so we mark it and its two adjacent elements: [2,3,5,1,3,2].
     * - 2 is the smallest unmarked element, since there are two of them, we choose the left-most one, so we mark the one at index 0 and its right adjacent element: [2,3,5,1,3,2].
     * - 2 is the only remaining unmarked element, so we mark it: [2,3,5,1,3,2].
     * Our score is 1 + 2 + 2 = 5.
     *
     *
     * Constraints:
     *
     * 1 <= nums.length <= 105
     * 1 <= nums[i] <= 106
     * */

    public static void main(String[] args) {
        int[] nums = {2,1,3,4,5,2};
        System.out.println(findScore2(nums));
    }

    //Solution 1 Brute Force
    //T.C : O(nlogn + n)
    //S.C : O(n)
    public static long findScore(int[] nums) {
        int n = nums.length;
        List<int[]> pairs = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            pairs.add(new int[]{nums[i], i});
        }

        pairs.sort((a, b) -> Integer.compare(a[0], b[0]));

        boolean[] visited = new boolean[n];
        long score = 0;

        for (int i=0; i<pairs.size(); i++){
            int smallest = pairs.get(i)[0];
            int idx = pairs.get(i)[1];
            if (visited[idx]){
                continue;
            } else {
                score += smallest;
                visited[idx] = true;
                if (idx+1 < n) visited[idx+1] = true;
                if (idx-1 >= 0) visited[idx-1] = true;
            }
        }
        return score;
    }


    //Solution 2 Using Min Heap
    //T.C : O(nlogn)
    //S.C : O(n)
    public static long findScore2(int[] nums) {
        int n = nums.length;
        // Create a Min Heap (Priority Queue)
        PriorityQueue<int[]> pairs = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        for (int i = 0; i < n; i++) {
            pairs.offer(new int[]{nums[i], i});
        }

        boolean[] visited = new boolean[n];
        long score = 0;

        while(!pairs.isEmpty()){
            int[] element = pairs.poll();
            int smallest = element[0];
            int idx = element[1];
            if (visited[idx]){
                continue;
            } else {
                score += smallest;
                visited[idx] = true;
                if (idx+1 < n) visited[idx+1] = true;
                if (idx-1 >= 0) visited[idx-1] = true;
            }
        }
        return score;
    }
}
