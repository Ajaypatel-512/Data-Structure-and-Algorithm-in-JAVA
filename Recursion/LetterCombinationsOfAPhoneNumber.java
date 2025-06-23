package Recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    /**
     * 17. Letter Combinations of a Phone Number
     * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
     *
     * A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
     *
     *
     *
     *
     * Example 1:
     *
     * Input: digits = "23"
     * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
     * Example 2:
     *
     * Input: digits = ""
     * Output: []
     * Example 3:
     *
     * Input: digits = "2"
     * Output: ["a","b","c"]
     *
     *
     * Constraints:
     *
     * 0 <= digits.length <= 4
     * digits[i] is a digit in the range ['2', '9'].
     * */
    public static void main(String[] args) {

    }

    /**
     * A map from digits to letters mapping
     * */
    private static final HashMap<Character, String> digitToLettersMap = new HashMap<>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    //Solution 1: Using Backtracking
    //Time Complexity: O(3^n * 4^m) where n is the number of digits that map to 3 letters and m is the number of digits that map to 4 letters.
    //Space Complexity: O(n) for the recursion stack and O(3^n * 4^m) for the result list.
    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        solve(0,digits, "",result);
        return result;
    }

    private static void solve(int idx, String digits, String temp ,List<String> result) {
        if (idx == digits.length() || digits.length() == 0) {
            result.add(temp);
            return;
        }

        char ch = digits.charAt(idx);
        String str = digitToLettersMap.get(ch);
        for (int i=0; i<str.length(); i++){
            temp += str.charAt(i);
            solve(idx + 1, digits, temp, result);
            temp = temp.substring(0, temp.length() - 1);
        }

    }
}
