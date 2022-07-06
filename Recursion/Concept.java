package Recursion;

public class Concept {
    public static void main(String[] args) {
        fun(5);
    }

    private static void fun(int i) {
        if (i == 0)
            return;
        System.out.print(i+" ");
//        fun(i--);             it will pass 5 because its i-- not --i
        fun(--i);
    }
}
