package Arrayss;

import java.util.Arrays;

public class CheckIfOneStringSwapCanMakeStringsEqual {
    /**
     * 1790. Check if One String Swap Can Make Strings Equal
     * You are given two strings s1 and s2 of equal length. A string swap is an operation where you choose two indices in a string (not necessarily different) and swap the characters at these indices.
     *
     * Return true if it is possible to make both strings equal by performing at most one string swap on exactly one of the strings. Otherwise, return false.
     *
     *
     *
     * Example 1:
     *
     * Input: s1 = "bank", s2 = "kanb"
     * Output: true
     * Explanation: For example, swap the first character with the last character of s2 to make "bank".
     * Example 2:
     *
     * Input: s1 = "attack", s2 = "defend"
     * Output: false
     * Explanation: It is impossible to make them equal with one string swap.
     * Example 3:
     *
     * Input: s1 = "kelb", s2 = "kelb"
     * Output: true
     * Explanation: The two strings are already equal, so no string swap operation is required.
     *
     *
     * Constraints:
     *
     * 1 <= s1.length, s2.length <= 100
     * s1.length == s2.length
     * s1 and s2 consist of only lowercase English letters.
     * */
    public static void main(String[] args) {
        String s1 = "bank", s2 = "kanb";
        System.out.println(areAlmostEqual(s1, s2));
    }

    //Solution 1 - Using Brute Force
    //Time Complexity - O(n^2)
    //Space Complexity - O(n)
    public static boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) return true;

        int l1 = s1.length();
        for(int i=0; i<l1; i++){
            for(int j=i+1; j<l1; j++) {
                char[] s1Arr = s1.toCharArray();

                char temp = s1Arr[i];
                s1Arr[i] = s1Arr[j];
                s1Arr[j] = temp;

                if (String.valueOf(s1Arr).equals(s2)) return true;
            }
        }
        return false;
    }

    //Solution 2 - Using Two Pointers
    //Time Complexity - O(n)
    //Space Complexity - O(1)
    public static boolean areAlmostEqual2(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();

        int count = 1;
        int i = 0;
        int j = 0;

       for(int p=0; p<l1; p++){
           if(s1.charAt(p) != s2.charAt(p)){
               count++;
               if (count > 2) {
                   return false;
               } else {
                   if (count == 1) {
                       i = p;
                   } else {
                       j = p;
                   }
               }
           }
       }
       return s1.charAt(i) == s2.charAt(j) && s1.charAt(j) == s2.charAt(i);

    }
}
