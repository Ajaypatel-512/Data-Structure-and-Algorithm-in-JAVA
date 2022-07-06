package Sorting;
//448. Find All Numbers Disappeared in an Array
//
//        Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.
//
//        Example 1:
//
//        Input: nums = [4,3,2,7,8,2,3,1]
//        Output: [5,6]
//        Example 2:
//
//        Input: nums = [1,1]
//        Output: [2]


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DisaapearedNo {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> ans = findDisappearedNumbers(nums);
        System.out.println(ans);
    }
    public static List<Integer> findDisappearedNumbers(int[] nums) {
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
                ans.add(j+1);
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
