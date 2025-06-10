package String;

public class CountAndSay {

    /**
     * The count-and-say sequence is a sequence of digit strings defined by the recursive formula:
     *
     * countAndSay(1) = "1"
     * countAndSay(n) is the run-length encoding of countAndSay(n - 1).
     * Run-length encoding (RLE) is a string compression method that works by replacing consecutive identical characters (repeated 2 or more times) with the concatenation of the character and the number marking the count of the characters (length of the run). For example, to compress the string "3322251" we replace "33" with "23", replace "222" with "32", replace "5" with "15" and replace "1" with "11". Thus the compressed string becomes "23321511".
     *
     * Given a positive integer n, return the nth element of the count-and-say sequence.
     *
     *
     *
     * Example 1:
     *
     * Input: n = 4
     *
     * Output: "1211"
     *
     * Explanation:
     *
     * countAndSay(1) = "1"
     * countAndSay(2) = RLE of "1" = "11"
     * countAndSay(3) = RLE of "11" = "21"
     * countAndSay(4) = RLE of "21" = "1211"
     * Example 2:
     *
     * Input: n = 1
     *
     * Output: "1"
     *
     * Explanation:
     *
     * This is the base case.
     *
     * */

    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }

    //Solution 1: Recursive approach
    // Time Complexity: O(2^n) in the worst case, where n is the input number.
    // Space Complexity: O(n) for the recursive call stack and the result string.
    public static String countAndSay(int n) {
        if (n == 1) return "1";

        String say = countAndSay(n - 1);
        StringBuilder res = new StringBuilder();
        int count = 1;

        for (int i = 0; i < say.length(); i++) {
            // Count the occurrences of the current character
            while (i < say.length() - 1 && say.charAt(i) == say.charAt(i + 1)) {
                count++;
                i++;
            }
            // Append the count and the character to the result
            res.append(count).append(say.charAt(i));
            count = 1; // Reset the count for the next character
        }

        return res.toString();
    }
}
