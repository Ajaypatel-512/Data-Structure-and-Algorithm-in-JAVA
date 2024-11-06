package Arrayss;

public class FindArrayCanBeSorted {
    public static void main(String[] args) {
        int[] num = {3,16,8,4,2};
        System.out.println(canSortArray(num));
    }


    //Solution 1 Using Bubble Sort O(n^2) O(1)
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
}
