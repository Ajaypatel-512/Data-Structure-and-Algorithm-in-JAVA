package Binary_Search;

public class FindOutHowManyTimesHasAnArrayBeenRotated {
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(findRotationCount(nums)); // Output: 4
    }

    // Solution 1: Using Linear Search
    // Time Complexity: O(log n)
    // Space Complexity: O(1)
    public static int findRotationCount(int[] nums){
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        int index = -1;

        for (int i=0; i<n ;i++){
            if (nums[i] < ans){
                ans = nums[i];
                index = i;
            }
        }
        return index;
    }

    // Solution 2: Using Binary Search
    // Time Complexity: O(log n)
    // Space Complexity: O(1)
    public static int findRotationCount2(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        int ans = Integer.MAX_VALUE;
        int index = -1;

        while (low <= high) {
            if (nums[low] <= nums[high]) {
                return low;
            }
            int mid = low + (high - low) / 2;

            if (nums[mid] >= nums[low]) {
                if (nums[low] < ans) {
                    index = low;
                    ans = nums[low];
                }
                low = mid +1;
            } else {
                if (nums[mid] < ans) {
                    index = mid;
                    ans = nums[mid];
                }
                high = mid - 1;
            }
        }
        return index;
    }


}
