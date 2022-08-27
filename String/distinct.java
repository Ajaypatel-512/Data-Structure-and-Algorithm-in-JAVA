package String;

import java.util.HashSet;
import java.util.Scanner;

public class distinct {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(countDist(s));
    }

    public static int countDist(String s) {
        HashSet<Character> s1 = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            s1.add(s.charAt(i));
        }
        return s1.size();
    }
}
