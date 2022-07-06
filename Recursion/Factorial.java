package Recursion;

public class Factorial {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(factorial(n));
    }

    private static int factorial(int n) {
        if(n == 1){
            return 1;
        }
//        int fac = n * factorial(n-1);
//        return fac;
        return n * factorial(n-1);
    }
}
