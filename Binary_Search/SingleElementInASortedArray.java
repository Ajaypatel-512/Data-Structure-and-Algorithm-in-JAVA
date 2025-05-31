package Binary_Search;

public class SingleElementInASortedArray {
    /**
     * 540. Single Element in a Sorted Array
     * You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.
     *
     * Return the single element that appears only once.
     *
     * Your solution must run in O(log n) time and O(1) space.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,1,2,3,3,4,4,8,8]
     * Output: 2
     * Example 2:
     *
     * Input: nums = [3,3,7,7,10,11,11]
     * Output: 10
     *
     *
     * Constraints:
     *
     * 1 <= nums.length <= 105
     * 0 <= nums[i] <= 105
     * */
    public static void main(String[] args) {
        int[] arr = {1,1,2,3,3,4,4,8,8};
        System.out.println(singleNonDuplicate(arr)); // Output: 2
    }

    //Solution 1: Using Xor
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public static int singleNonDuplicate(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    //Solution 2: Using Binary Search
    // Time Complexity: O(log n)
    // Space Complexity: O(1)
    public static int singleNonDuplicateBinarySearch(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (mid % 2 == 1) {
                mid--;
            }

            if (nums[mid] == nums[mid + 1]) {
                low = mid + 2;
            } else {
                high = mid;
            }
        }
        return nums[low];
    }
}
