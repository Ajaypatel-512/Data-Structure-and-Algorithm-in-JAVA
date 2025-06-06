package Binary_Search;

public class Ceiling_Program {
    public static void main(String[] args) {
        int[] arr = {2,3,5,9,14,16,18};
        int target = 19;

        System.out.println(ceiling(arr,target));

    }
//  celining return the index of smallest no >=target
    private static int ceiling(int[] arr, int target) {
        int start = 0;
        int end = arr.length-1;

        if (target > arr[arr.length - 1]){
            return -1;
        }

        while(start<=end){
            int mid = start + (end - start) / 2;
            if(target < arr[mid]) {
                end = mid - 1;
            }else if(target > arr[mid]){
                start = mid + 1;
            }
            else{
                return mid;
            }
        }
        return start;
    }

    //Solution 2: Using lower bound logic
    //Time Complexity: O(log n)
    //Space Complexity: O(1)
    private static int ceiling2(int[] arr, int target) {
        int start = 0;
        int end = arr.length-1;
        int ans = -1;

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(target <= arr[mid]) {
                ans = arr[mid];
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return ans;
    }
}
