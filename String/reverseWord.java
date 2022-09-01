package String;

import java.util.Scanner;

public class reverseWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = "Let's take LeetCode contest";

        System.out.println(reverseWords(s));

    }

    public static String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder rs = new StringBuilder();

        for(String word : words){
            StringBuilder rw = new StringBuilder(word).reverse();
            rs.append(rw).append(" ");
        }
        return rs.toString().trim();
    }
}
