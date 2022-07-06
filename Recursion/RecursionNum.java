package Recursion;

public class RecursionNum {
    public static void main(String[] args) {
        Number(1);
    }
    static void Number(int n){
        if(n==5){
            return;
        }
        System.out.println(n);
        //        if (n <5) return;
        /**
         * Tail Recursion
         * last function recursion
         * **/
        Number(n+1);

    }
}
