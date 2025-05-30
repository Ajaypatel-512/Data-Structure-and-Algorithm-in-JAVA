package Binary_Search;

public class ImplementUpperBound {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 3, 4, 5};
        int target = 2;
        int result = upperBound1(arr, target);
        System.out.println("Upper bound of " + target + " is at index: " + result);
    }

    //Solution 1: Using Linear Search
    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public static int upperBound1(int[] arr, int target){
        int n = arr.length;
        int ans = n;

        for (int i=0; i<n; i++){
            if (arr[i] > target) {
                ans = i;
                break;
            }
        }
        return ans;
    }

    //Solution 2: Using Binary Search
    //Time Complexity: O(log n)
    //Space Complexity: O(1)
    public static int upperBound2(int[] arr, int target){
        int n = arr.length;
        int left = 0;
        int right = n-1;
        int ans = n;

        while(left <= right){
            int mid = left + (right - left) /2;
            if (arr[mid] > target) {
                ans = mid;
                right = mid-1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
