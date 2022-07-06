package Recursion;

public class SumOfDigit {
    public static void main(String[] args) {
        int n = 12345;
        System.out.println(sumDigit(n));
        System.out.println(proDigit(n));
    }

    private static int sumDigit(int n) {
        if(n == 0) {
            return 0;
        }
        return n%10 + sumDigit(n/10);
    }

    private static int proDigit(int n) {
        if(n%10 == n) {
            return n;
        }
        return n%10 * proDigit(n/10);
    }
}
