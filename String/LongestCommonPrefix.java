package String;

import java.util.Arrays;

public class LongestCommonPrefix {
    /**
     * 14. Longest Common Prefix
     * Write a function to find the longest common prefix string amongst an array of strings.
     *
     * If there is no common prefix, return an empty string "".
     *
     *
     *
     * Example 1:
     *
     * Input: strs = ["flower","flow","flight"]
     * Output: "fl"
     * Example 2:
     *
     * Input: strs = ["dog","racecar","car"]
     * Output: ""
     * Explanation: There is no common prefix among the input strings.
     *
     *
     * Constraints:
     *
     * 1 <= strs.length <= 200
     * 0 <= strs[i].length <= 200
     * strs[i] consists of only lowercase English letters if it is non-empty.
     * */
    public static void main(String[] args) {
        String[] arr = {"apple","app","apps"};
        System.out.println(longestCommonPrefix(arr));
    }

    // Solution 1: Compare characters of each string at the same index
    // Time Complexity: O(n * m) where n is the number of strings and m is the length of the shortest string
    // Space Complexity: O(1) if we ignore the space used for the result string
    public static String longestCommonPrefix(String[] arr) {
        int minlen = findMinLength(arr, arr.length);
        String result = "";
        char current;

        for (int i = 0; i < minlen; i++){
            current = arr[0].charAt(i);

            for (int j = 1; j < arr.length; j++) {
                if (arr[j].charAt(i) != current) {
                    return result;
                }
            }
            result += (current);
        }

        return (result);
    }

    static int findMinLength(String arr[], int n) {
        int min = arr[0].length();

        for (int i = 1; i < n; i++) {
            if (arr[i].length() < min){
                min = arr[i].length();
            }
        }
        return (min);
    }

    // Solution 2: Sort the array and compare the first and last strings
    // // Time Complexity: O(n log n) due to sorting
    // // Space Complexity: O(1) if we ignore the space used by sorting
    public static String longestCommonPrefix2(String[] strs) {
        int n = strs.length;
        Arrays.sort(strs);
        char[] first = strs[0].toCharArray();
        char[] last = strs[n - 1].toCharArray();
        StringBuilder commonPrefix = new StringBuilder();

        for (int i=0; i<first.length; i++) {
            if (first[i] != last[i]) {
                break;
            }
            commonPrefix.append(first[i]);
        }
        return commonPrefix.toString();
    }
}
