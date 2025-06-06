package String;

import java.util.*;

public class SortCharactersByFrequency {
    /**
     * 451. Sort Characters By Frequency
     * Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.
     *
     * Return the sorted string. If there are multiple answers, return any of them.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "tree"
     * Output: "eert"
     * Explanation: 'e' appears twice while 'r' and 't' both appear once.
     * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
     * Example 2:
     *
     * Input: s = "cccaaa"
     * Output: "aaaccc"
     * Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
     * Note that "cacaca" is incorrect, as the same characters must be together.
     * Example 3:
     *
     * Input: s = "Aabb"
     * Output: "bbAa"
     * Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
     * Note that 'A' and 'a' are treated as two different characters.
     *
     *
     * Constraints:
     *
     * 1 <= s.length <= 5 * 105
     * s consists of uppercase and lowercase English letters and digits.
     * */
    public static void main(String[] args) {
        String s = "tree";
        System.out.println(frequencySort(s)); // Output: "eert" or "eetr"

        s = "cccaaa";
        System.out.println(frequencySort(s)); // Output: "aaaccc" or "cccaaa"

        s = "Aabb";
        System.out.println(frequencySort(s)); // Output: "bbAa" or "bbaA"
    }

    //Solution 1 : Using HashMap and sorting
    // Time Complexity: O(n log n) due to sorting
    // Space Complexity: O(n) for storing character frequencies
    public static String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        List<Character> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (a, b) -> map.get(b) - map.get(a));

        StringBuilder sb = new StringBuilder();
        for (char c : list) {
            sb.append(String.valueOf(c).repeat(map.get(c)));
        }
        return sb.toString();
    }
}
