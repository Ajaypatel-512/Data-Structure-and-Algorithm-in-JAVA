package Extra;

import java.util.Scanner;

public class Alpha_symbol {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter single character to check for alphabet, digit or special character");
        char sing_ch = sc.nextLine().charAt(0);

        if ((sing_ch >= 'a' && sing_ch <= 'z') || (sing_ch >= 'A' && sing_ch <= 'Z')) {
            System.out.println(sing_ch + " This is an alphabet");
        } else if (sing_ch >= '0' && sing_ch <= '9') {
            System.out.println(sing_ch + " This is a digit");
        } else {
            System.out.println(sing_ch + " This is a special character.");
        }
    }
}
