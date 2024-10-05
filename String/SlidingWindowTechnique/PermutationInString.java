package String.SlidingWindowTechnique;

import java.util.Arrays;

public class PermutationInString {

    /**
     * 567. Permutation in String
     * Given two strings s1 and s2, return true if s2 contains a
     * permutation
     *  of s1, or false otherwise.
     *
     * In other words, return true if one of s1's permutations is the substring of s2.
     *
     * Example 1:
     *
     * Input: s1 = "ab", s2 = "eidbaooo"
     * Output: true
     * Explanation: s2 contains one permutation of s1 ("ba").
     * Example 2:
     *
     * Input: s1 = "ab", s2 = "eidboaoo"
     * Output: false
     *
     *
     * Constraints:
     *
     * 1 <= s1.length, s2.length <= 104
     * s1 and s2 consist of lowercase English letters.
     *
     * */
    public static void main(String[] args) {
        //Approach 1
        System.out.println(checkInclusion("cab","dbabcd"));

        //Approach 2
        System.out.println(checkInclusion2("cab","dbabcd"));
    }

    //SOLUTION 1 - Using Sliding Window Technique O(alphabet char * s2Len)
    public static boolean checkInclusion(String s1, String s2) {
        int[] s1Hash = new int[26];
        int[] s2Hash = new int[26];

        int s1Len = s1.length();
        int s2Len = s2.length();

        if (s1Len > s2Len){
            return false;
        }

        int left = 0;
        int right = 0;

        while (right < s1Len){
            s1Hash[s1.charAt(right)-'a']++;
            s2Hash[s2.charAt(right)-'a']++;
            right++;
        }
        right--;

        while (right < s2Len){
            if (Arrays.equals(s1Hash,s2Hash)){
                return true;
            }
            right++;
            if (right != s2Len){
                s2Hash[s2.charAt(right)-'a']++;
            }
            s2Hash[s2.charAt(left)-'a']--;
            left++;
        }
        return false;
    }

    //SOLUTION 2 - Using Sliding Window Technique O(s1Len + s2Len).

    public static boolean checkInclusion2(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if(len1 > len2) return false;

        int count[] = new int[26];
        for(int i=0; i<len1; i++){
            count[s1.charAt(i)-'a']++;
        }
        for(int i=0; i<len2; i++){
            count[s2.charAt(i)-'a']--;
            if(i-len1>=0){
                count[s2.charAt(i-len1)-'a']++;
            }
            if(allZero(count)) {
                return true;
            }
        }
        return false;
    }
    public static boolean allZero(int[] count){
        for(int i=0; i<26; i++){
            if(count[i]!=0) return false;
        }
        return true;
    }

}
