package Stack;

import java.util.Stack;

public class RemoveKDigits {
    /**
     * 402. Remove K Digits
     * Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.
     *
     *
     *
     * Example 1:
     *
     * Input: num = "1432219", k = 3
     * Output: "1219"
     * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
     * Example 2:
     *
     * Input: num = "10200", k = 1
     * Output: "200"
     * Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
     * Example 3:
     *
     * Input: num = "10", k = 2
     * Output: "0"
     * Explanation: Remove all the digits from the number and it is left with nothing which is 0.
     *
     *
     * Constraints:
     *
     * 1 <= k <= num.length <= 105
     * num consists of only digits.
     * num does not have any leading zeros except for the zero itself.
     * */
    public static void main(String[] args) {
        String num = "1432219";
        int k = 3;
        System.out.println(removeKdigits(num, k)); // Output: "1219"

        num = "10200";
        k = 1;
        System.out.println(removeKdigits(num, k)); // Output: "200"

        num = "10";
        k = 2;
        System.out.println(removeKdigits(num, k)); // Output: "0"
    }

    //Solution 1: Using Stack
    // Time Complexity: O(n), where n is the length of the input string num.
    // Space Complexity: O(n), for the stack used to store the digits.
    public static String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        int n = num.length();

        for (int i=0; i<n; i++){
            while (!stack.isEmpty() && k >0 && (stack.peek() - '0') > (num.charAt(i)-'0')) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }
        // If k is still greater than 0, remove the last k digits
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }
        if (stack.isEmpty()) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        // Reverse the string to get the correct order
        sb.reverse();
        // Remove leading zeros
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}
