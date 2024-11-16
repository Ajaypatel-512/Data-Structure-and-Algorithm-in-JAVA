package Arrayss.SlidingWindow;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class PowerOfKSizeSubArray {
    /**
     * 3254. Find the Power of K-Size Subarrays I
     * Medium
     * Topics
     * Companies
     * Hint
     * You are given an array of integers nums of length n and a positive integer k.
     *
     * The power of an array is defined as:
     *
     * Its maximum element if all of its elements are consecutive and sorted in ascending order.
     * -1 otherwise.
     * You need to find the power of all
     * subarrays
     *  of nums of size k.
     *
     * Return an integer array results of size n - k + 1, where results[i] is the power of nums[i..(i + k - 1)].
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,2,3,4,3,2,5], k = 3
     *
     * Output: [3,4,-1,-1,-1]
     *
     * Explanation:
     *
     * There are 5 subarrays of nums of size 3:
     *
     * [1, 2, 3] with the maximum element 3.
     * [2, 3, 4] with the maximum element 4.
     * [3, 4, 3] whose elements are not consecutive.
     * [4, 3, 2] whose elements are not sorted.
     * [3, 2, 5] whose elements are not consecutive.
     * Example 2:
     *
     * Input: nums = [2,2,2,2,2], k = 4
     *
     * Output: [-1,-1]
     *
     * Example 3:
     *
     * Input: nums = [3,2,3,2,3,2], k = 2
     *
     * Output: [-1,3,-1,3,-1]
     * */

    public static void main(String[] args) {
        int[] num = {1,3,4};
        int k =2;

        int[] result = resultsArray2(num,k);
        System.out.println(Arrays.toString(result));
    }

    //Solution 1 O(n*k) O(n-k+1)
    public static int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n-k+1];


        for (int i=0;i<n-k+1;i++) {
            boolean flag = true;
            int j;
            for (j = i; j < i+k-1; j++) {
                if(nums[j]>=nums[j+1] ) {
                    flag = false;
                    break;
                }
                else if((nums[j+1]- nums[j])>1){
                    flag = false;
                    break;
                }
            }
            if (flag){
                result[i] = nums[i+k-1];
            }else {
                result[i] = -1;
            }
        }
        return result;
    }

    //Solution 2 O(n) O(1)
    public static int[] resultsArray2(int[] nums, int k) {
        int n = nums.length;

        int[] result = new int[n - k + 1];
        // Initialize the result array with -1
        java.util.Arrays.fill(result, -1);

        int count = 1; // Count of consecutive elements

        // Preprocess the first window
        for (int i = 1; i < k; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                count++;
            } else {
                count = 1;
            }
        }

        // Check if the first window satisfies the condition
        if (count == k) {
            result[0] = nums[k - 1];
        }

        int i = 1;
        int j = k;

        // Process the sliding window
        while (j < n) {
            if (nums[j] == nums[j - 1] + 1) {
                count++;
            } else {
                count = 1;
            }

            if (count >= k) {
                result[i] = nums[j];
            }

            i++;
            j++;
        }

        return result;
    }

    //Solution 3 O(n) O(n)
    public static int[] resultsArray3(int[] nums, int k) {
        int n = nums.length;

        Deque<Integer> deq = new LinkedList<>(); // Monotonic deque
        int[] result = new int[n - k + 1];
        int index = 0;

        for (int j = 0; j < n; j++) {
            // If deque size equals k, remove the front element
            if (deq.size() == k) {
                deq.pollFirst();
            }

            // If deque is not empty and current element is not consecutive to the last element
            if (!deq.isEmpty() && deq.peekLast() != nums[j] - 1) {
                deq.clear();
            }

            // Add the current element to the deque
            deq.offerLast(nums[j]);

            // Once we process the first k elements
            if (j >= k - 1) {
                if (deq.size() == k) {
                    result[index++] = deq.peekLast(); // Last element is the max due to monotonic property
                } else {
                    result[index++] = -1; // Otherwise, add -1
                }
            }
        }

        return result;
    }
}
