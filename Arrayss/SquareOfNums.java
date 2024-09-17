package Arrayss;

import java.util.Arrays;

public class SquareOfNums {
    public static void main(String[] args) {
        int[] nums = {-4,-3,-1,0,1,3,4,9};
        System.out.println(Arrays.toString(sortedSquares2(nums)));
    }

    /* APPROACH 1 - USING EXTRA SPACE
     * */
    public static int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];

        for(int i=0; i<nums.length; i++){
            result[i] = Math.abs(nums[i] * nums[i]);
        }

        Arrays.sort(result);
        return result;
    }

    /* APPROACH 2 - WITHOUT USING EXTRA SPACE
     * */
    public static int[] sortedSquares2(int[] nums) {

        for(int i=0; i<nums.length; i++){
            nums[i] = Math.abs(nums[i] * nums[i]);
        }

        Arrays.sort(nums);
        return nums;
    }

}
