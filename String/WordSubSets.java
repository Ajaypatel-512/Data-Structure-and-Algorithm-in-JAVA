package String;

import java.util.ArrayList;
import java.util.List;

public class WordSubSets {
    /**
     * 916. Word Subsets
     * You are given two string arrays words1 and words2.
     *
     * A string b is a subset of string a if every letter in b occurs in a including multiplicity.
     *
     * For example, "wrr" is a subset of "warrior" but is not a subset of "world".
     * A string a from words1 is universal if for every string b in words2, b is a subset of a.
     *
     * Return an array of all the universal strings in words1. You may return the answer in any order.
     *
     *
     *
     * Example 1:
     *
     * Input: words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["e","o"]
     * Output: ["facebook","google","leetcode"]
     * Example 2:
     *
     * Input: words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["l","e"]
     * Output: ["apple","google","leetcode"]
     *
     *
     * Constraints:
     *
     * 1 <= words1.length, words2.length <= 104
     * 1 <= words1[i].length, words2[i].length <= 10
     * words1[i] and words2[i] consist only of lowercase English letters.
     * All the strings of words1 are unique.
     * */
    public static void main(String[] args) {
        String[] words1 = {"amazon","apple","facebook","google","leetcode"};
        String[] words2 = {"e","o"};
        System.out.println(wordSubsets(words1, words2));
    }

    //Approach - (Simple storing character frequency in map and checking)
    //T.C : O(n*l1 + m*l2) , n = # of words in words1, l1 = average length of word in words1, similarly m and l2 for words2
    //S.C : O(26) ~= O(1)
    public static List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> result = new ArrayList<>();

        // Step 1: Calculate the maximum frequency requirement for words2
        int[] freq2 = new int[26]; // Frequency array for all characters
        for (String word : words2) {
            int[] temp = new int[26]; // Temporary frequency array for the current word
            for (char ch : word.toCharArray()) {
                temp[ch - 'a']++;
                freq2[ch - 'a'] = Math.max(freq2[ch - 'a'], temp[ch - 'a']);
            }
        }

        // Step 2: Check each word in words1
        for (String word : words1) {
            int[] temp = new int[26]; // Frequency array for the current word
            for (char ch : word.toCharArray()) {
                temp[ch - 'a']++;
            }

            // Check if the word satisfies the universal condition
            if (isSubset(freq2, temp)) {
                result.add(word);
            }
        }

        return result;
    }

    // Helper method to check if freq2 is a subset of temp
    private static boolean isSubset(int[] freq2, int[] temp) {
        for (int i = 0; i < 26; i++) {
            if (temp[i] < freq2[i]) {
                return false; // Not a subset
            }
        }
        return true;
    }
}
