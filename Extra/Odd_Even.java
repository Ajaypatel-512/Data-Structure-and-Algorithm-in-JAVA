package Extra;

import java.util.Scanner;

class Odd_Even {

    /**
     * 1. Using Brute Force- Naive Approach
     * 2. Using bitwise operators
            -> Using Bitwise OR
            -> Using Bitwise AND
            -> Using Bitwise XOR
     * 3. By Checking the Least Significant Bit
     * */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number to find ODD/EVEN");
        int n = sc.nextInt();

        /*
         * Using Brute Force- Naive Approach
         * Time Complexity: O(1)
         * Auxiliary Space: O(1)
         * */
        if (n % 2 == 0) {
            System.out.println(n + " Is an Even Number");
        } else {
            System.out.println(n + " Is an Odd Number");
        }

        /*
         * Using bitwise operators
         * 1. Bitwise OR operation of the even number by 1 increment the value of the number by 1 otherwise it remains unchanged.
           EX :
           Number = 12              1  1  0  0    - Representation of 12 in Binary Format
           Bitwise OR               0  0  0  1    - Representation of  1 in Binary Format

                                    1  1  0  1    - Representation of 13 in Binary Format
            Result- Number was even so bitwise Or by 1 increment the value by 1
         *
         * Time Complexity: O(1)
         * Auxiliary Space: O(1)
         * */
        if ((n | 1) > n) {
            System.out.println(n + " Is an Even Number");
        } else {
            System.out.println(n + " Is an Odd Number");
        }

        /*
         * Using bitwise operators
         * 1. Bitwise AND operation of the odd number by 1 will be 1 because the last bit will be already set otherwise it will give 0.
           EX :
           Number = 5               0  1  0  1    - Representation of 5 in Binary Format
           Bitwise AND              0  0  0  1    - Representation of  1 in Binary Format

                                    0  0  0  1    - Representation of 1 in Binary Format
            Result- Number was odd so bitwise and by 1 is 1
         *
         * Time Complexity: O(1)
         * Auxiliary Space: O(1)
         * */
        if ((n & 1) == 1) {
            System.out.println(n + " Is an Odd Number");
        } else {
            System.out.println(n + " Is an Even Number");
        }

        /*
         * Using bitwise operators
         * 1. Bitwise XOR operation of the even number by 1 increment the value of the number by 1 otherwise it decrements the value of the number by 1 if the value is odd. It is the most optimal approach.
           EX :
           Number = 5               0  1  0  1    - Representation of 5 in Binary Format
           Bitwise XOR              0  0  0  1    - Representation of  1 in Binary Format

                                    0  1  0  0    - Representation of 4 in Binary Format
            Result- Number was odd so bitwise And by 1 decrement the value
         *
         * Time Complexity: O(1)
         * Auxiliary Space: O(1)
         * */
        if ((n ^ 1) == n + 1) {
            System.out.println(n + " Is an Even Number");
        } else {
            System.out.println(n + " Is an Odd Number");
        }

        /*
         * By Checking the Least Significant Bit
         * The LSB(The Least Significant Bit) of an even number is always 0 and that of an odd number is always 1.
         * Time Complexity: O(1)
         * Auxiliary Space: O(1)
         * */
        for (int i = 0; i <= n; i++) {
            if (i != 0) {
                if (Integer.toBinaryString(i).endsWith("0")) {
                    System.out.println(n + " Is an Even Number");
                } else {
                    System.out.println(n + " Is an Odd Number");
                }
            } else {
                System.out.println(n + " Is an Even Number");
            }
        }

    }
}