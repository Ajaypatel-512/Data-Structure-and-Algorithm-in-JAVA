package Extra;

import java.util.Scanner;

public class ArmStrong_No {

    /*
    * The Armstrong number is the number in any given number base, which makes the total of the same number when each of its digits is raised to the power of the total number of digits in the number.
    * In simple words, we can say that a positive integer of n digits is called an Armstrong number of order n (order is the total number of digits present in a number) if,
    * abcd... = pow(a,n) + pow(b,n) + pow(c,n) + pow(d,n) + ....
    * ex = 1,2,3,4,5,6,7,8,9,153,370,371....
    *
    *
    * Approach :
        1. Using Loops and Basic Operations - O(log10(n))
        2. Recursive Method - O(N)
    *
    * */


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number to check ArmStrong No");
        int x = sc.nextInt();
        System.out.println(x + " : " + isArmstrong(x));

        System.out.println(x + " : " + isArmstrong1(x));
    }

    /*
     * Using Loops and Basic Operations Method
     * Time complexity -  O(log10(n))
     * Space complexity - O(1)
     * */
    static int power(int x, long y)
    {
        if (y == 0)
            return 1;
        if (y % 2 == 0)
            return power(x, y / 2) * power(x, y / 2);
        return x * power(x, y / 2) * power(x, y / 2);
    }

    static int order(int x)
    {
        int n = 0;
        while (x != 0) {
            n++;
            x = x / 10;
        }
        return n;
    }

    static boolean isArmstrong(int x)
    {
        int n = order(x);
        int temp = x, sum = 0;
        while (temp != 0) {
            int r = temp % 10;
            sum = sum + power(r, n);
            temp = temp / 10;
        }
        return (sum == x);
    }

    /*
    * Recursive Method
    * Time complexity - O(N)
    * Space complexity - O(1)
    * */

    static int cal(int x, int dig) {
        if (x == 0)
            return 0;
        int num = x % 10;
        return cal(x / 10, dig) + power(num, dig);
    }

    public static boolean isArmstrong1(int x) {
        int dig = order(x);
        if (dig <= 1)
            return true;
        int res = cal(x, dig);
        return res == x;
    }

}
