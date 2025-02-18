package Stack;

import java.util.Stack;

public class ConstructSmallestNumberFromDIString {
    /**
     * 2375. Construct Smallest Number From DI String
     * You are given a 0-indexed string pattern of length n consisting of the characters 'I' meaning increasing and 'D' meaning decreasing.
     *
     * A 0-indexed string num of length n + 1 is created using the following conditions:
     *
     * num consists of the digits '1' to '9', where each digit is used at most once.
     * If pattern[i] == 'I', then num[i] < num[i + 1].
     * If pattern[i] == 'D', then num[i] > num[i + 1].
     * Return the lexicographically smallest possible string num that meets the conditions.
     *
     *
     *
     * Example 1:
     *
     * Input: pattern = "IIIDIDDD"
     * Output: "123549876"
     * Explanation:
     * At indices 0, 1, 2, and 4 we must have that num[i] < num[i+1].
     * At indices 3, 5, 6, and 7 we must have that num[i] > num[i+1].
     * Some possible values of num are "245639871", "135749862", and "123849765".
     * It can be proven that "123549876" is the smallest possible num that meets the conditions.
     * Note that "123414321" is not possible because the digit '1' is used more than once.
     * Example 2:
     *
     * Input: pattern = "DDD"
     * Output: "4321"
     * Explanation:
     * Some possible values of num are "9876", "7321", and "8742".
     * It can be proven that "4321" is the smallest possible num that meets the conditions.
     *
     *
     * Constraints:
     *
     * 1 <= pattern.length <= 8
     * pattern consists of only the letters 'I' and 'D'.
     * */
    public static void main(String[] args) {
        String pattern = "IIIDIDDD";
        System.out.println(smallestNumber(pattern));
    }

    //Solution 1 : Simple brute force
    //Time complexity: O(n * (n+1)!), (n+1)! permutations and n for matchesPattern()
    //Space complexity: O(n+1) for result
    public static String smallestNumber(String pattern) {
        int n = pattern.length();
        char[] num = new char[n + 1];

        // Initialize num as "1234..." (n+1 characters)
        for (int i = 0; i <= n; i++) {
            num[i] = (char) ('1' + i);
        }

        // Generate permutations until we find one that matches the pattern
        while (!matchesPattern(new String(num), pattern)) {
            nextPermutation(num);
        }

        return new String(num);
    }

    private static boolean matchesPattern(String num, String pattern) {
        for (int i = 0; i < pattern.length(); i++) {
            if ((pattern.charAt(i) == 'I' && num.charAt(i) > num.charAt(i + 1)) ||
                    (pattern.charAt(i) == 'D' && num.charAt(i) < num.charAt(i + 1))) {
                return false;
            }
        }
        return true;
    }

    private static void nextPermutation(char[] num) {
        int i = num.length - 2;
        while (i >= 0 && num[i] >= num[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = num.length - 1;
            while (num[j] <= num[i]) {
                j--;
            }
            swap(num, i, j);
        }
        reverse(num, i + 1);
    }
    private static void swap(char[] num, int i, int j) {
        char temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }

    private static void reverse(char[] num, int start) {
        int end = num.length - 1;
        while (start < end) {
            swap(num, start++, end--);
        }
    }

    //Solution 2 : Using Stack
    //Time complexity: O(n)
    //Space complexity: O(n) for result
    public static String smallestNumber2(String pattern) {
        int n = pattern.length();
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int counter = 1;

        for (int i = 0; i <= n; i++) {
            stack.push((char) ('0' + counter++)); // Push the next number

            if (i == n || pattern.charAt(i) == 'I') {
                while (!stack.isEmpty()) {
                    result.append(stack.pop());
                }
            }
        }

        return result.toString();
    }
}
