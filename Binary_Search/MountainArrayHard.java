package Binary_Search;


//1095. Find in Mountain Array
//        You may recall that an array arr is a mountain array if and only if:
//
//        arr.length >= 3
//        There exists some i with 0 < i < arr.length - 1 such that:
//        arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
//        arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
//        Given a mountain array mountainArr, return the minimum index such that mountainArr.get(index) == target. If such an index does not exist, return -1.
//
//        You cannot access the mountain array directly. You may only access the array using a MountainArray interface:
//
//        MountainArray.get(k) returns the element of the array at index k (0-indexed).
//        MountainArray.length() returns the length of the array.
//        Submissions making more than 100 calls to MountainArray.get will be judged Wrong Answer. Also, any solutions that attempt to circumvent the judge will result in disqualification.
//
//
//
//        Example 1:
//
//        Input: array = [1,2,3,4,5,3,1], target = 3
//        Output: 2
//        Explanation: 3 exists in the array, at index=2 and index=5. Return the minimum index, which is 2.
//        Example 2:
//
//        Input: array = [0,1,2,4,2,1], target = 3
//        Output: -1
//        Explanation: 3 does not exist in the array, so we return -1.

public class MountainArrayHard {
    public static void main(String[] args) {

    }
    int search(int[] arr, int target){
        int peak = peakIndexInMountainArray(arr);
        int firsttry = orderAgnostic(arr,target,0,peak);

        if(firsttry != -1){
            return firsttry;
        }
       return orderAgnostic(arr,target,peak+1,arr.length-1);
    }


    public int peakIndexInMountainArray(int[] arr) {
        int start=0;
        int end = arr.length-1;

        while (start<end){
            int mid = start+(end-start)/2;
            if(arr[mid]>arr[mid+1]){
                end = mid;
            }
            else{
                start = mid+1;
            }
        }
        return start;
    }

    public static int orderAgnostic(int[] arr, int target,int start,int end){
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
