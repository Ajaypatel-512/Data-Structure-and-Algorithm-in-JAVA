package Arrayss;

import java.util.Arrays;

public class ThreeConseSumIntege{
    public static void main(String[] args) {
        int num = 33;
        long[] ans = sumOfThree(num);
        System.out.println(Arrays.toString(ans));
    }
    public static long[] sumOfThree(long num) {
        long a = 0,b = 1, c = 2;

        if(num<3){
            return new long[0];
        }
        for(int i=1; i<num; i++){
            if(i-1 + i + i+1 == num){
                return new long[]{i-1,i,i+1};
            }
        }
        return new long[0];
    }
}
