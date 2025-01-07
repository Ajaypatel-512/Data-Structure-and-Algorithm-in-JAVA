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
}
