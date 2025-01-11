package String;

public class ConstructKPalindromString {
    /**
     * 1400. Construct K Palindrome Strings
     * Given a string s and an integer k, return true if you can use all the characters in s to construct k palindrome strings or false otherwise.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "annabelle", k = 2
     * Output: true
     * Explanation: You can construct two palindromes using all characters in s.
     * Some possible constructions "anna" + "elble", "anbna" + "elle", "anellena" + "b"
     * Example 2:
     *
     * Input: s = "leetcode", k = 3
     * Output: false
     * Explanation: It is impossible to construct 3 palindromes using all the characters of s.
     * Example 3:
     *
     * Input: s = "true", k = 4
     * Output: true
     * Explanation: The only possible solution is to put each character in a separate string.
     *
     *
     * Constraints:
     *
     * 1 <= s.length <= 105
     * s consists of lowercase English letters.
     * 1 <= k <= 105
     * */
    public static void main(String[] args) {
        ConstructKPalindromString obj = new ConstructKPalindromString();
        String s = "annabelle";
        int k = 2;
        System.out.println(obj.canConstruct(s, k));
    }

    //Approach - (Using the fact that odd frequency characters count control the palindromes count)
    //T.C : O(n)
    //S.C : O(26) ~ O(1)
    public boolean canConstruct(String s, int k) {
        int n = s.length();

        if(n < k) {
            return false;
        }

        if(n == k) {
            return true;
        }

        int[] vec = new int[26];
        for(char ch : s.toCharArray()) {
            vec[ch-'a']++;
        }

        int oddFreqCharCount = 0;

        for(int i = 0; i < 26; i++) {
            if(vec[i]%2 != 0) {
                oddFreqCharCount++;
            }
        }

        return oddFreqCharCount <= k;
    }
    
}
