package Arrayss.PrefixSum;

import java.util.Arrays;

public class MaxXORForEachQuery {
    public static void main(String[] args) {
        int[] nums = {0,1,1,3};
        int maximumBit = 2;

        var result = getMaximumXor2(nums,maximumBit);
        System.out.println(Arrays.toString(result));
    }

    //Solution 1 O(n^2) O(n)
    public static int[] getMaximumXor(int[] nums, int maximumBit) {
        int k = (int) Math.pow(2,maximumBit);
        int[] result = new int[nums.length];

        for (int i=0; i<nums.length; i++){
            int xor = nums[0];
            for (int c=1; c<=nums.length-1-i; c++){
                xor = xor ^ nums[c];
            }
            result[i] = 0;
            int maxXor = xor ^ 0;
            for (int j=1; j<k; j++){
                int maxXorJ = xor ^ j;
                if (maxXorJ > maxXor){
                    result[i] = j;
                    maxXor = maxXorJ;
                }
            }

        }
        return result;
    }


    //Solution 1 O(n) O(n)
    public static int[] getMaximumXor2(int[] nums, int maximumBit) {
        int n = nums.length;
        int[] result = new int[n];

        int xor = 0;
        for (int num:nums){
            xor = xor ^ num;
        }

        int mask = (1 << maximumBit) - 1;

        for (int i=0; i<n; i++){
            int k = xor^mask;
            result[i] = k;
            xor = xor ^ nums[n-i-1];
        }
        return result;
    }
}
