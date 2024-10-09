package Arrayss;

import java.util.Arrays;

public class ThreeSumClosest {

    /**
     * 16. 3Sum Closest
     *
     * Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
     *
     * Return the sum of the three integers.
     *
     * You may assume that each input would have exactly one solution.
     *
     * Example 1:
     *
     * Input: nums = [-1,2,1,-4], target = 1
     * Output: 2
     * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
     * Example 2:
     *
     * Input: nums = [0,0,0], target = 1
     * Output: 0
     * Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
     * */

    public static void main(String[] args) {
        int[] arr = {-1, 2, 1, -4};
        int target = 1;

        System.out.println(threeSumClosest(arr,target));
    }

    //Solution 1 Using 2 Sum Technique
    public static int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        int closestSum = Integer. MAX_VALUE;

        Arrays.sort(nums);

        for(int k=0; k<=n-3; k++){
            int i=k+1;
            int j = n-1;

            while(i<j){
                int sum = nums[i]+nums[j]+nums[k];

                if(Math.abs(target-sum) < Math.abs(target-closestSum)){
                    closestSum = sum;
                }
                if(sum < target){
                    i++;
                } else{
                    j--;
                }
            }
        }
        return closestSum;
    }
}
