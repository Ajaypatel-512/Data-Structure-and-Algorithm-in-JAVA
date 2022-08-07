package Extra;
//14. Longest Common Prefix
//        Write a function to find the longest common prefix string amongst an array of strings.
//
//        If there is no common prefix, return an empty string "".
//        Example 1:
//
//        Input: strs = ["flower","flow","flight"]
//        Output: "fl"
//        Example 2:
//
//        Input: strs = ["dog","racecar","car"]
//        Output: ""
//        Explanation: There is no common prefix among the input strings.

import java.util.ArrayList;
import java.util.Arrays;

public class leet14 {
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
//        for (int i = 0; i < strs.length; i++) {
//            System.out.println(strs[i]);
//        }
        System.out.println(longestCommonPrefix(strs));
    }
    public static String longestCommonPrefix(String[] strs) {
        StringBuilder ans = new StringBuilder();
        Arrays.sort(strs);
        char[] first = strs[0].toCharArray();
        char[] last = strs[strs.length-1].toCharArray();

        for (int i = 0; i < first.length; i++) {
            if(first[i] != last[i]){
                break;
            }
            ans.append(first[i]);
        }

        return ans.toString();
    }
}
