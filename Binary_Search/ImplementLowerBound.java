package Binary_Search;

public class ImplementLowerBound {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 3, 4, 5};
        int target = 2;
        int result = lowerBound(arr, target);
        System.out.println("Lower bound of " + target + " is at index: " + result);
    }

    //Solution 1: Using Linear Search
    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public static int lowerBound1(int[] arr, int target){
        int n = arr.length;
        int ans = n;

        for (int i=0; i<n; i++){
            if (arr[i] >= target) {
                ans = i;
                break;
            }
        }


        return ans;
    }

    //Solution 2: Using Binary Search
    //Time Complexity: O(log n)
    //Space Complexity: O(1)
    public static int lowerBound(int[] arr, int target){
        int n = arr.length;
        int left = 0;
        int right = n-1;
        int ans = n;

        while(left < right){
            int mid = left + (right - left) /2;
            if (arr[mid] >= target) {
                ans = mid;
                right = mid-1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }


}
