package Arrayss;

import java.util.Arrays;

public class First {
    public static void main(String[] args) {
//        System.out.println("Hi everyone");
//        int[] num = {1,4,6,3,1,3,2,7,4};
//
//        Arrays.sort(num);
//        String ans = Arrays.toString(num);
//        System.out.println(ans);
        int x = 6;
        System.out.println(floorSqrt(x));
    }
    static long floorSqrt(long x) {
        // Your code here
//        int i = (int)x;
//        int mid = i/2;
//        int rem = i/mid;
//
//        if(mid == rem){
//            return mid;
//        }
//        return -1;
        int i = (int)x/2;
        if(x==1 || x==2 || x==3){
            return 1;
        }
        while(i>0){
            int rem =(int) x/i;
            if(rem == i){
                return rem;
            }
            i--;
        }
        return (int)x/2 -1;
    }
}
