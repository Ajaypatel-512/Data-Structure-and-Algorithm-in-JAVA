package Extra;

import java.util.ArrayList;
import java.util.Scanner;

public class PalindromeUsingArrayL {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
        String name = "madam";

        System.out.println(isPalindrome(name));

    }
    public static boolean isPalindrome(String str){
        ArrayList<Character> ch = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
//            System.out.println(str.charAt(i));
            if (ch.contains(str.charAt(i))) {
                ch.remove(str.charAt(i));
            }else{
                ch.add(str.charAt(i));
            }
        }

        //            System.out.println(str+ " palindrome");
        //            System.out.println(str+" not palindrome");
        return str.length() % 2 == 0 && ch.isEmpty() || str.length() % 2 == 1 && ch.size() == 1;
    }
}
