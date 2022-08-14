package Arrayss;

import java.util.Arrays;

public class moveZeros {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {
        int count = 0;
        int n = nums.length;
        for(int i=0; i<n; i++){
            if(nums[i] != 0){
                int temp = nums[i];
                nums[i] = nums[count];
                nums[count] = temp;
                count++;
            }
        }
    }
}
