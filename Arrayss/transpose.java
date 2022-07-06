package Arrayss;

import java.util.Arrays;

public class transpose {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3},
                {4,5,6}
        };

        int[][] ans = transpose(matrix);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(ans[i]));
        }
    }
    public static int[][] transpose(int[][] matrix) {
        int[][] ans = new int[matrix.length][matrix.length];

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix.length; j++){
                if(i != j){
                    ans[i][j] = matrix[j][i];
                }
                if(i == j){
                    ans[i][j] = matrix[i][j];
                }
            }

        }
        return ans;
    }
}
