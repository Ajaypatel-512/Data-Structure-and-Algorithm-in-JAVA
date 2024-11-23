package Arrayss.Matrix;

import java.util.Arrays;

public class TransposeOfMatrix {
    /**
     * Transpose of a 2-D Matrix
     *
     * */
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] transpose = transpose(matrix);

        for (int[] arr: transpose){
            System.out.println(Arrays.toString(arr));
        }
    }

    public static int[][] transpose(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] result = new int[n][m];

        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                result[i][j] = matrix[j][i];
            }
        }
        return result;
    }
}
