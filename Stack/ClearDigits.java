package Stack;

import java.util.Stack;

public class ClearDigits {
    /**
     * You are given a string s.
     *
     * Your task is to remove all digits by doing this operation repeatedly:
     *
     * Delete the first digit and the closest non-digit character to its left.
     * Return the resulting string after removing all digits.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "abc"
     *
     * Output: "abc"
     *
     * Explanation:
     *
     * There is no digit in the string.
     *
     * Example 2:
     *
     * Input: s = "cb34"
     *
     * Output: ""
     *
     * Explanation:
     *
     * First, we apply the operation on s[2], and s becomes "c4".
     *
     * Then we apply the operation on s[1], and s becomes "".
     *
     *
     *
     * Constraints:
     *
     * 1 <= s.length <= 100
     * s consists only of lowercase English letters and digits.
     * The input is generated such that it is possible to delete all digits.
     * */
    public static void main(String[] args) {
        String s = "abc";
        System.out.println(clearDigits(s));
    }

    //Solution 1 : Using Stack
    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public static String clearDigits(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();


        for(int i=0; i<n; i++){
            if(s.charAt(i) == '0' || s.charAt(i) == '1' || s.charAt(i) == '2' || s.charAt(i) == '3' ||
                    s.charAt(i) == '4' || s.charAt(i) == '5' || s.charAt(i) == '6' || s.charAt(i) == '7' ||
                    s.charAt(i) == '8' || s.charAt(i) == '9'){
                st.pop();
            } else {
                st.push(s.charAt(i));
            }
        }

        if(!st.isEmpty()){
            StringBuilder sb = new StringBuilder();
            while (!st.isEmpty()){
                sb.append(st.pop());
            }
            return sb.reverse().toString();
        }
        return "";

    }
}
