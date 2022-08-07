package Extra;

import java.util.Locale;

public class leet387 {
//    387. First Unique Character in a String
//    Easy

//    Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.

//    Example 1:
//
//    Input: s = "leetcode"
//    Output: 0
//    Example 2:
//
//    Input: s = "loveleetcode"
//    Output: 2
//    Example 3:
//
//    Input: s = "aabb"
//    Output: -1


    public static int firstUniqChar(String s) {
        char[] ch = s.toCharArray();
        for(int i=0; i<ch.length; i++){
            for (int j =i+1; j<ch.length; j++){
                if(ch[i]!=ch[j] && j==ch.length-1){
                    return i;
                }
            }
        }
        return -1;

//        int[] freq = new int[26];
//
//        for(int i = 0; i < s.length(); i++){
//            freq[s.charAt(i) - 'a']++;
//        }
//
//        for(int i = 0; i < s.length(); i++){
//            if(freq[s.charAt(i) - 'a'] == 1){
//                return i;
//            }
//        }
//        return -1;
    }

    public static void main(String[] args) {
        String s = "loveleetcode";
        System.out.println(firstUniqChar(s));
    }
}
