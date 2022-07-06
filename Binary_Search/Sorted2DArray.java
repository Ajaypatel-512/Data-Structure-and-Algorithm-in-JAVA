package Binary_Search;

import java.util.Arrays;

public class Sorted2DArray {
    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        System.out.println(Arrays.toString(search(arr,10)));
    }

    public static int[] binarySearch(int[][] arr,int row,int cStart, int cEnd,int target){
        while(cStart<=cEnd){
            int mid = cStart + (cEnd-cStart)/2;

            if(arr[row][mid] == target){
                return new int[]{row, mid};
            }
            if(arr[row][mid] < target){
                cStart = mid + 1;
            }
            else {
                cEnd = mid - 1;
            }
        }
        return new int[]{-1,-1};
    }

    public static int[] search(int[][] matrix, int target){
        int row = matrix.length;
        int col = matrix[0].length;
        int rStart = 0;
        int rEnd = row-1;
        int cMid = col/2;
        if(row == 1){
            binarySearch(matrix,0 ,0,col-1,target);
        }
        while (rStart < rEnd-1 ){
            int mid = rStart + (rEnd-rStart)/2;
            if(matrix[mid][cMid] == target){
                return new int[]{mid,cMid};
            }
            if(matrix[mid][cMid] < target){
                rStart = mid;
            }
            else{
                rEnd = mid;
            }
        }
        if(matrix[rStart][cMid] == target){
            return new int[]{rStart,cMid};
        }
        if(matrix[rStart+1][cMid] == target) {
            return new int[]{rStart + 1, cMid};
        }

        //1st half
        if(target <= matrix[rStart][cMid-1]){
            return binarySearch(matrix,rStart,0,cMid-1,target);
        }
        //2nd half
        if(target >= matrix[rStart][cMid+1] && target <= matrix[rStart][col-1]){
            return binarySearch(matrix,rStart,cMid+1,col-1,target);
        }
        //3rd half
        if(target <= matrix[rStart+1][cMid-1]){
            return binarySearch(matrix,rStart+1,0,cMid-1,target);
        }
        //4th half
        else {
            return binarySearch(matrix,rStart+1,cMid+1,col-1,target);
        }

    }
}
