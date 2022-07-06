package Sorting;
//645. Set Mismatch
//        You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set, which results in repetition of one number and loss of another number.
//
//        You are given an integer array nums representing the data status of this set after the error.
//
//        Find the number that occurs twice and the number that is missing and return them in the form of an array.
//
//        Example 1:
//
//        Input: nums = [1,2,2,4]
//        Output: [2,3]
//        Example 2:
//
//        Input: nums = [1,1]
//        Output: [1,2]

public class SetMisMatch {
    public static void main(String[] args) {

    }
    public int[] findErrorNums(int[] nums) {
        int i=0;
        int[] ans = new int[nums.length];
        while(i<nums.length){
            int correct = nums[i]-1;
            if(nums[i] != nums[correct]){
                swappArray(nums,i,correct);
            }else {
                i++;
            }
        }

        for(int j=0; j<nums.length; j++){
            if(nums[j] != j+1){
                return new int[]{nums[j],j+1};
            }
        }
        return new int[]{-1,-1};
    }

    public void swappArray(int[] arr, int first, int second){
        int temp  = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
