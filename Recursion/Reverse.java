package Recursion;

public class Reverse {
    /********************* METHOD 1 ****************/
    static int sum = 0;
    private static void fun(int i) {
        if (i == 0){
            return;
        }
        int rem = i % 10;
        sum = sum * 10 + rem;
        fun(i / 10);
    }

    /********************* METHOD 2 ******************/
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
    /********************* MAIN METHOD ******************/
    public static void main(String[] args) {
        int n = 12345;
        fun(n);
        System.out.println(fun2(n));
        System.out.println(sum);
    }

}
