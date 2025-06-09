package String;

import java.util.Stack;

public class MaximumNestingDepthOfTheParentheses {
  /**
   * Given a valid parentheses string s, return the nesting depth of s. The nesting depth is the maximum number of nested parentheses.
   *
   *
   *
   * Example 1:
   *
   * Input: s = "(1+(2*3)+((8)/4))+1"
   *
   * Output: 3
   *
   * Explanation:
   *
   * Digit 8 is inside of 3 nested parentheses in the string.
   *
   * Example 2:
   *
   * Input: s = "(1)+((2))+(((3)))"
   *
   * Output: 3
   *
   * Explanation:
   *
   * Digit 3 is inside of 3 nested parentheses in the string.
   *
   * Example 3:
   *
   * Input: s = "()(())((()()))"
   *
   * Output: 3
   *
   *
   *
   * Constraints:
   *
   * 1 <= s.length <= 100
   * s consists of digits 0-9 and characters '+', '-', '*', '/', '(', and ')'.
   * It is guaranteed that parentheses expression s is a VPS.
   * */
    public static void main(String[] args) {
        String s = "(1+(2*3)+((8)/4))+1";
        System.out.println(maxDepth(s)); // Output: 3

        s = "(1)+((2))+(((3)))";
        System.out.println(maxDepth(s)); // Output: 3

        s = "()(())((()()))";
        System.out.println(maxDepth(s)); // Output: 3
    }

    //Solution 1: Brute Force
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public static int maxDepth(String s) {
        int depth = 0;
        int count = 0;
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            }
            depth = Math.max(depth, count);
            if (s.charAt(i) == ')') {
                count--;
            }
        }
        return depth;
    }

    //Solution 2: Stack
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public static int maxDepthStack(String s) {
        Stack<Character> stack = new Stack<>();
        int maxDepth = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                maxDepth = Math.max(maxDepth, stack.size());
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
        }
        return maxDepth;
    }
}
