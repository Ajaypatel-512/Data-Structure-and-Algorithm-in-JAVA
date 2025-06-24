package Stack.Parentheses;

import java.util.Stack;

public class ValidParentheses {
    /**
     * 20. Valid Parentheses
     * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
     *
     * An input string is valid if:
     *
     * Open brackets must be closed by the same type of brackets.
     * Open brackets must be closed in the correct order.
     * Every close bracket has a corresponding open bracket of the same type.
     *
     *
     * Example 1:
     *
     * Input: s = "()"
     *
     * Output: true
     *
     * Example 2:
     *
     * Input: s = "()[]{}"
     *
     * Output: true
     *
     * Example 3:
     *
     * Input: s = "(]"
     *
     * Output: false
     *
     * Example 4:
     *
     * Input: s = "([])"
     *
     * Output: true
     *
     *
     *
     * Constraints:
     *
     * 1 <= s.length <= 104
     * s consists of parentheses only '()[]{}'.
     * */
    public static void main(String[] args) {
        String s1 = "()";
        String s2 = "()[]{}";
        String s3 = "(]";
        String s4 = "([])";
        String s5 = "([)]";

        System.out.println(isValid(s1)); // true
        System.out.println(isValid(s2)); // true
        System.out.println(isValid(s3)); // false
        System.out.println(isValid(s4)); // true

        System.out.println(isValidCount(s1)); // true
        System.out.println(isValidCount(s2)); // true
        System.out.println(isValidCount(s3)); // false
        System.out.println(isValidCount(s4)); // true
        System.out.println(isValidCount(s5)); // true
    }

    //Solution 1: Using Stack
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    //Solution 2: Using Count
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public static boolean isValidCount(String s) {
        int count1 = 0; // count for '('
        int count2 = 0; // count for '{'
        int count3 = 0; // count for '['
        for (char c : s.toCharArray()) {
            if (c == '(') {
                count1++;
            } else if (c == ')') {
                count1--;
            } else if (c == '{') {
                count2++;
            } else if (c == '}') {
                count2--;
            } else if (c == '[') {
                count3++;
            } else if (c == ']') {
                count3--;
            }
            // If any count goes negative, it means there's a closing bracket without a matching opening bracket
            if (count1 < 0 || count2 < 0 || count3 < 0) {
                return false;
            }
        }
        // All counts should be zero for the string to be valid
        return count1 == 0 && count2 == 0 && count3 == 0;
    }
}
