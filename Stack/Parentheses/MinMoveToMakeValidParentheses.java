package Stack.Parentheses;

import java.util.Stack;

public class MinMoveToMakeValidParentheses {

    /**
     * 921. Minimum Add to Make Parentheses Valid
     *
     * A parentheses string is valid if and only if:
     *
     * It is the empty string,
     * It can be written as AB (A concatenated with B), where A and B are valid strings, or
     * It can be written as (A), where A is a valid string.
     * You are given a parentheses string s. In one move, you can insert a parenthesis at any position of the string.
     *
     * For example, if s = "()))", you can insert an opening parenthesis to be "(()))" or a closing parenthesis to be "())))".
     * Return the minimum number of moves required to make s valid.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "())"
     * Output: 1
     * Example 2:
     *
     * Input: s = "((("
     * Output: 3
     * */

    public static void main(String[] args) {
        System.out.println(minAddToMakeValid("((("));
    }

    // Solution 1 - Using Stack Approach
    // Time Complexity: O(n), where n is the length of the input string s.
    // Space Complexity: O(n) in the worst case, where n is the length of the input string s.
    public static int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                stack.push(ch);
            } else{
                if(stack.isEmpty() || stack.peek() == ')'){
                    stack.push(ch);
                }
                else{
                    stack.pop();
                }
            }
        }

        return stack.size();
    }

    // Solution 2 - Using Counter Approach
    // Time Complexity: O(n), where n is the length of the input string s.
    // Space Complexity: O(1), as we are using only a few integer variables.
    public static int minAddToMakeValid2(String s) {
        int open = 0, close = 0;

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '(') {
                open++;
            }else {
                if(open > 0) {
                    open--;
                } else {
                    close++;
                }
            }
        }
        return open + close;
    }
}
