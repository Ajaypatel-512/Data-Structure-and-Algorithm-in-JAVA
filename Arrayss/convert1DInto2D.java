package Arrayss;

import java.util.Arrays;

public class convert1DInto2D {
    public static void main(String[] args) {
        int[] original = {1,2,3};
        int m = 1, n = 3;
        int[][] result = construct2DArray(original,m,n);
        System.out.println(result);
    }
    public static int[][] construct2DArray(int[] original, int m, int n) {
        int[][] ans = new int[m][n];
        int count = 0;

        if(original.length != m*n)
            return new int[0][0];

        //possible hai
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                ans[i][j] = original[count];
                count++;
            }
        }
        return ans;
    }
}
