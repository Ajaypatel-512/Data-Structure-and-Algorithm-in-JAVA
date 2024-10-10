package Arrayss;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaximumWidthRamp {

    /**
     * 962. Maximum Width Ramp
     *
     * A ramp in an integer array nums is a pair (i, j) for which i < j and nums[i] <= nums[j]. The width of such a ramp is j - i.
     *
     * Given an integer array nums, return the maximum width of a ramp in nums. If there is no ramp in nums, return 0.
     *
     *
     * Example 1:
     *
     * Input: nums = [6,0,8,2,1,5]
     * Output: 4
     * Explanation: The maximum width ramp is achieved at (i, j) = (1, 5): nums[1] = 0 and nums[5] = 5.
     * Example 2:
     *
     * Input: nums = [9,8,1,0,1,9,4,0,4,1]
     * Output: 7
     * Explanation: The maximum width ramp is achieved at (i, j) = (2, 9): nums[2] = 1 and nums[9] = 1.
     * */

    public static void main(String[] args) {
        int[] arr = {9,8,1,0,1,9,4,0,4,1};
        System.out.println(maxWidthRamp(arr));
    }

    // Solution 1 - O(N2) O(N)
    public static int maxWidthRamp(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;

        for(int i=0; i<n-1; i++){
            for (int j=i+1; j<n; j++){
                if(nums[i] <= nums[j]){
                    set.add(j-i);
                }
            }
        }
        return set.isEmpty() ? 0 : Collections.max(set);
    }

    // Solution 2 - O(N2) O(1)
    public static int maxWidthRam2(int[] nums) {
        int n = nums.length;
        int maxWidth = 0;
        boolean flag = false;
        for (int i=1; i<n; i++){
            if (nums[i] >= nums[i-1]){
                flag = true;
            }
        }
        if (!flag){
            return 0;
        }

        for(int i=0; i<n; i++){
            for (int j=i+maxWidth; j<n; j++){
                if(nums[i] <= nums[j]){
                    maxWidth = Math.max(maxWidth,j-i);
                }
            }
        }
        return maxWidth;
    }
}
