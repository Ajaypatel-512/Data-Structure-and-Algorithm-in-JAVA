package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class TheKthLexicographicalStringOfAllHappyStringsLengthN {
    /**
     * 1415. The k-th Lexicographical String of All Happy Strings of Length n
     * A happy string is a string that:
     *
     * consists only of letters of the set ['a', 'b', 'c'].
     * s[i] != s[i + 1] for all values of i from 1 to s.length - 1 (string is 1-indexed).
     * For example, strings "abc", "ac", "b" and "abcbabcbcb" are all happy strings and strings "aa", "baa" and "ababbc" are not happy strings.
     *
     * Given two integers n and k, consider a list of all happy strings of length n sorted in lexicographical order.
     *
     * Return the kth string of this list or return an empty string if there are less than k happy strings of length n.
     *
     *
     *
     * Example 1:
     *
     * Input: n = 1, k = 3
     * Output: "c"
     * Explanation: The list ["a", "b", "c"] contains all happy strings of length 1. The third string is "c".
     * Example 2:
     *
     * Input: n = 1, k = 4
     * Output: ""
     * Explanation: There are only 3 happy strings of length 1.
     * Example 3:
     *
     * Input: n = 3, k = 9
     * Output: "cab"
     * Explanation: There are 12 different happy string of length 3 ["aba", "abc", "aca", "acb", "bab", "bac", "bca", "bcb", "cab", "cac", "cba", "cbc"]. You will find the 9th string = "cab"
     *
     *
     * Constraints:
     *
     * 1 <= n <= 10
     * 1 <= k <= 100
     * */
    public static void main(String[] args) {
        int n = 1, k = 3;
        System.out.println(getHappyString1(n, k)); // c
        n = 1; k = 4;
        System.out.println(getHappyString1(n, k)); // ""
        n = 3; k = 9;
        System.out.println(getHappyString1(n, k)); // cab
    }


    public static String getHappyString1(int n, int k) {
        //Generate All Happy Strings

        //Sort them in lexicographical order
        //Return kth string
    }

    //Solution 2 : Generate all happy strings and return kth string
    //Time Complexity : O(n * 3 * 2^(n-1)) ~= O(n*2^n)
    //Space Complexity : O(n * 2^n), total 2^n strings each having length n
    public static String getHappyString2(int n, int k) {
        StringBuilder curr = new StringBuilder();
        List<String> res = new ArrayList<>();
        solve(curr,res,n);
        if (k>res.size())
            return "";

        return res.get(k-1);
    }

    private static void solve(StringBuilder curr, List<String> res, int n) {
        if (curr.length() == n){
            res.add(curr.toString());
            return;
        }

        for (char ch = 'a'; ch <= 'c'; ch++){
            if (curr.length() > 0 && curr.charAt(curr.length()-1) == ch){
                continue;
            }
            curr.append(ch);
            solve(curr,res,n);
            curr.deleteCharAt(curr.length()-1);
        }
    }

    //Solution 3 : Generate all happy strings and return kth string
    //Time Complexity : O(n * 3 * 2^(n-1)) ~= O(n*2^n)
    //Space Complexity : O(n) by recursion system stack
    public static String getHappyString3(int n, int k) {
        StringBuilder curr = new StringBuilder();
        String[] result = {""};
        int[] count = {0};
        solve1(curr,result,n,k,count);
        return result[0];
    }

    private static void solve1(StringBuilder curr, String[] res, int n, int k, int[] count) {
        if (curr.length() == n){
            count[0]++;
            if (count[0] == k){
                res[0] = curr.toString();
            }
            return;
        }

        for (char ch = 'a'; ch <= 'c'; ch++){
            if (curr.length() > 0 && curr.charAt(curr.length()-1) == ch){
                continue;
            }
            curr.append(ch);
            solve1(curr,res,n,k,count);
            if (!res[0].isEmpty()) return;
            curr.deleteCharAt(curr.length()-1);
        }
    }

}
