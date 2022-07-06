package Binary_Search;

import java.util.Arrays;

public class CharArraysReverse {
    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        reverseString(s);
    }
    public static void reverseString(char[] s) {
//        StringBuilder sb = new StringBuilder(String.valueOf(s));
//        sb.reverse();
//        System.out.println(sb);
        int start = 0;
        int end = s.length-1;
        while(start<=end){
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
        System.out.println(Arrays.toString(s));
    }
//    private static void swap(char[] arr, char i, char i1) {
//        char temp = arr[i];
//        arr[i] = arr[i1];
//        arr[i1] = temp;
//    }
}
