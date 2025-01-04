package String.SubSequence;

import java.util.HashMap;
import java.util.HashSet;

public class UniqueLength3PalindromicSubSequence {
    /**
     * 1930. Unique Length-3 Palindromic Subsequences
     * Given a string s, return the number of unique palindromes of length three that are a subsequence of s.
     *
     * Note that even if there are multiple ways to obtain the same subsequence, it is still only counted once.
     *
     * A palindrome is a string that reads the same forwards and backwards.
     *
     * A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
     *
     * For example, "ace" is a subsequence of "abcde".
     *
     *
     * Example 1:
     *
     * Input: s = "aabca"
     * Output: 3
     * Explanation: The 3 palindromic subsequences of length 3 are:
     * - "aba" (subsequence of "aabca")
     * - "aaa" (subsequence of "aabca")
     * - "aca" (subsequence of "aabca")
     * Example 2:
     *
     * Input: s = "adc"
     * Output: 0
     * Explanation: There are no palindromic subsequences of length 3 in "adc".
     * Example 3:
     *
     * Input: s = "bbcbaba"
     * Output: 4
     * Explanation: The 4 palindromic subsequences of length 3 are:
     * - "bbb" (subsequence of "bbcbaba")
     * - "bcb" (subsequence of "bbcbaba")
     * - "bab" (subsequence of "bbcbaba")
     * - "aba" (subsequence of "bbcbaba")
     *
     *
     * Constraints:
     *
     * 3 <= s.length <= 105
     * s consists of only lowercase English letters.
     * */
    public static void main(String[] args) {
        String s = "aabca";
        System.out.println(countPalindromicSubsequence(s)); // 3
    }

    //Solution 1
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public static int countPalindromicSubsequence(String s) {
        HashSet<Character> set = new HashSet<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            set.add(s.charAt(i));
        }
        int count = 0;
        for (char c : set) {
            int first = -1;
            int last = -1;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == c) {
                    if (first == -1) {
                        first = i;
                    }
                    last = i;
                }
            }
            if (first == last) {
                continue;
            }
            HashSet<Character> set1 = new HashSet<>();
            for (int i = first + 1; i < last; i++) {
                set1.add(s.charAt(i));
            }
            count += set1.size();
        }
        return count;
    }

    //Solution 2
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public static int countPalindromicSubsequence2(String s) {
        // find unique chars
        HashMap<Character,Integer> firstOcc = new HashMap<Character,Integer>();
        HashMap<Character,Integer> lastOcc = new HashMap<Character,Integer>();
        int n = s.length();
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(!firstOcc.containsKey(ch)){
                firstOcc.put(ch,i);
            }
            lastOcc.put(ch,i);
        }

        int count=0;
        for(char ch : firstOcc.keySet()){
            int first=firstOcc.get(ch);
            int last = lastOcc.get(ch);
            if(first == last) continue;
            HashSet<Character> set1 = new HashSet<>();
            for(int i=first+1;i<last;i++){
                set1.add(s.charAt(i));
            }
            count += set1.size();
        }
        return count;
    }
}
