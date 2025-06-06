package String;

public class LargestOddNumberInString {
    /**
     * 1903. Largest Odd Number in String
     * You are given a string num, representing a large integer. Return the largest-valued odd integer (as a string) that is a non-empty substring of num, or an empty string "" if no odd integer exists.
     *
     * A substring is a contiguous sequence of characters within a string.
     *
     *
     *
     * Example 1:
     *
     * Input: num = "52"
     * Output: "5"
     * Explanation: The only non-empty substrings are "5", "2", and "52". "5" is the only odd number.
     * Example 2:
     *
     * Input: num = "4206"
     * Output: ""
     * Explanation: There are no odd numbers in "4206".
     * Example 3:
     *
     * Input: num = "35427"
     * Output: "35427"
     * Explanation: "35427" is already an odd number.
     *
     *
     * Constraints:
     *
     * 1 <= num.length <= 105
     * num only consists of digits and does not contain any leading zeros.
     * */
    public static void main(String[] args) {
        String num = "35427";
        System.out.println(largestOddNumber(num)); // Output: "35427"

        num = "4206";
        System.out.println(largestOddNumber(num)); // Output: ""

        num = "52";
        System.out.println(largestOddNumber(num)); // Output: "5"
    }

    //Solution 1: Iterate from the end of the string to find the last odd digit
    //Time Complexity: O(n)
    // Space Complexity: O(1)
    public static String largestOddNumber(String num) {
        int n = num.length();
        if(n == 0) return "";
        if(n == 1) {
            return (num.charAt(0) % 2 != 0) ? num : "";
        }
        String temp = "";
        for(int i = n - 1; i >= 0; i--) {
            if(num.charAt(i) % 2 != 0) {
                temp = num.substring(0, i + 1);
                break;
            }
        }
        return temp;
    }
}
