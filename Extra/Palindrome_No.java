package Extra;

import java.util.Scanner;

public class Palindrome_No {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number to check for palindrome No");
        int num = sc.nextInt();
        int temp = num;
        int r = 0;
        int sum = 0;

        while (num > 0) {
            r = num % 10;
            sum = (sum * 10) + r;
            num = num / 10;
        }
        if (sum == temp) {
            System.out.println(sum + " is a Plindrome Number");
        } else {
            System.out.println(sum + " is not a palindrome Number");
        }
    }
}
