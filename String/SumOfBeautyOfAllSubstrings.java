package String;

public class SumOfBeautyOfAllSubstrings {
    /**
     * 1781. Sum of Beauty of All Substrings
     * The beauty of a string is the difference in frequencies between the most frequent and least frequent characters.
     *
     * For example, the beauty of "abaacc" is 3 - 1 = 2.
     * Given a string s, return the sum of beauty of all of its substrings.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "aabcb"
     * Output: 5
     * Explanation: The substrings with non-zero beauty are ["aab","aabc","aabcb","abcb","bcb"], each with beauty equal to 1.
     * Example 2:
     *
     * Input: s = "aabcbaa"
     * Output: 17
     *
     *
     * Constraints:
     *
     * 1 <= s.length <= 500
     * s consists of only lowercase English letters.
     * */
    public static void main(String[] args) {
        String s = "aabcb";
        System.out.println("Sum of beauty of all substrings: " + beautySum(s)); // Output: 5

        s = "aabcbaa";
        System.out.println("Sum of beauty of all substrings: " + beautySum(s)); // Output: 17
    }

    //Solution 1: Brute Force Approach
    // Time Complexity: O(n^3), where n is the length of the string.
    // Space Complexity: O(1), since we are using a fixed-size array for frequency counts.
    public static int beautySum(String s) {
        int totalBeauty = 0;

        for (int i = 0; i < s.length(); i++) {
            int[] freq = new int[26];

            for (int j = i; j < s.length(); j++) {
                freq[s.charAt(j) - 'a']++;

                int maxFreq = 0, minFreq = Integer.MAX_VALUE;
                for (int f : freq) {
                    if (f > 0) {
                        maxFreq = Math.max(maxFreq, f);
                        minFreq = Math.min(minFreq, f);
                    }
                }

                totalBeauty += (maxFreq - minFreq);
            }
        }

        return totalBeauty;
    }
}
