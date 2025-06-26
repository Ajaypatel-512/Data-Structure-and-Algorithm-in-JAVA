package Stack;

import java.util.Stack;

public class SumOfSubarrayMinimums {
    /**
     * 907. Sum of Subarray Minimums
     * Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr. Since the answer may be large, return the answer modulo 109 + 7.
     *
     *
     *
     * Example 1:
     *
     * Input: arr = [3,1,2,4]
     * Output: 17
     * Explanation:
     * Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4].
     * Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
     * Sum is 17.
     * Example 2:
     *
     * Input: arr = [11,81,94,43,3]
     * Output: 444
     *
     *
     * Constraints:
     *
     * 1 <= arr.length <= 3 * 104
     * 1 <= arr[i] <= 3 * 104
     * */
    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4};
        System.out.println(sumSubarrayMins(arr)); // Output: 17

        int[] arr2 = {11, 81, 94, 43, 3};
        System.out.println(sumSubarrayMins(arr2)); // Output: 444
    }

    //Solution 1: Brute Force
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    public static int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int sum = 0;
        int mod = 1000000007;

        for (int i=0; i<n; i++){
            int min = arr[i];
            for (int j=i; j<n; j++){
                min = Math.min(min, arr[j]);
                sum = (sum + min) % mod;
            }
        }
        return sum;
    }


    //Solution 2: Using small and large arrays
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public static int sumSubarrayMinsOptimized(int[] arr) {
        int n = arr.length;
        int mod = 1000000007;

        int[] nse = findNextSmallerElement(arr);
        int[] pse = findPreviousSmallerElement(arr);
        int totalSum = 0;

        for (int i = 0; i < n; i++) {
            int leftCount = i - pse[i];
            int rightCount = nse[i] - i;
            totalSum = (int)((totalSum + (1L * arr[i] * leftCount * rightCount) % mod) % mod);
        }
        return totalSum;
    }

    private static int[] findNextSmallerElement(int[] arr) {
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

    private static int[] findPreviousSmallerElement(int[] arr) {
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
