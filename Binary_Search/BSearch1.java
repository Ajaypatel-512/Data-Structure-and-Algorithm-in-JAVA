package Binary_Search;

public class BSearch1 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        int ans = binarysearch(arr,10);
        System.out.println(ans);
    }
    public static int binarysearch(int[] arr, int target){
        int start = 0;
        int end = arr.length-1;
        while (start<=end){

//        int mid = (start+end)/2;
            int mid = start + (end-start)/2;
            if(target < arr[mid]) {
                end = mid - 1;
            }else if(target > arr[mid]){
                start = mid + 1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }
}
