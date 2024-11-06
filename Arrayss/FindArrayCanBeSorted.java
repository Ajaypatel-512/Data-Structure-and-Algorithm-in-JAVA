package Arrayss;

public class FindArrayCanBeSorted {
    public static void main(String[] args) {
        int[] num = {3,16,8,4,2};
        System.out.println(canSortArray2(num));
    }


    //Approach-1 (Using Bubble sorting algo)
    //T.C : O(n^2)
    //S.C : O(1)
    public static boolean canSortArray(int[] nums) {
        boolean swapped = true;
        for (int i=0; i<nums.length; i++){
            swapped = false;
            for (int j=0; j<nums.length-i-1; j++){
                if (nums[j] <= nums[j+1]){
                    continue;
                } else {

                    if (Integer.bitCount(nums[j]) == Integer.bitCount(nums[j+1])){
                        int temp = nums[j];
                        nums[j] = nums[j + 1];
                        nums[j + 1] = temp;
                        swapped = true;
                    } else {
                        return false;
                    }
                }
            }
            if (!swapped){
                break;
            }
        }
        return true;
    }


    //Approach-2 (Using simple segment sorting check)
    //T.C : O(n)
    //S.C : O(1)
    public static boolean canSortArray2(int[] nums) {
        int n = nums.length;

        int bitCount0 = Integer.bitCount(nums[0]);
        int maxOfSegment = nums[0];
        int minOfSegment = nums[0];
        int maxOfPrevSegment = Integer.MIN_VALUE;

        for (int i=1; i<n; i++){
            int bitCount = Integer.bitCount(nums[i]);
            if (bitCount0 == bitCount){
                maxOfSegment = Math.max(maxOfSegment, nums[i]);
                minOfSegment = Math.min(minOfSegment, nums[i]);
            } else {
                if (minOfSegment < maxOfPrevSegment) {
                    return false;
                }
                maxOfPrevSegment = maxOfSegment;

                maxOfSegment = nums[i];
                minOfSegment = nums[i];
                bitCount0 = Integer.bitCount(nums[i]);
            }
        }
        if (minOfSegment < maxOfPrevSegment) {
            return false;
        }
        return true;

        }
}
