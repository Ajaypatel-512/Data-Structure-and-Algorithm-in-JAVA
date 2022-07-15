package Recursion.LetterPhoneNo;
//  17. Letter Combinations of a Phone Number
//        Medium
//        Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
//        A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

//        Example 1:
//        Input: digits = "23"
//        Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
//        Example 2:
//        Input: digits = ""
//        Output: []
//        Example 3:
//        Input: digits = "2"
//        Output: ["a","b","c"]

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
//        pad("","12");
//        System.out.println(letterCombinations("","12"));
    }
    public static List<String> letterCombinations(String digits) {
        if (digits.isEmpty()){
            return new ArrayList<String>();
        }
        ArrayList<String> ans = sub("", digits);
        return ans;
    }
    static ArrayList<String> sub(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        int digit = (up.charAt(0) - '0')-1;
        ArrayList<String> ans = new ArrayList<>();
        int start = (digit-1)*3;
        int end = digit*3;
        if(digit==6) end+=1;

        if(digit==7) {
            start+=1;
            end+=1;
        }
        if(digit==8) {
            start+=1;
            end+=2;
        }

        for (int i = start; i < end; i++) {
            char ch = (char) ('a'+ i);
            ans.addAll(sub(p+ch,up.substring(1)));
        }
        return ans;
    }

    /************** METHOD 1 ***************************/
//    public static void pad(String p, String up){
//        if(up.isEmpty()){
//            System.out.println(p);
//            return;
//        }
//
//        int digit = up.charAt(0) - '0';
//        for (int i = (digit-1)*3; i < digit*3; i++) {
//            char ch = (char)('a'+i);
//            pad(p+ch,up.substring(1));
//        }
//    }

    /************** METHOD 2 ***************************/
//    public static List<String> letterCombinations(String p, String up) {
//        if (up.isEmpty()){
//            ArrayList<String> list = new ArrayList<>();
//            list.add(p);
//            return list;
//        }
//        int digit = up.charAt(0) - '0';
//        ArrayList<String> list = new ArrayList<>();
//
//        for (int i = (digit-1)*3; i < digit*3; i++) {
//            char ch = (char)('a'+i);
//            list.addAll(letterCombinations(p+ch,up.substring(1)));
//        }
//        return list;
//    }
}
