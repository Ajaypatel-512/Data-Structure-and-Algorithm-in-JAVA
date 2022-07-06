package Arrayss;

import java.util.Arrays;

public class minimizeSum {
    public static void main(String[] args) {
        long[] a = {3,1,1};
        long[] b = {6,5,4};
        long n = a.length;
        System.out.println(minValue(a,b,n));
    }
    public static long minValue(long a[], long b[], long n)
    {
        // Your code goes here
        Arrays.sort(a);
        Arrays.sort(b);
        long sum = 0;
        for(int i = 0, j = (int) (n-1); i<n; i++){
            sum += a[i]*b[j];
            j--;
        }
        return sum;
    }
}
