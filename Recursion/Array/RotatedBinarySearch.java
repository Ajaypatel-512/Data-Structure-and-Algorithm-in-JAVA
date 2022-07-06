package Recursion.Array;

public class RotatedBinarySearch {
    public static void main(String[] args) {
        int[] arr = {5,6,7,8,9,1,2,3};
        int target = 4;
        System.out.println(binarySearch(arr,target,0,arr.length-1));
    }

    static int binarySearch(int[] arr, int target,int s, int e){
        if(s>e){
            return -1;
        }
        int m = s+(e-s)/2;
        if(arr[m] == target){
            return m;
        }

        if(arr[s]<= arr[m]){
            if(target >= arr[s] && target<= arr[m]){
                return binarySearch(arr,target,s,m-1);
            }else{
                return binarySearch(arr,target,m+1,e);
            }
        }
        if(target>=arr[m] && target<=arr[e]){
            return binarySearch(arr,target,m+1,e);
        }else{
            return binarySearch(arr,target,s,m-1);
        }
    }
}
