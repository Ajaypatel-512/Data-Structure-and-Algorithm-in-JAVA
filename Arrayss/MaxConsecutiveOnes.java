package Arrayss;

public class MaxConsecutiveOnes {
    /**
     * 485. Max Consecutive Ones
     * Given a binary array nums, return the maximum number of consecutive 1's in the array.
     *
     * Example 1:
     *
     * Input: nums = [1,1,0,1,1,1]
     * Output: 3
     * Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
     * Example 2:
     *
     * Input: nums = [1,0,1,1,0,1]
     * Output: 2
     *
     *
     * Constraints:
     *
     * 1 <= nums.length <= 105
     * nums[i] is either 0 or 1.
     * */
    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 1, 1, 1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }

    //Solution 1: Using a single loop to count consecutive 1's
    //Time Complexity: O(n)
    // Space Complexity: O(1)
    public static int findMaxConsecutiveOnes(int[] nums) {
        int max_count = 0;
        int n = nums.length;
        int current_count = 0;
        for(int i=0; i<n; i++){
            if(nums[i] == 1){
                current_count++;
                if(current_count > max_count){
                    max_count = current_count;
                }
            } else {
                current_count = 0;
            }
        }
        return max_count;
    }
}
