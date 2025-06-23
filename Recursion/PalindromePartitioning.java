package Recursion;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    /**
     * 131. Palindrome Partitioning
     * Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "aab"
     * Output: [["a","a","b"],["aa","b"]]
     * Example 2:
     *
     * Input: s = "a"
     * Output: [["a"]]
     *
     *
     * Constraints:
     *
     * 1 <= s.length <= 16
     * s contains only lowercase English letters.
     * */
    public static void main(String[] args) {
        String s = "aab";
        List<List<String>> result = partition(s);
        System.out.println(result);
    }

    //Solution 1: Using Backtracking
    //Time Complexity: O(2^n * n) where n is the length of the string s. The 2^n comes from the fact that we can choose to include or exclude each character in the string, and n comes from the time taken to check if a substring is a palindrome.
    //Space Complexity: O(n) for the recursion stack and O(2^n * n) for the result list.
    public static List<List<String>> partition(String s) {
        List<String> currentPartition = new ArrayList<>();
        List<List<String>> result = new ArrayList<>();

        solve(s,0, currentPartition, result);
        return result;
    }

    private static void solve(String s, int idx, List<String> currentPartition, List<List<String>> result) {
        if (idx == s.length()) {
            result.add(new ArrayList<>(currentPartition));
            return;
        }

        for (int i=idx ; i<s.length(); i++) {
            if (isPalindrome(s, idx, i)) {
                currentPartition.add(s.substring(idx, i + 1));
                solve(s, i + 1, currentPartition, result);
                currentPartition.remove(currentPartition.size() - 1); // backtrack
            }
        }
    }

    public static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
