package Binary_Search;

public class SearchInsertPosition {
    /**
     * 35. Search Insert Position
     * Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
     *
     * You must write an algorithm with O(log n) runtime complexity.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,3,5,6], target = 5
     * Output: 2
     * Example 2:
     *
     * Input: nums = [1,3,5,6], target = 2
     * Output: 1
     * Example 3:
     *
     * Input: nums = [1,3,5,6], target = 7
     * Output: 4
     *
     *
     * Constraints:
     *
     * 1 <= nums.length <= 104
     * -104 <= nums[i] <= 104
     * nums contains distinct values sorted in ascending order.
     * -104 <= target <= 104
     * */
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 5;
        int result = searchInsert(nums, target);
        System.out.println("The target " + target + " should be inserted at index: " + result);
    }


    //Solution 1: Using lower Bound
    //Time Complexity: O(log n)
    //Space Complexity: O(1)
    public static int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        int ans = n;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if (nums[mid] >= target ){
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
