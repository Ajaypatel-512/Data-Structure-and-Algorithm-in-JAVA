package Stack;

import java.util.Stack;

public class SumOfSubarrayRanges {
    /**
     * 2104. Sum of Subarray Ranges
     * Medium
     * Topics
     * premium lock icon
     * Companies
     * Hint
     * You are given an integer array nums. The range of a subarray of nums is the difference between the largest and smallest element in the subarray.
     *
     * Return the sum of all subarray ranges of nums.
     *
     * A subarray is a contiguous non-empty sequence of elements within an array.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,2,3]
     * Output: 4
     * Explanation: The 6 subarrays of nums are the following:
     * [1], range = largest - smallest = 1 - 1 = 0
     * [2], range = 2 - 2 = 0
     * [3], range = 3 - 3 = 0
     * [1,2], range = 2 - 1 = 1
     * [2,3], range = 3 - 2 = 1
     * [1,2,3], range = 3 - 1 = 2
     * So the sum of all ranges is 0 + 0 + 0 + 1 + 1 + 2 = 4.
     * Example 2:
     *
     * Input: nums = [1,3,3]
     * Output: 4
     * Explanation: The 6 subarrays of nums are the following:
     * [1], range = largest - smallest = 1 - 1 = 0
     * [3], range = 3 - 3 = 0
     * [3], range = 3 - 3 = 0
     * [1,3], range = 3 - 1 = 2
     * [3,3], range = 3 - 3 = 0
     * [1,3,3], range = 3 - 1 = 2
     * So the sum of all ranges is 0 + 0 + 0 + 2 + 0 + 2 = 4.
     * Example 3:
     *
     * Input: nums = [4,-2,-3,4,1]
     * Output: 59
     * Explanation: The sum of all subarray ranges of nums is 59.
     *
     *
     * Constraints:
     *
     * 1 <= nums.length <= 1000
     * -109 <= nums[i] <= 109
     *
     *
     * Follow-up: Could you find a solution with O(n) time complexity?
     * */
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(subArrayRanges(nums)); // Output: 4

        int[] nums1 = {1, 3, 3};
        System.out.println(new SumOfSubarrayRanges().subArrayRanges1(nums1)); // Output: 4

        int[] nums2 = {4, -2, -3, 4, 1};
        System.out.println(new SumOfSubarrayRanges().subArrayRanges1(nums2)); // Output: 59
    }

    //Solution 1: Brute Force
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    public static long subArrayRanges(int[] nums) {
        int n = nums.length;
        long ans = 0;

        for (int i = 0; i < n; i++) {
            int max = nums[i];
            int min = nums[i];
            for (int j = i + 1; j < n; j++) {
                max = Math.max(max, nums[j]);
                min = Math.min(min, nums[j]);
                ans += max - min;
            }
        }
        return ans;
    }

    //Solution 2: Using Stack
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public long subArrayRanges1(int[] nums) {
        return sumSubarrayMaxsOptimized1(nums) - sumSubarrayMinsOptimized1(nums);
    }

    public long sumSubarrayMaxsOptimized1(int[] arr) {
        int n = arr.length;
        int[] nse = findNextGreaterElement1(arr);
        int[] pse = findPreviousGreaterElement1(arr);
        long totalSum = 0;

        for (int i = 0; i < n; i++) {
            long leftCount = i - pse[i];
            long rightCount = nse[i] - i;
            totalSum += (long) arr[i] * leftCount * rightCount;
        }
        return totalSum;
    }

    public long sumSubarrayMinsOptimized1(int[] arr) {
        int n = arr.length;
        int[] nse = findNextSmallerElement1(arr);
        int[] pse = findPreviousSmallerElement1(arr);
        long totalSum = 0;

        for (int i = 0; i < n; i++) {
            long leftCount = i - pse[i];
            long rightCount = nse[i] - i;
            totalSum += (long) arr[i] * leftCount * rightCount;
        }
        return totalSum;
    }

    private int[] findNextGreaterElement1(int[] arr) {
        int n = arr.length;
        int[] nge = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            nge[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        return nge;
    }

    private int[] findPreviousGreaterElement1(int[] arr) {
        int n = arr.length;
        int[] pge = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }
            pge[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return pge;
    }

    private int[] findNextSmallerElement1(int[] arr) {
        int n = arr.length;
        int[] nse = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            nse[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        return nse;
    }

    private int[] findPreviousSmallerElement1(int[] arr) {
        int n = arr.length;
        int[] pse = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            pse[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return pse;
    }
}
