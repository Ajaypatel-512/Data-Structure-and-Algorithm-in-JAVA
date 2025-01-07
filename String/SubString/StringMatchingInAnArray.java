package String.SubString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringMatchingInAnArray {
    /**
     * 1408. String Matching in an Array
     * Given an array of string words, return all strings in words that is a substring of another word. You can return the answer in any order.
     *
     * A substring is a contiguous sequence of characters within a string
     *
     *
     *
     * Example 1:
     *
     * Input: words = ["mass","as","hero","superhero"]
     * Output: ["as","hero"]
     * Explanation: "as" is substring of "mass" and "hero" is substring of "superhero".
     * ["hero","as"] is also a valid answer.
     * Example 2:
     *
     * Input: words = ["leetcode","et","code"]
     * Output: ["et","code"]
     * Explanation: "et", "code" are substring of "leetcode".
     * Example 3:
     *
     * Input: words = ["blue","green","bu"]
     * Output: []
     * Explanation: No string of words is substring of another string.
     *
     *
     * Constraints:
     *
     * 1 <= words.length <= 100
     * 1 <= words[i].length <= 30
     * words[i] contains only lowercase English letters.
     * All the strings of words are unique.
     * */
    public static void main(String[] args) {
        String[] words3 = {"leetcoder","leetcode","od","hamlet","am"};
        System.out.println(stringMatching(words3));
    }

    //Solution 1 : Brute Force
    //Time Complexity: O(n^2)
    //Space Complexity: O(n)
    public static List<String> stringMatching(String[] words) {
        int n = words.length;
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        List<String> result = new ArrayList<>();

        for(int i=0; i<n; i++){
            String word = words[i];
            for (int j=i+1; j<n; j++){
                if(words[j].contains(word)){
                    result.add(word);
                    break;
                }
            }
        }
        return result;
    }


    //Solution 2 : using KMP Algorithm
    //Time Complexity: O(m*n^2), m = length of longest string in words, n = size of words
    //Space Complexity: O(m)
    public static List<String> stringMatching2(String[] words) {
        int n = words.length;
        List<String> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if(searchKMP(words[i],words[j])){
                    result.add(words[i]);
                    break;
                }
            }
        }
        return result;
    }

    private static void computeLPS(String pattern, int[] lps) {
        int M = pattern.length();
        int len = 0; // Length of the previous longest prefix & suffix

        lps[0] = 0; // Because there is no proper suffix and prefix of pattern[0..0]

        int i = 1;
        while (i < M) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1]; // You can also write, len = len-1;
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }

    private static boolean searchKMP(String pat, String txt) {
        int N = txt.length();
        int M = pat.length();

        // Create an LPS array to store the longest proper prefix which is also a suffix
        // lps[i] = the longest proper prefix of pat[0..i] which is also a suffix of pat[0..i].
        int[] lps = new int[M];
        computeLPS(pat, lps);

        int i = 0; // Index for text
        int j = 0; // Index for pattern

        while (i < N) {
            if (pat.charAt(j) == txt.charAt(i)) {
                i++;
                j++;
            }

            if (j == M) {
                // result.add(i-j+1); // Pattern found at index i-j+1 (If you have to return 1 Based indexing, that's why added + 1)
                // j = lps[j - 1];
                return true;
            } else if (i < N && pat.charAt(j) != txt.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return false;
    }

}
