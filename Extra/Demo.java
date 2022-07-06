package Extra;

import java.util.Locale;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        s1 = s1.toLowerCase();
        String s2 = sc.next();
        s2 = s2.toLowerCase();
        String s3 = sc.next();
        s3 = s3.toUpperCase();
//
//
//        char[] a = s1.toCharArray();
//        for (int i = 0; i < a.length; i++) {
//            if(a[i] == 'a'||a[i] == 'e'||a[i] == 'i'||a[i] == 'o'||a[i] == 'u'){
//                System.out.print(s1.replace(a[i], '*'));
//            }
//        }
//
//        char[] b = s2.toCharArray();
//        for (int i = 0; i < b.length; i++) {
//            if(b[i] != 'a'|| b[i] != 'e'||b[i] != 'i'||b[i] != 'o'||b[i] != 'u'){
//                System.out.print(s2.replace(b[i],'@'));
//            }
//        }
//        System.out.println(s3);

        s1 = s1.replaceAll("[aeiou]","*");
        s2 = s2.replaceAll("[^aeiou]","@");
        System.out.println(s1+""+s2+""+s3);
    }
}
