package Binary_Search;

public class FindMinimumInRotatedSortedArray {
    /**
     *
     * */
    public static void main(String[] args) {

    }

    //Solution 1: Using Linear Search
    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public static int findMin(int[] nums) {
        int result = Integer.MAX_VALUE;
        int n = nums.length;
        for(int num: nums){
            result = Math.min(num,result);
        }
        return result;
    }

    //Solution 2: Using Binary Search
    //Time Complexity: O(log n)
    //Space Complexity: O(1)
    public static int findMin2(int[] nums) {
        int result = Integer.MAX_VALUE;
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        while (low <= high){
            int mid = low + (high-low)/2;

            if (nums[low] <= nums[high]) {
                result = Math.min(result, nums[low]);
                break;
            }

            if (nums[low] <= nums[mid]){
                result = Math.min(result, nums[low]);
                low = mid + 1;
            } else {
                result = Math.min(result, nums[mid]);
                high = mid - 1;
            }
        }
        return result;
    }


}
