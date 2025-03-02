package Arrayss;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ApplyOperationsToAnArray {
    /**
     * 2460. Apply Operations to an Array
     * You are given a 0-indexed array nums of size n consisting of non-negative integers.
     *
     * You need to apply n - 1 operations to this array where, in the ith operation (0-indexed), you will apply the following on the ith element of nums:
     *
     * If nums[i] == nums[i + 1], then multiply nums[i] by 2 and set nums[i + 1] to 0. Otherwise, you skip this operation.
     * After performing all the operations, shift all the 0's to the end of the array.
     *
     * For example, the array [1,0,2,0,0,1] after shifting all its 0's to the end, is [1,2,1,0,0,0].
     * Return the resulting array.
     *
     * Note that the operations are applied sequentially, not all at once.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,2,2,1,1,0]
     * Output: [1,4,2,0,0,0]
     * Explanation: We do the following operations:
     * - i = 0: nums[0] and nums[1] are not equal, so we skip this operation.
     * - i = 1: nums[1] and nums[2] are equal, we multiply nums[1] by 2 and change nums[2] to 0. The array becomes [1,4,0,1,1,0].
     * - i = 2: nums[2] and nums[3] are not equal, so we skip this operation.
     * - i = 3: nums[3] and nums[4] are equal, we multiply nums[3] by 2 and change nums[4] to 0. The array becomes [1,4,0,2,0,0].
     * - i = 4: nums[4] and nums[5] are equal, we multiply nums[4] by 2 and change nums[5] to 0. The array becomes [1,4,0,2,0,0].
     * After that, we shift the 0's to the end, which gives the array [1,4,2,0,0,0].
     * Example 2:
     *
     * Input: nums = [0,1]
     * Output: [1,0]
     * Explanation: No operation can be applied, we just shift the 0 to the end.
     *
     *
     * Constraints:
     *
     * 2 <= nums.length <= 2000
     * 0 <= nums[i] <= 1000
     * */
    public static void main(String[] args) {
        int[] nums = {1,2,2,1,1,0};
        int[] result = applyOperations(nums);
        System.out.println(Arrays.toString(result));
    }

    //Solution 1 - Using Brute Force
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public static int[] applyOperations(int[] nums) {
        int n = nums.length;

        // Step 1: Apply operations
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1] && nums[i] != 0) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }

        // Step 2: Shift non-zero elements forward
        int[] result = new int[n];
        int index = 0;
        for (int num : nums) {
            if (num != 0) {
                result[index++] = num;
            }
        }

        return result;
    }

    //Solution 2 - Using Two Pointers
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public static int[] applyOperations2(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1] && nums[i] != 0) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }

        int insertPos = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[insertPos++] = num;
            }
        }

        while (insertPos < n) {
            nums[insertPos++] = 0;
        }

        return nums;
    }

    //Solution 3 - Using Queue
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public static int[] applyOperations3(int[] nums) {
        int n = nums.length;
        Queue<Integer> queue = new LinkedList<>();

        // Step 1: Apply operations
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1] && nums[i] != 0) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }

        // Step 2: Store non-zero elements in a queue
        for (int num : nums) {
            if (num != 0) {
                queue.offer(num);
            }
        }

        // Step 3: Fill the array using queue
        int index = 0;
        while (!queue.isEmpty()) {
            nums[index++] = queue.poll();
        }

        // Fill the rest with zeros
        while (index < n) {
            nums[index++] = 0;
        }

        return nums;
    }
}
