package Arrayss.SlidingWindow;

public class MinimumOperationsToMakeBinaryArrayElementsEqualOneI {
    /**
     * 3191. Minimum Operations to Make Binary Array Elements Equal to One I
     * You are given a binary array nums.
     *
     * You can do the following operation on the array any number of times (possibly zero):
     *
     * Choose any 3 consecutive elements from the array and flip all of them.
     * Flipping an element means changing its value from 0 to 1, and from 1 to 0.
     *
     * Return the minimum number of operations required to make all elements in nums equal to 1. If it is impossible, return -1.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [0,1,1,1,0,0]
     *
     * Output: 3
     *
     * Explanation:
     * We can do the following operations:
     *
     * Choose the elements at indices 0, 1 and 2. The resulting array is nums = [1,0,0,1,0,0].
     * Choose the elements at indices 1, 2 and 3. The resulting array is nums = [1,1,1,0,0,0].
     * Choose the elements at indices 3, 4 and 5. The resulting array is nums = [1,1,1,1,1,1].
     * Example 2:
     *
     * Input: nums = [0,1,1,1]
     *
     * Output: -1
     *
     * Explanation:
     * It is impossible to make all elements equal to 1.
     *
     *
     *
     * Constraints:
     *
     * 3 <= nums.length <= 105
     * 0 <= nums[i] <= 1
     * */
    public static void main(String[] args) {
        int[] nums = {0,1,1,1,0,0};
        System.out.println(minOperations(nums));
    }

    //Solution 1 - Using Sliding Window
    //Time Complexity - O(n)
    //Space Complexity - O(1)
    public static int minOperations(int[] nums) {
        int n = nums.length;
        int count = 0;
        for (int s=0; s<n-2; s++){
            if (nums[s] == 0){
                nums[s] = 1 - nums[s];
                nums[s+1] = 1 - nums[s+1];
                nums[s+2] = 1 - nums[s+2];
                count++;
            }
        }

        if (nums[n-1] == 0 || nums[n-2] == 0)
            return -1;
        return count;
    }
}
