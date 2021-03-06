package Binary_Search;

//410. Split Array Largest Sum
//        Hard
//        Given an array nums which consists of non-negative integers and an integer m, you can split the array into m non-empty continuous subarrays.
//
//        Write an algorithm to minimize the largest sum among these m subarrays.
//
//
//
//        Example 1:
//
//        Input: nums = [7,2,5,10,8], m = 2
//        Output: 18
//        Explanation:
//        There are four ways to split nums into two subarrays.
//        The best way is to split it into [7,2,5] and [10,8],
//        where the largest sum among the two subarrays is only 18.
//        Example 2:
//
//        Input: nums = [1,2,3,4,5], m = 2
//        Output: 9
//        Example 3:
//
//        Input: nums = [1,4,4], m = 3
//        Output: 4

public class SplitArrayLargestSum {
    public static void main(String[] args) {

    }

    public int splitArray(int[] nums, int m) {
        int start = 0;
        int end = 0;

        for(int i=0; i<nums.length; i++){
            start = Math.max(start,nums[i]);
            end += nums[i];
        }

        while (start<end){
            int mid = start + (end-start)/2;

            int sum=0;
            int pieces = 1;
            for (int num:nums) {
                if(sum + num > mid){
                    sum = num;
                    pieces++;
                }else{
                    sum += num;
                }
            }
            if (pieces>m) {
                start = mid + 1;

            }else {
                sum = mid;
            }
        }
        return end;
    }
}
