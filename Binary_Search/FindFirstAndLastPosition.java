package Binary_Search;

public class FindFirstAndLastPosition {
    /**
     * 34. Find First and Last Position of Element in Sorted Array
     * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
     *
     * If target is not found in the array, return [-1, -1].
     *
     * You must write an algorithm with O(log n) runtime complexity.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [5,7,7,8,8,10], target = 8
     * Output: [3,4]
     * Example 2:
     *
     * Input: nums = [5,7,7,8,8,10], target = 6
     * Output: [-1,-1]
     * Example 3:
     *
     * Input: nums = [], target = 0
     * Output: [-1,-1]
     *
     *
     * Constraints:
     *
     * 0 <= nums.length <= 105
     * -109 <= nums[i] <= 109
     * nums is a non-decreasing array.
     * -109 <= target <= 109
     * */
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] result = searchRange(nums, target);
        System.out.println("First and Last Position: [" + result[0] + ", " + result[1] + "]");
    }

    //Solution 1: Using Linear Search
    //Time Complexity: O(n) + O(n) = O(n)
    // Space Complexity: O(1)
    public static int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int[] result = {-1, -1};

        for (int i=n-1; i>=0; i--) {
            if (nums[i] == target) {
                result[1] = i;
                break;
            }
        }

        for (int i=0; i<n; i++) {
            if (nums[i] == target) {
                result[0] = i;
                break;
            }
        }

        return result;
    }


    //Solution 2: Using Binary Search
    // Time Complexity: O(log n) + O(log n) = O(log n)
    // Space Complexity: O(1)
    public static int[] searchRange2(int[] nums, int target) {
     int n = nums.length;
     int first = -1;
     int last = -1;

     int low = 0;
     int high = n - 1;

     // Find the first occurrence of target
     while (low <= high){
         int mid = low + (high -low)/2;

         if (nums[mid] == target) {
             first = mid;
             high = mid - 1;
         } else if (nums[mid] < target) {
             low = mid + 1;
         } else {
             high = mid - 1;
         }
     }

     // Find the Last occurrence of target
     low = 0;
     high = n - 1;
     while(low <= high) {
         int mid = low + (high - low) / 2;

         if (nums[mid] == target) {
             last = mid;
             low = mid+1;
         } else if (nums[mid] < target) {
             low = mid + 1;
         } else {
             high = mid - 1;
         }
     }
     return new int[]{first, last};

    }
}
