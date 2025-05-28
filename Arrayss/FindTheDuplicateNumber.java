package Arrayss;

import java.util.Arrays;

public class FindTheDuplicateNumber {
    /**
     * 287. Find the Duplicate Number
     * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
     *
     * There is only one repeated number in nums, return this repeated number.
     *
     * You must solve the problem without modifying the array nums and using only constant extra space.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,3,4,2,2]
     * Output: 2
     * Example 2:
     *
     * Input: nums = [3,1,3,4,2]
     * Output: 3
     * Example 3:
     *
     * Input: nums = [3,3,3,3,3]
     * Output: 3
     *
     *
     * Constraints:
     *
     * 1 <= n <= 105
     * nums.length == n + 1
     * 1 <= nums[i] <= n
     * All the integers in nums appear only once except for precisely one integer which appears two or more times.
     *
     *
     * Follow up:
     *
     * How can we prove that at least one duplicate number must exist in nums?
     * Can you solve the problem in linear runtime complexity?
     * */
    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 2};
        System.out.println(findDuplicate(nums));
    }

    //Solution 1: Using Linear Search
    //Time Complexity: O(n*2)
    //Space Complexity: O(1)
    public static int findDuplicate(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }
        return -1;
    }

    //Solution 2: Using Sorting
    //Time Complexity: O(n log n)
    //Space Complexity: O(1)
    public static int findDuplicate2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return nums[i];
            }
        }
        return -1;
    }

    //Solution 3: Using Frequency Array
    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public static int findDuplicate3(int[] nums) {
        int n = nums.length;
        int freq[] = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (freq[nums[i]] == 0) {
                freq[nums[i]] += 1;
            } else {
                return nums[i];
            }
        }
        return 0;
    }

    //Solution 4: Using LinkedList to detect cycle (Floyd's Tortoise and Hare)
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public static int findDuplicate4(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        // Phase 1: Finding the intersection point
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Phase 2: Finding the entrance to the cycle
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }


}
