package MathsNumSys;

/**
 7. Reverse Integer
 Medium
 Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

 Example 1:
 Input: x = 123
 Output: 321
 Example 2:
 Input: x = -123
 Output: -321
 Example 3:
 Input: x = 120
 Output: 21
 **/

public class ReverseNum {
    public static void main(String[] args) {
        int x = 120;
        System.out.println(reverse(x));
    }
    public static int reverse(int x) {
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x = x / 10;
        }

        if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) {
            return 0;
        } else {
            return (int)res;
        }
    }
}
