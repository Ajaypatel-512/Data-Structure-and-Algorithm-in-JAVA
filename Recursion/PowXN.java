package Recursion;

public class PowXN {
    /**
     * 50. Pow(x, n)
     * Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
     *
     *
     *
     * Example 1:
     *
     * Input: x = 2.00000, n = 10
     * Output: 1024.00000
     * Example 2:
     *
     * Input: x = 2.10000, n = 3
     * Output: 9.26100
     * Example 3:
     *
     * Input: x = 2.00000, n = -2
     * Output: 0.25000
     * Explanation: 2-2 = 1/22 = 1/4 = 0.25
     *
     *
     * Constraints:
     *
     * -100.0 < x < 100.0
     * -231 <= n <= 231-1
     * n is an integer.
     * Either x is not zero or n > 0.
     * -104 <= xn <= 104
     * */
    public static void main(String[] args) {
        System.out.println(myPow(2.00000, 10)); // Output: 1024.00000
        System.out.println(myPow(2.10000, 3)); // Output: 9.26100
        System.out.println(myPow(2.00000, -2)); // Output: 0.25000
    }

    //Solution 1: Brute Force
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public static double myPow(double x, int n) {
        double result = 1.0;
        long long nn = n; // Handle negative powers by converting n to long
        if (nn < 0) nn = -1 * nn;
        while (nn > 0) {
            if (nn % 2 == 1) {
                result *= x;
                nn -= 1; // Decrement n if it is odd
            } else {
                x *= x; // Square x for the next iteration
                nn /= 2; // Divide n by 2
            }
        }
        return n < 0 ? 1.0 / result : result; // If n is negative, return the reciprocal
    }

    //Solution 2: Using Pow Method
    //Time Complexity: O(log n)
    //Space Complexity: O(1)
    public static double myPowUsingMath(double x, int n) {
        return Math.pow(x, n);
    }

    //Solution 3: Recursive Approach
    // Time Complexity: O(log n)
    // Space Complexity: O(log n) due to recursive stack space
    public static double myPowRecursive(double x, int n) {
        if (n == 0) return 1; // Base case: x^0 = 1

        if (n < 0) {
            // Handle edge case: Integer.MIN_VALUE
            // n = -2147483648 -> -(n) overflows
            return 1 / myPowRecursive(x, -(n + 1)) / x;
        }

        if (n % 2 == 0) {
            double half = myPowRecursive(x, n / 2);
            return half * half;
        } else {
            return x * myPowRecursive(x, n - 1);
        }
    }

}
