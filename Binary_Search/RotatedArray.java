package Binary_Search;

/**
 * 33. Search in Rotated Sorted Array
 * There is an integer array nums sorted in ascending order (with distinct values).
 *
 * Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
 *
 * Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 * Example 3:
 *
 * Input: nums = [1], target = 0
 * Output: -1
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 5000
 * -104 <= nums[i] <= 104
 * All values of nums are unique.
 * nums is an ascending array that is possibly rotated.
 * -104 <= target <= 104
 */
public class RotatedArray {
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        System.out.println(findPivot(arr));
    }

    //Solution 1: Using Brute Force (linear search)
    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public static int search1(int[] nums, int target) {
        int n = nums.length;

        for(int i=0; i<n; i++){
            if(nums[i] == target){
                return i;
            }
        }
        return -1;
    }

    //Solution 2: Using Binary Search
    // Time Complexity: O(log n)
    // Space Complexity: O(1)
    public static int search2(int[] nums, int target) {
        int n = nums.length;
        return search3(nums,n , target);
    }

    private static int search3(int[] nums, int n, int target) {
        int low = 0;
        int high = n-1;

        while(low <= high){
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[low] <= nums[mid]){
                if (nums[low] <= target && target <= nums[mid]){
                    high = mid -1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (nums[mid] <= target && target <= nums[high]){
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }


    int search (int[] arr, int target){
        int pivot = findPivot(arr);
        if(pivot == -1){
            return binarysearch(arr,target,0,arr.length-1);
        }
        if(arr[pivot] == target){
            return pivot;
        }
        if(target >= arr[0]){
            return binarysearch(arr,target,0,pivot-1);
        }
        return binarysearch(arr,target,pivot+1,arr.length-1);
    }

    public static int binarysearch(int[] arr, int target,int start,int end){

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
    public static int findPivot(int[] arr){
        int start = 0;
        int end = arr.length-1;
// 4 casese
        while(start<=end){
            int mid = start + (end-start)/2;

            if(mid < end && arr[mid] > arr[mid + 1]){
                return mid;
            }
            if(mid > start && arr[mid] < arr[mid - 1]){
                return mid - 1;
            }
            if(arr[mid] <= arr[start]){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return -1;
    }

    //for duplicate value
    public static int findPivotWithDuplicate(int[] arr){
        int start = 0;
        int end = arr.length-1;
// 4 casese
        while(start<=end){
            int mid = start + (end-start)/2;

            if(mid < end && arr[mid] > arr[mid + 1]){
                return mid;
            }
            if(mid > start && arr[mid] < arr[mid - 1]){
                return mid - 1;
            }
            //if elements at start, end, mid then skip duplicates
            if(arr[mid] == arr[start] && arr[mid] == arr[end]){
                if(arr[start] > arr[start+1]){
                    return start;
                }
                start++;
                if(arr[end] < arr[end-1]){
                    return end -1;
                }
                end--;
            }
            else if(arr[start] < arr[mid] || arr[start] == arr[mid] && arr[mid]>arr[end]){
                start = mid +1;
            }
            else{
                end = mid-1;
            }
        }
        return -1;
    }
}
