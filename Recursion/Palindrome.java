package Recursion;

public class Palindrome {
    private static int fun2(int i) {
        int digits = (int)(Math.log10(i))+1;
        return helper(i,digits);
    }

    private static int helper(int i, int digits) {
        if(i%10 == 0){
            return i;
        }
        int rem = i%10;
        return rem * (int)Math.pow(10,digits-1) + helper(i/10,digits-1);
    }

    private static boolean fun(int n) {
        return n == fun2(n);
    }

    public static void main(String[] args) {
        int n = 1231;
        System.out.println(fun(n));
    }
}
