package String;

import java.util.Stack;

public class RemoveOutermostParentheses {
    /**
     * 1021. Remove Outermost Parentheses
     * A valid parentheses string is either empty "", "(" + A + ")", or A + B, where A and B are valid parentheses strings, and + represents string concatenation.
     *
     * For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings.
     * A valid parentheses string s is primitive if it is nonempty, and there does not exist a way to split it into s = A + B, with A and B nonempty valid parentheses strings.
     *
     * Given a valid parentheses string s, consider its primitive decomposition: s = P1 + P2 + ... + Pk, where Pi are primitive valid parentheses strings.
     *
     * Return s after removing the outermost parentheses of every primitive string in the primitive decomposition of s.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "(()())(())"
     * Output: "()()()"
     * Explanation:
     * The input string is "(()())(())", with primitive decomposition "(()())" + "(())".
     * After removing outer parentheses of each part, this is "()()" + "()" = "()()()".
     * Example 2:
     *
     * Input: s = "(()())(())(()(()))"
     * Output: "()()()()(())"
     * Explanation:
     * The input string is "(()())(())(()(()))", with primitive decomposition "(()())" + "(())" + "(()(()))".
     * After removing outer parentheses of each part, this is "()()" + "()" + "()(())" = "()()()()(())".
     * Example 3:
     *
     * Input: s = "()()"
     * Output: ""
     * Explanation:
     * The input string is "()()", with primitive decomposition "()" + "()".
     * After removing outer parentheses of each part, this is "" + "" = "".
     *
     *
     * Constraints:
     *
     * 1 <= s.length <= 105
     * s[i] is either '(' or ')'.
     * s is a valid parentheses string.
     * */
    public static void main(String[] args) {
        String s = "(()())(())";
        System.out.println(removeOuterParentheses(s));
    }

    //Solution 1: Brute Force
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public static String removeOuterParentheses(String s){
        int n = s.length();
        StringBuilder result = new StringBuilder();
        int count = 0;

        for (int i=0; i<n; i++){
            char c = s.charAt(i);
            if (c == '(') {
                if (count > 0) {
                    result.append(c); // Append only if it's not the outermost '('
                }
                count++;
            } else {
                count--;
                if (count > 0) {
                    result.append(c); // Append only if it's not the outermost ')'
                }
            }
        }
        return result.toString();
    }

    //Solution 2: Using Stack
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public static String removeOuterParentheses2(String s) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(ch);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    result.append(s.substring(start + 1, i));
                    start = i + 1;
                }
            }
        }
        return result.toString();
    }

}
