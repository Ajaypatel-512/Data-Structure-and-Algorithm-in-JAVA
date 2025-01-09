package String.Prefix;

public class CountingWordsWithAGivenPrefix {
    /**
     * 2185. Counting Words With a Given Prefix
     * You are given an array of strings words and a string pref.
     *
     * Return the number of strings in words that contain pref as a prefix.
     *
     * A prefix of a string s is any leading contiguous substring of s.
     *
     *
     *
     * Example 1:
     *
     * Input: words = ["pay","attention","practice","attend"], pref = "at"
     * Output: 2
     * Explanation: The 2 strings that contain "at" as a prefix are: "attention" and "attend".
     * Example 2:
     *
     * Input: words = ["leetcode","win","loops","success"], pref = "code"
     * Output: 0
     * Explanation: There are no strings that contain "code" as a prefix.
     *
     *
     * Constraints:
     *
     * 1 <= words.length <= 100
     * 1 <= words[i].length, pref.length <= 100
     * words[i] and pref consist of lowercase English letters.
     * */
    public static void main(String[] args) {
        String[] words1 = {"pay","attention","practice","attend"};
        String pref1 = "at";
        System.out.println(prefixCount(words1, pref1));
    }

    //Approach-1 Brute Force
    //T.C : O(n^m), where n = number of words, m = length of pref
    //S.C : O(n^m)
    public static int prefixCount(String[] words, String pref) {
        int count = 0;
        for (String word : words) {
            if (word.startsWith(pref)) {
                count++; // Found a string with pref as prefix
            }
        }
        return count;
    }

}
