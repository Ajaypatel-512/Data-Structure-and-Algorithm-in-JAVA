package String;

import java.util.HashSet;
import java.util.Set;

public class IsomorphicStrings {
    /**
     * 205. Isomorphic Strings
     * Given two strings s and t, determine if they are isomorphic.
     *
     * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
     *
     * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "egg", t = "add"
     *
     * Output: true
     *
     * Explanation:
     *
     * The strings s and t can be made identical by:
     *
     * Mapping 'e' to 'a'.
     * Mapping 'g' to 'd'.
     * Example 2:
     *
     * Input: s = "foo", t = "bar"
     *
     * Output: false
     *
     * Explanation:
     *
     * The strings s and t can not be made identical as 'o' needs to be mapped to both 'a' and 'r'.
     *
     * Example 3:
     *
     * Input: s = "paper", t = "title"
     *
     * Output: true
     * */
    public static void main(String[] args) {
        String s = "egg";
        String t = "add";
//        System.out.println(isIsomorphic(s, t)); // Output: true
//
//        s = "foo";
//        t = "bar";
//        System.out.println(isIsomorphic(s, t)); // Output: false
//
//        s = "paper";
//        t = "title";
//        System.out.println(isIsomorphic(s, t)); // Output: true

        s = "bbbaaaba";
        t = "aaabbbba";
        System.out.println(isIsomorphic2(s, t)); // Output: false
    }

    //Solution 1: Using HashSet to track unique characters
    // Time Complexity: O(n), where n is the length of the strings
    // Space Complexity: O(n), for storing unique characters in the sets
    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        Set<Character> s1 = new HashSet<>();
        Set<Character> s2 = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            s1.add(s.charAt(i));
            s2.add(t.charAt(i));
        }

        if (s1.size() != s2.size()) return false;
        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(s.charAt(i)) != t.indexOf(t.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    //Solution 2 : Using two maps to track character mappings
    //Time Complexity: O(n), where n is the length of the strings
    //Space Complexity: O(n), for storing the mappings in the maps
    public static boolean isIsomorphic2(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] mapS = new int[256];
        int[] mapT = new int[256];

        for (int i = 0; i < s.length(); i++) {
            if (mapS[s.charAt(i)] != mapT[t.charAt(i)]) {
                return false;
            }
            mapS[s.charAt(i)] = i + 1; // Use i + 1 to avoid zero as a valid index
            mapT[t.charAt(i)] = i + 1;
        }
        return true;
    }

    //Solution 3: Using two maps to track character mappings with StringBuilder
    // Time Complexity: O(n), where n is the length of the strings
    // Space Complexity: O(n), for storing the mappings in the maps
    public static boolean isIsomorphic3(String s, String t) {
        if (s.length() != t.length()) return false;

        StringBuilder mapS = new StringBuilder();
        StringBuilder mapT = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            int indexS = mapS.indexOf(String.valueOf(charS));
            int indexT = mapT.indexOf(String.valueOf(charT));

            if (indexS != indexT) {
                return false;
            }

            if (indexS == -1) {
                mapS.append(charS);
                mapT.append(charT);
            }
        }
        return true;
    }


}
