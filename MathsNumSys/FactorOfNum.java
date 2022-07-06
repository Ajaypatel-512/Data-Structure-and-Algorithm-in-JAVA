package MathsNumSys;

import java.util.ArrayList;
import java.util.Arrays;

public class FactorOfNum {
    public static void main(String[] args) {
        int N = 20;
        factor(N);
    }

    // O(n)
     static void factor(int n) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (n % i == 0)
                list.add(i);
        }
         System.out.println(list);
         System.out.println(list.get(2));
    }

    // O(sqrt(N))
//    static void factor(int n) {
//        for (int i = 1; i <= Math.sqrt(n); i++) {
//            if (n % i == 0){
//                if (n/i == i)
//                    System.out.print(i);
//                else
//                    System.out.print(i +" "+n/i+" ");   // 1 20 2 10 4 5
//            }
//        }
//    }

    //both time and space O(sqrt(n))
//    static void factor(int n) {
//        ArrayList<Integer> list = new ArrayList<>();
//        for (int i = 1; i <= Math.sqrt(n); i++) {
//            if (n % i == 0){
//                if (n/i == i) {
//                    System.out.print(i);
//                    list.add(i);
//                }
//                else {
////                    System.out.print(i + " " + n / i + " ");   // 1 20 2 10 4 5
//                    list.add(n/i);
//                }
//            }
//        }
//        for (int j = list.size()-1; j >=0 ; j--) {
//            System.out.print(list.get(j)+" ");
//        }
//    }
}
