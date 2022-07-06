package Arrayss;

import java.util.Arrays;

public class longestConseq {
    public static void main(String[] args) {
        int[] nums = {9,1,4,7,3,-1,0,5,8,-1,6};
        System.out.println(longestConsecutive(nums));
    }
    public static int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int count = 1;
        if(nums.length == 0){
            return 0;
        }

        int maxLen = 0;
        for(int i=1; i<nums.length; i++){
            if(nums[i] == nums[i-1]+1){
                count++;
            }else if(nums[i] != nums[i - 1]) {
                maxLen = Math.max(maxLen, count);
                count = 1;
            }
        }
        maxLen = Math.max(maxLen, count); // update our mxLen
        return maxLen;
    }
}
