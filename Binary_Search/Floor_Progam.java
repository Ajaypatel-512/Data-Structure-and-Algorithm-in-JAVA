package Binary_Search;

public class Floor_Progam {
    public static void main(String[] args) {
        int[] arr = {2,3,5,9,14,16,18};
        int target = 4;

        System.out.println(floor(arr,target));

    }
    //  floor is the no which is greatest among smaller number or equal to target
    private static int floor(int[] arr, int target) {
        int start = 0;
        int end = arr.length-1;

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
        return end;
    }


    //Solution 2: Using upper bound logic
    //Time Complexity: O(log n)
    //Space Complexity: O(1)
    private static int floor2(int[] arr, int target) {
        int start = 0;
        int end = arr.length-1;
        int ans = -1;

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(target >= arr[mid]) {
                ans = arr[mid];
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return ans;
    }
}
