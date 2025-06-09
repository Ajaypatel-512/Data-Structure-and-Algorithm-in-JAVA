package String;

public class LongestPalindromicSubstring {
    /**
     * 5. Longest Palindromic Substring
     * Given a string s, return the longest palindromic substring in s.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "babad"
     * Output: "bab"
     * Explanation: "aba" is also a valid answer.
     * Example 2:
     *
     * Input: s = "cbbd"
     * Output: "bb"
     *
     *
     * Constraints:
     *
     * 1 <= s.length <= 1000
     * s consist of only digits and English letters.
     * */
    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));

        s = "cbbd";
        System.out.println(longestPalindrome(s));
    }

    //Solution 1 : Using brute force approach
    // Time Complexity: O(n^3) where n is the length of the string
    // Space Complexity: O(1) since we are not using any extra space except for variables
    public static String longestPalindrome(String s) {
        int maxLength = 0;
        String result = "";

        for (int i=0; i<s.length(); i++){
            for (int j=i+1; j<=s.length(); j++) {
                String sub = s.substring(i, j);
                if (isPalindrome(sub) && sub.length() > maxLength) {
                    maxLength = sub.length();
                    result = sub;
                }
            }
        }
        return result;
    }

    private static boolean isPalindrome(String sub) {
        int left = 0;
        int right = sub.length() - 1;

        while (left < right) {
            if (sub.charAt(left) != sub.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    //Solution 2: Using Dynamic Programming
    // Time Complexity: O(n^2) where n is the length of the string
    // Space Complexity: O(n^2) for the DP table
    public static String longestPalindrome2(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String result = "";

        for (int len = 1; len <= n; len++) {
            for (int start = 0; start <= n - len; start++) {
                int end = start + len - 1;

                if (s.charAt(start) == s.charAt(end)) {
                    if (len == 1 || len == 2 || dp[start + 1][end - 1]) {
                        dp[start][end] = true;
                        if (len > result.length()) {
                            result = s.substring(start, end + 1);
                        }
                    }
                }
            }
        }
        return result;
    }
}
