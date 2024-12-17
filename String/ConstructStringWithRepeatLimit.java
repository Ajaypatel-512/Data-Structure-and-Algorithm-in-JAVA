package String;

import java.util.PriorityQueue;

public class ConstructStringWithRepeatLimit {
    /**
     * 2182. Construct String With Repeat Limit
     * You are given a string s and an integer repeatLimit. Construct a new string repeatLimitedString using the characters of s such that no letter appears more than repeatLimit times in a row. You do not have to use all characters from s.
     *
     * Return the lexicographically largest repeatLimitedString possible.
     *
     * A string a is lexicographically larger than a string b if in the first position where a and b differ, string a has a letter that appears later in the alphabet than the corresponding letter in b. If the first min(a.length, b.length) characters do not differ, then the longer string is the lexicographically larger one.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "cczazcc", repeatLimit = 3
     * Output: "zzcccac"
     * Explanation: We use all of the characters from s to construct the repeatLimitedString "zzcccac".
     * The letter 'a' appears at most 1 time in a row.
     * The letter 'c' appears at most 3 times in a row.
     * The letter 'z' appears at most 2 times in a row.
     * Hence, no letter appears more than repeatLimit times in a row and the string is a valid repeatLimitedString.
     * The string is the lexicographically largest repeatLimitedString possible so we return "zzcccac".
     * Note that the string "zzcccca" is lexicographically larger but the letter 'c' appears more than 3 times in a row, so it is not a valid repeatLimitedString.
     * Example 2:
     *
     * Input: s = "aababab", repeatLimit = 2
     * Output: "bbabaa"
     * Explanation: We use only some of the characters from s to construct the repeatLimitedString "bbabaa".
     * The letter 'a' appears at most 2 times in a row.
     * The letter 'b' appears at most 2 times in a row.
     * Hence, no letter appears more than repeatLimit times in a row and the string is a valid repeatLimitedString.
     * The string is the lexicographically largest repeatLimitedString possible so we return "bbabaa".
     * Note that the string "bbabaaa" is lexicographically larger but the letter 'a' appears more than 2 times in a row, so it is not a valid repeatLimitedString.
     *
     *
     * Constraints:
     *
     * 1 <= repeatLimit <= s.length <= 105
     * s consists of lowercase English letters.
     * */
    public static void main(String[] args) {
        String s = "cczazcc";
        int repeatLimit = 3;
        System.out.println(repeatLimitedString2(s,repeatLimit));
    }

    //Solution 1 Using frequency
    //T.C : O(n + 26)
    //S.C : O(26)
    public static String repeatLimitedString(String s, int repeatLimit) {
        int[] frequency = new int[26];

        for (char ch : s.toCharArray()) {
            frequency[ch - 'a']++;
        }
        StringBuilder result = new StringBuilder();

        int i = 25;
        while (i>=0){
            if (frequency[i] == 0){
                i--;
                continue;
            }
            char ch = (char) ('a' + i);
            int freq = Math.min(frequency[i],repeatLimit);

            for (int j=0; j< freq; j++){
                result.append(ch);
            }
            frequency[i] -= freq;
            if (frequency[i] > 0){
                int j = i-1;
                while (j >= 0 && frequency[j] == 0){
                    j--;
                }

                if (j < 0){
                    break;
                }

                char chs = (char) ('a'+j);
                result.append(chs);
                frequency[j]--;
            }
        }
        return result.toString();
    }

    //Solution 2 Using Max Heap
    //T.C : O(n + log26)
    //S.C : O(26)
    public static String repeatLimitedString2(String s, int repeatLimit) {
        int[] frequency = new int[26];
        for (char ch : s.toCharArray()) {
            frequency[ch - 'a']++;
        }

        PriorityQueue<Character> heap = new PriorityQueue<>((a,b) -> b-a);
        for (int i=0; i<frequency.length; i++){
            if (frequency[i] > 0){
                heap.offer((char) ('a'+i));
            }
        }

        StringBuilder result = new StringBuilder();

        while (!heap.isEmpty()){
            char ch = heap.poll();
            int freq = Math.min(frequency[ch-'a'],repeatLimit);

            for (int j=0; j< freq; j++){
                result.append(ch);
            }
            frequency[ch - 'a'] -= freq;

            if (frequency[ch-'a'] >0 && !heap.isEmpty()){
                char nextChar = heap.poll();
                result.append(nextChar);
                frequency[nextChar-'a']--;

                if (frequency[nextChar-'a'] > 0){
                    heap.offer(nextChar);
                }

                heap.offer(ch);
            }
        }

        return result.toString();
    }
}
