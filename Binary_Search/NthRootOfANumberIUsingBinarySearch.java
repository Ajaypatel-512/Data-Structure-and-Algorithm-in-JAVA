package Binary_Search;

public class NthRootOfANumberIUsingBinarySearch {
    /**
     * Problem Statement: Given two numbers N and M, find the Nth root of M.
     * The nth root of a number M is defined as a number X when raised to the power N equals M. If the 'nth root is not an integer, return -1.
     *
     * Example 1:
     * Input Format: N = 3, M = 27
     * Result: 3
     * Explanation: The cube root of 27 is equal to 3.
     *
     * Example 2:
     * Input Format: N = 4, M = 69
     * Result: -1
     * Explanation: The 4th root of 69 does not exist. So, the answer is -1.
     * */
    public static void main(String[] args) {
        int N = 3, M = 27;
        System.out.println(nthRoot(N, M)); // Output: 3

        N = 4; M = 69;
        System.out.println(nthRoot(N, M)); // Output: -1
    }

    //Solution 1: Using Math .pow() method
    //Time Complexity: O(N)
    // Space Complexity: O(1)
    public static int nthRoot(int N, int M) {
        for (int i = 0; i <= M; i++) {
            if (Math.pow(i, N) == M) {
                return i;
            }
        }
        return -1;
    }

    //Solution 2: Using Linear search
    //Time Complexity: O(M)
    // Space Complexity: O(1)
    public static int nthRootLinearSearch(int n, int m) {
        for (int i = 1; i <= m; i++) {
            long val = func(i, n);
            if (val == (long)m) return i;
            else if (val > (long)m) break;
        }
        return -1;
    }
    public static long func(int b, int exp) {
        long  ans = 1;
        long base = b;
        while (exp > 0) {
            if (exp % 2 == 1) {
                exp--;
                ans = ans * base;
            } else {
                exp /= 2;
                base = base * base;
            }
        }
        return ans;
    }

    // Solution 3: Using Binary Search
    // Time Complexity: O(log M)
    // Space Complexity: O(1)
    public static int nthRootBinarySearch(int n, int m) {
        int low = 1, high = m;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            long val = funcB(mid, n, m);
            if (val == 1) return mid;
            else if (val == 0) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    private static long funcB(int mid, int n, int m) {
        long ans = 1;
        for (int i=1; i <= n; i++) {
            ans = ans * mid;
            if (ans > m) return 2; // If ans exceeds m, return 2 to indicate mid is too high
        }
        if (ans == m) return 1; // If ans equals m, return 1 to indicate mid is the nth root
        return 0; // If ans is less than m, return 0 to indicate mid is too low
    }


}
