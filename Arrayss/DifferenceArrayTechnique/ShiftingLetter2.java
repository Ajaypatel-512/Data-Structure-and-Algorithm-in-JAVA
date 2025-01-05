package Arrayss.DifferenceArrayTechnique;

public class ShiftingLetter2 {
    /**
     * 2381. Shifting Letters II
     * You are given a string s of lowercase English letters and a 2D integer array shifts where shifts[i] = [starti, endi, directioni]. For every i, shift the characters in s from the index starti to the index endi (inclusive) forward if directioni = 1, or shift the characters backward if directioni = 0.
     * <p>
     * Shifting a character forward means replacing it with the next letter in the alphabet (wrapping around so that 'z' becomes 'a'). Similarly, shifting a character backward means replacing it with the previous letter in the alphabet (wrapping around so that 'a' becomes 'z').
     * <p>
     * Return the final string after all such shifts to s are applied.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: s = "abc", shifts = [[0,1,0],[1,2,1],[0,2,1]]
     * Output: "ace"
     * Explanation: Firstly, shift the characters from index 0 to index 1 backward. Now s = "zac".
     * Secondly, shift the characters from index 1 to index 2 forward. Now s = "zbd".
     * Finally, shift the characters from index 0 to index 2 forward. Now s = "ace".
     * Example 2:
     * <p>
     * Input: s = "dztz", shifts = [[0,0,0],[1,1,1]]
     * Output: "catz"
     * Explanation: Firstly, shift the characters from index 0 to index 0 backward. Now s = "cztz".
     * Finally, shift the characters from index 1 to index 1 forward. Now s = "catz".
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= s.length, shifts.length <= 5 * 104
     * shifts[i].length == 3
     * 0 <= starti <= endi < s.length
     * 0 <= directioni <= 1
     * s consists of lowercase English letters.
     */
    public static void main(String[] args) {
        String s = "abc";
        int[][] shifts = {{0, 1, 0}, {1, 2, 1}, {0, 2, 1}};
        System.out.println(shiftingLetters(s, shifts));
    }

    //Solution 1 : Using Brute Force
    //Time Complexity : O(n*m) where n is the length of shifts and m is the length of s
    //Space Complexity : O(n)
    public static String shiftingLetters(String s, int[][] shifts) {
        StringBuilder result = new StringBuilder(s);

        for (int i = 0; i < shifts.length; i++) {
            int start = shifts[i][0];
            int end = shifts[i][1];
            int direction = shifts[i][2];

            for (int j = start; j <= end; j++) {
                char currentChar = result.charAt(j);
                if (direction == 1) {
                    currentChar = shiftForward(currentChar);
                }
                if (direction == 0) {
                    currentChar = shiftBackward(currentChar);
                }
                result.setCharAt(j, currentChar);
            }
        }
        return result.toString();
    }

    private static char shiftForward ( char c){
        return (c == 'z') ? 'a' : (char) (c + 1);
    }

    private static char shiftBackward ( char c){
        return (c == 'a') ? 'z' : (char) (c - 1);
    }
}
