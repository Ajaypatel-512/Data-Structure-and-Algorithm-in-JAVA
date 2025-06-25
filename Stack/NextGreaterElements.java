package Stack;

import java.util.Stack;

public class NextGreaterElements {
    /**
     * 496. Next Greater Element I
     * The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.
     *
     * You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.
     *
     * For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2. If there is no next greater element, then the answer for this query is -1.
     *
     * Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.
     *
     *
     *
     * Example 1:
     *
     * Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
     * Output: [-1,3,-1]
     * Explanation: The next greater element for each value of nums1 is as follows:
     * - 4 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
     * - 1 is underlined in nums2 = [1,3,4,2]. The next greater element is 3.
     * - 2 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
     * Example 2:
     *
     * Input: nums1 = [2,4], nums2 = [1,2,3,4]
     * Output: [3,-1]
     * Explanation: The next greater element for each value of nums1 is as follows:
     * - 2 is underlined in nums2 = [1,2,3,4]. The next greater element is 3.
     * - 4 is underlined in nums2 = [1,2,3,4]. There is no next greater element, so the answer is -1.
     *
     *
     * Constraints:
     *
     * 1 <= nums1.length <= nums2.length <= 1000
     * 0 <= nums1[i], nums2[i] <= 104
     * All integers in nums1 and nums2 are unique.
     * All the integers of nums1 also appear in nums2.
     *
     *
     * Follow up: Could you find an O(nums1.length + nums2.length) solution?
     * */
    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        int[] result = nextGreaterElement(nums1, nums2);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    //Solution 1: Brute Force Approach
    // Time Complexity: O(n^2)
    //Space Complexity: O(n)
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j<n; j++){
                if (nums1[j] > nums1[i]) {
                    result[i] = nums1[j];
                    break;
                } else {
                    result[i] = -1;
                }
            }
        }
        result[n - 1] = -1;
        return result;
    }

    //Solution 2: Using Stack
    // Time Complexity: O(2n)
    //Space Complexity: O(2n)
    public static int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        int n = nums1.length;
        int[] result = new int[n];

        for (int i=n-1; i>=0; i--){
            while (!stack.isEmpty() && nums1[i] >= stack.peek()) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }
            stack.push(nums1[i]);
        }
        return result;
    }


    //Solution 3: Using Stack with nums2 Original Answer
    // Time Complexity: O(n1 + n2)
    //Space Complexity: O(n2)
    public int[] nextGreaterElement3(int[] nums1, int[] nums2) {
        int n2 = nums2.length;
        int[] ans = new int[n2];
        Stack<Integer> stack = new Stack<>();

        for (int i = n2 - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums2[i] > stack.peek()) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = stack.peek();
            }
            stack.push(nums2[i]);
        }

        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < n2; j++) {
                if (nums2[j] == nums1[i]) {
                    res[i] = ans[j];
                    break;
                }
            }
        }

        return res;
    }


}
