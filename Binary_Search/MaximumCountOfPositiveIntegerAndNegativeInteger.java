package Binary_Search;

import java.util.Arrays;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class MaximumCountOfPositiveIntegerAndNegativeInteger {
    /**
     * 2529. Maximum Count of Positive Integer and Negative Integer
     * Given an array nums sorted in non-decreasing order, return the maximum between the number of positive integers and the number of negative integers.
     *
     * In other words, if the number of positive integers in nums is pos and the number of negative integers is neg, then return the maximum of pos and neg.
     * Note that 0 is neither positive nor negative.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [-2,-1,-1,1,2,3]
     * Output: 3
     * Explanation: There are 3 positive integers and 3 negative integers. The maximum count among them is 3.
     * Example 2:
     *
     * Input: nums = [-3,-2,-1,0,0,1,2]
     * Output: 3
     * Explanation: There are 2 positive integers and 3 negative integers. The maximum count among them is 3.
     * Example 3:
     *
     * Input: nums = [5,20,66,1314]
     * Output: 4
     * Explanation: There are 4 positive integers and 0 negative integers. The maximum count among them is 4.
     *
     *
     * Constraints:
     *
     * 1 <= nums.length <= 2000
     * -2000 <= nums[i] <= 2000
     * nums is sorted in a non-decreasing order.
     *
     *
     * Follow up: Can you solve the problem in O(log(n)) time complexity?
     * */
    public static void main(String[] args) {
        int[] nums = {-3,-2,-1,1,2,3};
        System.out.println(maximumCount(nums));
    }

    //Solution 1 - Using Brute Force
    //Time Complexity - O(n)
    //Space Complexity - O(1)
    public static int maximumCount(int[] nums) {
        int n = nums.length;
        int neg = 0;
        int pos = 0;
        for (int i=0; i<n; i++){
            if (nums[i] < 0){
                neg++;
            }
            if (nums[i] > 0){
                pos++;
            }
        }
        return Math.max(neg,pos);
    }

    //Solution 2 - Using Streams
    //Time Complexity - O(n)
    //Space Complexity - O(1)
    public static int maximumCount2(int[] nums) {
        int n = nums.length;

        IntStream stream = Arrays.stream(nums);
        IntPredicate pos = res -> res > 0;
        IntPredicate neg = res -> res < 0;

        int positiveCount = (int) Arrays.stream(nums).filter(pos).count();
        int negativeCount = (int) Arrays.stream(nums).filter(neg).count();

        return Math.max(positiveCount, negativeCount);
    }

    //Solution 3 - Using Binary Search
    //Time Complexity - O(log(n))
    //Space Complexity - O(1)
    public static int maximumCount3(int[] nums) {
        int n = nums.length;

        int pos = lowerBound(nums,1);
        int neg = lowerBound(nums,0);

        return Math.max(n-pos, neg);
    }

    private static int lowerBound(int[] nums, int target) {
        int l=0;
        int r=nums.length-1;
        int result = nums.length;

        while(l<=r){
            int mid = l+(r-l)/2;
            if (nums[mid] <target){
                l=mid+1;
            } else {
                result = mid;
                r = mid-1;
            }
        }
        return result;
    }


}
