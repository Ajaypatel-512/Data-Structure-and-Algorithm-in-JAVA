package Recursion;

public class Num1to5 {
    public static void main(String[] args) {
        int n = 5;
//        fun1(n);
//        System.out.println("");
//        fun2(n);
//        System.out.println("");
        both(n);
    }

    private static void fun1(int n) {
        if(n==0){
            return;
        }
        fun1(n-1);
        System.out.print(n+" ");
    }

    private static void fun2(int n) {
        if(n == 0){
            return;
        }
        System.out.print(n+" ");
        fun2(n-1);
    }
    private static void both(int n) {
        if(n == 0){
            return;
        }
        System.out.print(n+" ");
        both(n-1);
        System.out.print(n+" ");
    }
}
