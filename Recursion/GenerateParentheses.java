package Recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParentheses {
    /**
     * 22. Generate Parentheses
     * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
     *
     *
     *
     * Example 1:
     *
     * Input: n = 3
     * Output: ["((()))","(()())","(())()","()(())","()()()"]
     * Example 2:
     *
     * Input: n = 1
     * Output: ["()"]
     *
     *
     * Constraints:
     *
     * 1 <= n <= 8
     * */
    public static void main(String[] args) {
        int n = 3;
        List<String> result = generateParenthesis(n);
        System.out.println(result);
    }

    //Solution 1: Using backtracking to generate all combinations of parentheses
    // Time Complexity: O(2^(2n)), Space Complexity: O(n)
    //Space Complexity is O(n) because of the recursion stack
    public static List<String> generateParenthesis(int n) {
       List<String> result = new ArrayList<>();
        generateParenthesisHelper("",n,0, result);
        return result;
    }

    private static void generateParenthesisHelper(String curr, int n, int length, List<String> result) {
        if (length == 2 * n) {
            if (isValid(curr)) {
                result.add(curr);
            }
            return;
        }
        curr += '(';
        generateParenthesisHelper(curr, n, length + 1, result);
        curr = curr.substring(0, curr.length() - 1);

        curr += ')';
        generateParenthesisHelper(curr, n, length + 1, result);
    }

    private static boolean isValid(String s){
        int sum = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(')
                sum++;
            else
                sum--;
            if (sum < 0)
                return false;
        }
        return sum == 0;
    }
}
