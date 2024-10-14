package Arrayss.subArrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

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

    //Solution 2 using heap
    public static int[] smallestRange2(List<List<Integer>> nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int k = nums.size();
        int max = Integer.MIN_VALUE;


       for (int i=0; i<k; i++){
           int minVal = nums.get(i).get(0);
           pq.offer(new int[]{minVal,i,0});
           max = Math.max(max,minVal);
       }
       int[] minRange = {0,Integer.MIN_VALUE};
       while (true){
           int top[] = pq.poll();
           int minElement = top[0];
           int listIndex = top[1];
           int elementIndex = top[2];

           if (max - minElement < minRange[1] - minRange[0]){
               minRange[0] = minElement;
               minRange[1] = max;
           }
           if (elementIndex == nums.get(listIndex).size()-1){
               break;
           }
           int next = nums.get(listIndex).get(elementIndex+1);
           max = Math.max(max,next);
           pq.offer(new int[]{next,listIndex,elementIndex+1});
       }
       return minRange;
    }
}
