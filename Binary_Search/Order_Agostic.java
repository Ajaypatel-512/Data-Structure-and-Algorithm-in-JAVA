package Binary_Search;

public class Order_Agostic {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        int ans = orderAgnostic(arr,10);
        System.out.println(ans);
    }
    public static int orderAgnostic(int[] arr, int target){
        int start = 0;
        int end = arr.length-1;

        //find asc or desc
        boolean isArr = arr[start] < arr[end];

//        if (arr[start] >= arr[end]) {
//            isArr = false;
//        } else {
//            isArr = true;
//        }

        while (start<=end){
//        int mid = (start+end)/2; here (start+end) value  ay exceed range of integer fot that use below one
            int mid = start + (end-start)/2;
            if(arr[mid] == target){
                return mid;
            }
            if (isArr){
                if(target < arr[mid]) {
                    end = mid - 1;
                }else {
                    start = mid + 1;
                }
            }else{
                if(target > arr[mid]){
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}
