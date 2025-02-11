package String;

import java.util.Stack;

public class RemoveAllOccurrencesOfASubstring {
    /**
     * 1910. Remove All Occurrences of a Substring
     * Given two strings s and part, perform the following operation on s until all occurrences of the substring part are removed:
     *
     * Find the leftmost occurrence of the substring part and remove it from s.
     * Return s after removing all occurrences of part.
     *
     * A substring is a contiguous sequence of characters in a string.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "daabcbaabcbc", part = "abc"
     * Output: "dab"
     * Explanation: The following operations are done:
     * - s = "daabcbaabcbc", remove "abc" starting at index 2, so s = "dabaabcbc".
     * - s = "dabaabcbc", remove "abc" starting at index 4, so s = "dababc".
     * - s = "dababc", remove "abc" starting at index 3, so s = "dab".
     * Now s has no occurrences of "abc".
     * Example 2:
     *
     * Input: s = "axxxxyyyyb", part = "xy"
     * Output: "ab"
     * Explanation: The following operations are done:
     * - s = "axxxxyyyyb", remove "xy" starting at index 4 so s = "axxxyyyb".
     * - s = "axxxyyyb", remove "xy" starting at index 3 so s = "axxyyb".
     * - s = "axxyyb", remove "xy" starting at index 2 so s = "axyb".
     * - s = "axyb", remove "xy" starting at index 1 so s = "ab".
     * Now s has no occurrences of "xy".
     *
     *
     * Constraints:
     *
     * 1 <= s.length <= 1000
     * 1 <= part.length <= 1000
     * s​​​​​​ and part consists of lowercase English letters.
     * */
    public static void main(String[] args) {
        String s = "aabababa";
        String part = "aba";
        System.out.println(removeOccurrences(s, part)); // dab

//        s = "axxxxyyyyb";
//        part = "xy";
//        System.out.println(removeOccurrences(s, part)); // ab
    }

    //Solution 1 - Using Brute Force
    //Time Complexity - O(n*m)
    //Space Complexity - O(1)
    public static String removeOccurrences(String s, String part) {
        while(true){
            int index = s.indexOf(part);
            if(index == -1){
                break;
            }
            s = s.substring(0,index) + s.substring(index + part.length());
        }

        return s;
    }

    //Solution 2 - Using Stack
    //Time Complexity - O(n)
    //Space Complexity - O(1)
    public static String removeOccurrences2(String s, String part) {
        Stack<Character> st = new Stack<>();
        int m = s.length();
        int n = part.length();

        for (int i = 0; i < m; i++) {
            st.push(s.charAt(i));

            if (st.size() >= n && check(st, part, n)) {
                for (int j = 0; j < n; j++) {
                    st.pop();
                }
            }
        }

        StringBuilder result = new StringBuilder();
        while (!st.isEmpty()) {
            result.append(st.pop());
        }

        return result.reverse().toString();
    }

    private static boolean check(Stack<Character> st, String part, int n) {
        Stack<Character> tempSt = new Stack<>();
        tempSt.addAll(st);

        for (int idx = n - 1; idx >= 0; idx--) {
            if (tempSt.peek() != part.charAt(idx)) {
                return false;
            }

            tempSt.pop();
        }

        return true;
    }

    //Solution 3 - Using String As A String
    //Time Complexity - O(n)
    //Space Complexity - O(1)
    public static String removeOccurrences3(String s, String part) {
        StringBuilder result = new StringBuilder();
        int n = part.length();

        for (char ch : s.toCharArray()) {
            result.append(ch);

            if (result.length() >= n && result.substring(result.length() - n).equals(part)) {
                result.delete(result.length() - n, result.length());
            }
        }

        return result.toString();
    }

    //Solution 4 - Using String Replace
    //Time Complexity - O(n)
    //Space Complexity - O(1)
    public static String removeOccurrences4(String s, String part) {
        while (s.contains(part)){
            s = s.replaceFirst(part,"");
        }

        return s;
    }

}
