package Stack.Parentheses;

import java.util.Stack;

public class ParseABooleanExp {

    /**
     * 1106. Parsing A Boolean Expression
     *
     * A boolean expression is an expression that evaluates to either true or false. It can be in one of the following shapes:
     *
     * 't' that evaluates to true.
     * 'f' that evaluates to false.
     * '!(subExpr)' that evaluates to the logical NOT of the inner expression subExpr.
     * '&(subExpr1, subExpr2, ..., subExprn)' that evaluates to the logical AND of the inner expressions subExpr1, subExpr2, ..., subExprn where n >= 1.
     * '|(subExpr1, subExpr2, ..., subExprn)' that evaluates to the logical OR of the inner expressions subExpr1, subExpr2, ..., subExprn where n >= 1.
     * Given a string expression that represents a boolean expression, return the evaluation of that expression.
     *
     * It is guaranteed that the given expression is valid and follows the given rules.
     *
     * Example 1:
     *
     * Input: expression = "&(|(f))"
     * Output: false
     * Explanation:
     * First, evaluate |(f) --> f. The expression is now "&(f)".
     * Then, evaluate &(f) --> f. The expression is now "f".
     * Finally, return false.
     * Example 2:
     *
     * Input: expression = "|(f,f,f,t)"
     * Output: true
     * Explanation: The evaluation of (false OR false OR false OR true) is true.
     * Example 3:
     *
     * Input: expression = "!(&(f,t))"
     * Output: true
     * Explanation:
     * First, evaluate &(f,t) --> (false AND true) --> false --> f. The expression is now "!(f)".
     * Then, evaluate !(f) --> NOT false --> true. We return true.
     * */

    public static void main(String[] args) {
        String exp = "|(&(t,f,t),!(t))";
        System.out.println(parseBoolExpr(exp));
    }

    //Solution 1 Using Stack
    public static boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack<>();
        boolean hasT = false;
        boolean hasF = false;

        for (char c:expression.toCharArray()){
            if (c != ')')
                stack.push(c);
            else {
                hasT = false;
                hasF = false;
                while (stack.peek() != '('){
                    char val = stack.pop();
                    if (val == 'f')
                        hasF = true;
                    else if (val == 't')
                        hasT = true;
                }
                stack.pop();
                char operator = stack.pop();

                if (operator == '&')
                    stack.push(hasF ? 'f' : 't');
                if (operator == '|')
                    stack.push(hasT ? 't' : 'f');
                if (operator == '!')
                    stack.push(hasT ? 'f' : 't');
            }
        }
        return stack.pop() == 't';
    }
}
