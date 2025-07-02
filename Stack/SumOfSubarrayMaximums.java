package Stack;

import java.util.Stack;

public class SumOfSubarrayMaximums {
    public static void main(String[] args) {

    }

    // Solution 1: Brute Force
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    public static int sumSubarrayMaxs(int[] arr) {
        int n = arr.length;
        int sum = 0;
        int mod = 1000000007;

        for (int i = 0; i < n; i++) {
            int max = arr[i];
            for (int j = i; j < n; j++) {
                max = Math.max(max, arr[j]);
                sum = (sum + max) % mod;
            }
        }
        return sum;
    }

    // Solution 2: Using small and large arrays
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public static int sumSubarrayMaxsOptimized(int[] arr) {
        int n = arr.length;
        int mod = 1000000007;

        int[] nse = findNextGreaterElement(arr);
        int[] pse = findPreviousGreaterElement(arr);
        int totalSum = 0;

        for (int i = 0; i < n; i++) {
            int leftCount = i - pse[i];
            int rightCount = nse[i] - i;
            totalSum = (int)((totalSum + (1L * arr[i] * leftCount * rightCount) % mod) % mod);
        }
        return totalSum;
    }
    private static int[] findNextGreaterElement(int[] arr) {
        int n = arr.length;
        int[] nse = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            nse[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        return nse;
    }

    private static int[] findPreviousGreaterElement(int[] arr) {
        int n = arr.length;
        int[] pse = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            pse[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return pse;
    }
}
