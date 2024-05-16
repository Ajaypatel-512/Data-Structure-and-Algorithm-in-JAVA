package Extra;

import java.util.Scanner;

public class Leap_Year {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Year to find leap year or not");
        int n = sc.nextInt();

        if (n % 400 == 0) {
            System.out.println(n + " Is a leap year");
        } else if (n % 100 == 0) {
            System.out.println(n + " is a not leap year.");
        } else if (n % 4 == 0) {
            System.out.println(n + " Is a leap year");
        } else {
            System.out.println(n + " is a not leap year.");
        }
    }
}
