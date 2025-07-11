package Stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {
    /**
     * 503. Next Greater Element II
     * Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.
     *
     * The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,2,1]
     * Output: [2,-1,2]
     * Explanation: The first 1's next greater number is 2;
     * The number 2 can't find next greater number.
     * The second 1's next greater number needs to search circularly, which is also 2.
     * Example 2:
     *
     * Input: nums = [1,2,3,4,3]
     * Output: [2,3,4,-1,4]
     *
     *
     * Constraints:
     *
     * 1 <= nums.length <= 104
     * -109 <= nums[i] <= 109
     * */
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,3};
        int[] result = nextGreaterElements(nums);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    //Solution 1: Brute Force Approach
    // Time Complexity: O(n^2)
    // Space Complexity: O(n)
    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);

        for (int i=0; i<n; i++){
            boolean flag = false;
            for (int j=i+1; j<n; j++){
                if (nums[j] > nums[i]) {
                    result[i] = nums[j];
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                for (int j = 0; j < i; j++) {
                    if (nums[j] > nums[i]) {
                        result[i] = nums[j];
                        break;
                    }
                }
            }
        }
        return result;
    }

    //Solution 2: Using % operator
    // Time Complexity: O(n^2)
    // Space Complexity: O(n)
    public static int[] nextGreaterElements2(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);

        for (int i = 0; i < n; i++) {
           for (int j = i+1; j < i + n; j++) {
                int idx = j% n;
                if (nums[idx] > nums[i]) {
                    result[i] = nums[idx];
                    break;
                }
            }
        }
        return result;
    }

    //Solution 3: Using Stack
    // Time Complexity: O(4n) where n is the length of the input array, 2n for the first pass and 2n for the second pass.
    // Space Complexity: O(2n+n) where 2n for the stack and n for the result array.
    public static int[] nextGreaterElements3(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();

        for (int i = 2*n-1; i>=0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i % n]) {
                stack.pop();
            }
            if (i < n) {
                result[i] = stack.isEmpty() ? -1 :stack.peek();
            }
            stack.push(nums[i % n]);
        }
        return result;
    }

}
