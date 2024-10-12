package Arrayss.subArrays;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class DivideIntoInterval {
    /**
     * 2406. Divide Intervals Into Minimum Number of Groups
     *
     * You are given a 2D integer array intervals where intervals[i] = [lefti, righti] represents the inclusive interval [lefti, righti].
     *
     * You have to divide the intervals into one or more groups such that each interval is in exactly one group, and no two intervals that are in the same group intersect each other.
     *
     * Return the minimum number of groups you need to make.
     *
     * Two intervals intersect if there is at least one common number between them. For example, the intervals [1, 5] and [5, 8] intersect.
     *
     * Example 1:
     *
     * Input: intervals = [[5,10],[6,8],[1,5],[2,3],[1,10]]
     * Output: 3
     * Explanation: We can divide the intervals into the following groups:
     * - Group 1: [1, 5], [6, 8].
     * - Group 2: [2, 3], [5, 10].
     * - Group 3: [1, 10].
     * It can be proven that it is not possible to divide the intervals into fewer than 3 groups.
     * Example 2:
     *
     * Input: intervals = [[1,3],[5,6],[8,10],[11,13]]
     * Output: 1
     * Explanation: None of the intervals overlap, so we can put all of them in one group.
     * */

    public static void main(String[] args) {
        int[][] arr = {{5,10},{6,8},{1,5},{2,3},{1,10}};
        System.out.println(minGroups2(arr));
    }


    // Solution 1 using brute force
    public static int minGroups1(int[][] intervals) {
        int n = intervals.length;

        Arrays.sort(intervals,new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        List<Integer> endArray = new ArrayList<>();
        endArray.add(intervals[0][1]);

        for (int i=1; i<n; i++){
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];

            boolean flag = false;
            for (int j=0; j<endArray.size(); j++){
                if (currStart > endArray.get(j)){
                    endArray.set(j,currEnd);
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                endArray.add(currEnd);
            }
        }

        return endArray.size();

    }

    //Solution 2 using SLA alogrithm
    public static int minGroups2(int[][] intervals) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int n = intervals.length;

        for (int i=0; i<n; i++){
            min = Math.min(min,intervals[i][0]);
            max = Math.max(max,intervals[i][1]);
        }

        int events[] = new int[max+2];

        for (int i=0; i<n; i++){
            events[intervals[i][0]]++;
            events[intervals[i][1]+1]--;
        }

        int maxOverlap = 0;
        int sum = 0;
        for (int i=min; i<max+2; i++){
            sum += events[i];
            maxOverlap = Math.max(maxOverlap,sum);
        }

        return maxOverlap;

    }


}
