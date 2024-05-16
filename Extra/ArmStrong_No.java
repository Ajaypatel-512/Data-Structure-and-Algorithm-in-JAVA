package Extra;

import java.util.Scanner;

public class ArmStrong_No {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number to check ArmStrong No");
        int num = sc.nextInt();
        int temp = num;
        int r;

        // 1 5 3
        // 1*1*1 + 5*5*5 + 3*3*3
        // 1 + 125 + 27
        // 153

        int digit = 0, sum = 0;
        while (temp > 0) {
            temp = temp / 10;
            digit++;
        }
        temp = num;
        while (temp > 0) {
            r = temp % 10;
            sum += Math.pow(r, digit);
            temp = temp / 10;
        }
        if (num == sum) {
            System.out.println(num + " is an Armstrong Number");
        } else {
            System.out.println(num + " is not an Armstrong Number");
        }
    }
}
