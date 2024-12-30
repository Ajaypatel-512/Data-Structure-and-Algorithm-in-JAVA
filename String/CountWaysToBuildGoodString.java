package String;

public class CountWaysToBuildGoodString {

    /**
     * 2466. Count Ways To Build Good Strings
     * Given the integers zero, one, low, and high, we can construct a string by starting with an empty string, and then at each step perform either of the following:
     *
     * Append the character '0' zero times.
     * Append the character '1' one times.
     * This can be performed any number of times.
     *
     * A good string is a string constructed by the above process having a length between low and high (inclusive).
     *
     * Return the number of different good strings that can be constructed satisfying these properties. Since the answer can be large, return it modulo 109 + 7.
     *
     *
     *
     * Example 1:
     *
     * Input: low = 3, high = 3, zero = 1, one = 1
     * Output: 8
     * Explanation:
     * One possible valid good string is "011".
     * It can be constructed as follows: "" -> "0" -> "01" -> "011".
     * All binary strings from "000" to "111" are good strings in this example.
     * Example 2:
     *
     * Input: low = 2, high = 3, zero = 1, one = 2
     * Output: 5
     * Explanation: The good strings are "00", "11", "000", "110", and "011".
     *
     *
     * Constraints:
     *
     * 1 <= low <= high <= 105
     * 1 <= zero, one <= low
     * */
    public static void main(String[] args) {
        int low = 3, high = 3, zero = 1, one = 1;
        System.out.println(countGoodStrings2(low, high, zero, one));
    }

    // Dynamic programming approach
    // Time complexity: O(N)
    // Space complexity: O(N)
    public static int countGoodStrings(int low, int high, int zero, int one) {
        int maxLen = high + Math.max(zero,one);
        int dp[] = new int[maxLen+1];
        for(int len=high;len>=0;len--){
            int zeroLen = len + zero;
            int oneLen = len + one;
            int zeroCount = (zeroLen >= low && zeroLen <= high)?1:0;
            int oneCount = (oneLen >= low && oneLen <= high)?1:0;
            int res = zeroCount + dp[zeroLen] + oneCount + dp[oneLen];
            dp[len] = res % (1000000007);
        }
        return dp[0];
    }


    // Recursive approach
    // Time complexity: O(2^N)
    // Space complexity: O(1)
    public static int countGoodStrings2(int low, int high, int zero, int one) {
        return recur(low,high,zero,one,0);
    }
    public static int recur(int low, int high, int zero, int one,int len) {
        if (len > high){
            return 0;
        }
        int zeroLen = len + zero;
        int oneLen = len + one;
        int zeroCount = (zeroLen >= low && zeroLen <= high)?1:0;
        int oneCount = (oneLen >= low && oneLen <= high)?1:0;
        int res = zeroCount + recur(low,high,zero,one,zeroLen) + oneCount + recur(low,high,zero,one,oneLen);
        return res;
    }
}
