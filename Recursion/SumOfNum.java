package Recursion;

public class SumOfNum {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(sum(n));
    }

    private static int sum(int n) {
        if(n == 1){
            return 1;
        }
//        int fac = n * factorial(n-1);
//        return fac;
        return n + sum(n-1);
    }
}
