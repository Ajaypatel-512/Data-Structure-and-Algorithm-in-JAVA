package StringPac;

import java.util.Locale;

public class Palindrome {
    public static void main(String[] args) {
        String pal = "dcdv";
        System.out.println(isPalind(pal));
    }

    public static boolean isPalind(String pal) {
        if(pal == null || pal.length() == 0){
            return true;
        }

        pal = pal.toLowerCase();
        for (int i = 0; i <= pal.length()/2; i++) {
            char start = pal.charAt(i);
            char end = pal.charAt(pal.length()-1-i) ;
            if (start != end){
                return false;
            }
        }
        return true;
    }
}
