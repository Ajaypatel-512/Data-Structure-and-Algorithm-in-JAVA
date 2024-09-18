package String;

import java.util.Arrays;

public class LargestNumber {
    /**
     * Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.
     *
     * Since the result may be very large, so you need to return a string instead of an integer.
     *
     * Example 1:
     *
     * Input: nums = [10,2]
     * Output: "210"
     */

    public static void main(String[] args) {
        int[] nums = {3, 30, 34, 5, 9};
        System.out.println(largestNumber(nums));
    }

    public static String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];
        for(int i=0; i<nums.length; i++){
            arr[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(arr,(a, b) -> (b+a).compareTo(a+b));

        if(arr[0].equals("0")){
            return "0";
        }

        StringBuilder largestNumber = new StringBuilder();
        for (String num : arr) {
            largestNumber.append(num);
        }

        return largestNumber.toString();
    }
}
