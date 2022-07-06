package Sorting;

import java.util.ArrayList;
import java.util.List;

//442. Find All Duplicates in an Array
//        Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each integer appears once or twice, return an array of all the integers that appears twice.
//
//        You must write an algorithm that runs in O(n) time and uses only constant extra space.
//
//        Example 1:
//
//        Input: nums = [4,3,2,7,8,2,3,1]
//        Output: [2,3]
//        Example 2:
//
//        Input: nums = [1,1,2]
//        Output: [1]
//        Example 3:
//
//        Input: nums = [1]
//        Output: []

public class AllDuplicate {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> ans = findDuplicates(nums);
        System.out.println(ans);
    }

    public static List<Integer> findDuplicates(int[] nums) {
        int temp = 0;
        int i = 0;
        List<Integer> ans = new ArrayList<>();
        while(i<nums.length) {
            int correct_index = nums[i] - 1;
            if (nums[i] != nums[correct_index]) {
                swappArray(nums, i, correct_index);
            }else {
                i++;
            }
        }
        for (int j = 0; j < nums.length; j++) {
            if(nums[j] != j+1){
                ans.add(nums[j]);
            }
        }
        return ans;
    }
    static void swappArray(int[] arr,int first, int second){
        int temp  = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
