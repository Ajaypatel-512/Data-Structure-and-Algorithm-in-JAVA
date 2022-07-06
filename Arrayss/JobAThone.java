package Arrayss;

import java.util.Arrays;
import java.util.Random;

/**
 * N = 4, y = 2
 * A[] = {3, 1, 4, 5}
 * Output:
 * 1
 * Explanation:
 * Choose x = 1, now the array becomes
 * A = {4, 2, 5, 6}
 * **/
public class JobAThone {
    public static void main(String[] args) {
        int[] A = {3,1,4,5};
        int N= 4;
        int y = 2;
        System.out.println(solve(N,y,A));
    }
    static int solve(int N, int y, int[] A) {
        Arrays.sort(A);
        int element = Integer.MIN_VALUE;
        int count = 1;
        int max_count = 1;
        for(int i=1; i<A.length; i++){
            if(A[i] == A[i-1])
                count++;

            if(A[i] != A[i-1] || i==A.length-1){
                if(count>max_count){
                    max_count = count;
                    element = A[i-1];
                }
                count =1;
            }
        }
        return max_count;
    }
}
