package Sorting;
//    41. First Missing Positive
//            Hard
//    Given an unsorted integer array nums, return the smallest missing positive integer.
//
//    You must implement an algorithm that runs in O(n) time and uses constant extra space.
//    Example 1:
//
//    Input: nums = [1,2,0]
//    Output: 3
//    Example 2:
//
//    Input: nums = [3,4,-1,1]
//    Output: 2
//    Example 3:
//
//    Input: nums = [7,8,9,11,12]
//    Output: 1
public class FirstMissingPositive {
    public static void main(String[] args) {

    }
    public int firstMissingPositive(int[] nums) {
        int i=0;
        while(i<nums.length){
            int correct = nums[i]-1;
            if(nums[i] > 0 && nums[i] <=nums.length && nums[i] != nums[correct]){
                swappArray(nums,i,correct);
            }else {
                i++;
            }
        }

        for(int j=0; j<nums.length; j++){
            if(nums[j] != j+1){
                return j+1;
            }
        }
        return nums.length+1;
    }

    public void swappArray(int[] arr, int first, int second){
        int temp  = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
