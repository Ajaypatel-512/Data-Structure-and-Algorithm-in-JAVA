package String.SubString;

import java.util.HashSet;

public class MaxNoOfUniqueSubStrings {
    /**
     * 1593. Split a String Into the Max Number of Unique Substrings
     *
     * Given a string s, return the maximum number of unique substrings that the given string can be split into.
     *
     * You can split string s into any list of non-empty substrings, where the concatenation of the substrings forms the original string. However, you must split the substrings such that all of them are unique.
     *
     * A substring is a contiguous sequence of characters within a string.
     *
     * Example 1:
     *
     * Input: s = "ababccc"
     * Output: 5
     * Explanation: One way to split maximally is ['a', 'b', 'ab', 'c', 'cc']. Splitting like ['a', 'b', 'a', 'b', 'c', 'cc'] is not valid as you have 'a' and 'b' multiple times.
     * Example 2:
     *
     * Input: s = "aba"
     * Output: 2
     * Explanation: One way to split maximally is ['a', 'ba'].
     * Example 3:
     *
     * Input: s = "aa"
     * Output: 1
     * Explanation: It is impossible to split the string any further.
     *
     * */
    public static void main(String[] args) {
        System.out.println(maxUniqueSplit("ababccc"));
    }

    public static int maxUniqueSplit(String s) {
        return helper(s, new HashSet<String>());
    }

    //Solution 1 using Backtracking
    private static int helper(String s, HashSet<String> set) {
        int max = 0;
        for (int i=1; i<=s.length(); i++){
            String candidate = s.substring(0,i);
            if (!set.contains(candidate)){
                set.add(candidate);
                max = Math.max(max,1+helper(s.substring(i),set));
                set.remove(candidate);
            }
        }
        return max;
    }
}
