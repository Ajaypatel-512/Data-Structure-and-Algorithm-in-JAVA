package Arrayss.SlidingWindow;

import java.util.ArrayList;
import java.util.List;

public class CountOfSubstringsContainingEveryVowelAndKConsonantsII {
    /**
     * 3306. Count of Substrings Containing Every Vowel and K Consonants II
     * You are given a string word and a non-negative integer k.
     *
     * Return the total number of substrings of word that contain every vowel ('a', 'e', 'i', 'o', and 'u') at least once and exactly k consonants.
     *
     *
     *
     * Example 1:
     *
     * Input: word = "aeioqq", k = 1
     *
     * Output: 0
     *
     * Explanation:
     *
     * There is no substring with every vowel.
     *
     * Example 2:
     *
     * Input: word = "aeiou", k = 0
     *
     * Output: 1
     *
     * Explanation:
     *
     * The only substring with every vowel and zero consonants is word[0..4], which is "aeiou".
     *
     * Example 3:
     *
     * Input: word = "ieaouqqieaouqq", k = 1
     *
     * Output: 3
     *
     * Explanation:
     *
     * The substrings with every vowel and one consonant are:
     *
     * word[0..5], which is "ieaouq".
     * word[6..11], which is "qieaou".
     * word[7..12], which is "ieaouq".
     *
     *
     * Constraints:
     *
     * 5 <= word.length <= 2 * 105
     * word consists only of lowercase English letters.
     * 0 <= k <= word.length - 5
     * */
    public static void main(String[] args) {
        String word = "aeueio";
        int k = 0;
        System.out.println(countOfSubstrings(word, k));
    }

    //Solution 1 : Brute Force
    //Time Complexity : O(n^2)
    //Space Complexity : O(n^2)
    public static long countOfSubstrings(String word, int k) {
        int n = word.length();
        List<String> subStrings = new ArrayList<>();

        for(int i=0; i<n; i++){
            for(int j=i+1; j<=n; j++){
                String sub = word.substring(i, j);
                subStrings.add(sub);
            }
        }

        int count = 0;
        for(String sub : subStrings){
            if(sub.length() < 5) continue;
            boolean vowel = false;
            if (sub.contains("a") && sub.contains("e") && sub.contains("i") && sub.contains("o") && sub.contains("u")) {
                vowel = true;
            }
            int vowels = 0;
            int consonants = 0;
            for(char c : sub.toCharArray()){
                if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
                    vowels++;
                }else{
                    consonants++;
                }
            }
            if(vowels >= 5 && consonants == k && vowel){
                count++;
            }
        }
        return count;
    }
}
