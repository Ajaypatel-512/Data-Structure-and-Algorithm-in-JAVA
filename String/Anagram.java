package String;

import java.util.Arrays;

public class Anagram {
    public static boolean isAnagram(String s, String t) {

        char[] Tarr=t.toCharArray();
        char[] Sarr=s.toCharArray();

        Arrays.sort(Tarr);
        Arrays.sort(Sarr);

        return Arrays.equals(Tarr,Sarr);
    }

    public static void main(String[] args) {
        String s = "apple";
        String t = "pplea";
        System.out.println(isAnagram(s,t));
    }
}
