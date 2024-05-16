package Basic_Program;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number to find factorial");
        int num = sc.nextInt();
        int temp = num;
        int fac = 1;
        if (num < 0) {
            System.out.println("Invalid number");
        } else {
            while (num > 0) {
                fac = fac * num;
                num--;
            }
            System.out.println("factorial of " + temp + " is " + fac);
        }
    }
}
