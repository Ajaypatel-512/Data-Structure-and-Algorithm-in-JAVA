package Arrayss.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class NumberOfSubstringsContainingAllThreeCharacters {
    /**
     * 1358. Number of Substrings Containing All Three Characters
     * Given a string s consisting only of characters a, b and c.
     *
     * Return the number of substrings containing at least one occurrence of all these characters a, b and c.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "abcabc"
     * Output: 10
     * Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again).
     * Example 2:
     *
     * Input: s = "aaacb"
     * Output: 3
     * Explanation: The substrings containing at least one occurrence of the characters a, b and c are "aaacb", "aacb" and "acb".
     * Example 3:
     *
     * Input: s = "abc"
     * Output: 1
     *
     *
     * Constraints:
     *
     * 3 <= s.length <= 5 x 10^4
     * s only consists of a, b or c characters.
     * */
    public static void main(String[] args) {
        String s = "abcabc";
        System.out.println(numberOfSubstrings(s));
    }

    //Solution 1 : Brute Force
    //Time Complexity : O(n^2)
    //Space Complexity : O(1)
    public static int numberOfSubstrings(String s) {
        int count = 0;
        int n = s.length();

        for (int i=0; i<n-2; i++){
            for (int j=i+1; j<=n; j++){
                String substring = s.substring(i, j);
                if (substring.contains("a") && substring.contains("b") && substring.contains("c")){
                    count++;
                }
            }
        }
        return count;
    }

    //Solution 2 : Sliding Window
    //Time Complexity : O(n)
    //Space Complexity : O(1)
    public static int numberOfSubstrings2(String s) {
        int result = 0;
        int n = s.length();
        int[] map = new int[3];

        int i=0;
        int j=0;

        while(j<n){
            char c = s.charAt(j);
            map[c-'a']++;

            while(map[0] > 0 && map[1] > 0 && map[2] > 0){
                result += n-j;

                map[s.charAt(i)-'a']--;
                i++;
            }
            j++;
        }

        return result;
    }


}
