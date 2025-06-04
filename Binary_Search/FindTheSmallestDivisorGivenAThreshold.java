package Binary_Search;

public class FindTheSmallestDivisorGivenAThreshold {
    /**
     * 1283. Find the Smallest Divisor Given a Threshold
     * Given an array of integers nums and an integer threshold, we will choose a positive integer divisor, divide all the array by it, and sum the division's result. Find the smallest divisor such that the result mentioned above is less than or equal to threshold.
     *
     * Each result of the division is rounded to the nearest integer greater than or equal to that element. (For example: 7/3 = 3 and 10/2 = 5).
     *
     * The test cases are generated so that there will be an answer.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,2,5,9], threshold = 6
     * Output: 5
     * Explanation: We can get a sum to 17 (1+2+5+9) if the divisor is 1.
     * If the divisor is 4 we can get a sum of 7 (1+1+2+3) and if the divisor is 5 the sum will be 5 (1+1+1+2).
     * Example 2:
     *
     * Input: nums = [44,22,33,11,1], threshold = 5
     * Output: 44
     *
     *
     * Constraints:
     *
     * 1 <= nums.length <= 5 * 104
     * 1 <= nums[i] <= 106
     * nums.length <= threshold <= 106
     * */
    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 9};
        int threshold = 6;
        System.out.println(smallestDivisor(nums, threshold)); // Output: 5

        nums = new int[]{44, 22, 33, 11, 1};
        threshold = 5;
        System.out.println(smallestDivisor(nums, threshold)); // Output: 44
    }

    //Solution 1: Brute Force Approach
    // Time Complexity: O(n * m) where n is the length of nums and m is the maximum element in nums.
    // Space Complexity: O(1)
    public static int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;

        for (int i=0; i<n; i++){
            max = Math.max(max, nums[i]);
        }


        for (int i=1; i<=max; i++){
            int sum = 0;
            for (int j=0; j<n; j++){
                sum += Math.ceil((double) nums[j] / i);
            }
            if (sum <= threshold) {
                return i;
            }
        }
        return -1;
    }

    //Solution 2: Binary Search Approach
    // Time Complexity: O(n * log(max)) where n is the length of nums and max is the maximum element in nums.
    // Space Complexity: O(1)
    public static int smallestDivisorBinarySearch(int[] nums, int threshold) {
        int left = 1;
        int right = Integer.MIN_VALUE;

        for (int num : nums) {
            right = Math.max(right, num);
        }

        while (left <= right){
            int mid = left + (right - left) / 2;
            int sum = 0;

            if (mid == 0) {
                return Integer.MAX_VALUE;
            }

            for (int num : nums) {
                sum += Math.ceil((double) num / mid);
            }

            if (sum <= threshold){
                right = mid -1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
