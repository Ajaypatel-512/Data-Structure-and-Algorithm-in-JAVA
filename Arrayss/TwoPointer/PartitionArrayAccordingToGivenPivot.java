package Arrayss.TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PartitionArrayAccordingToGivenPivot {
    /**
     * 2161. Partition Array According to Given Pivot
     * You are given a 0-indexed integer array nums and an integer pivot. Rearrange nums such that the following conditions are satisfied:
     *
     * Every element less than pivot appears before every element greater than pivot.
     * Every element equal to pivot appears in between the elements less than and greater than pivot.
     * The relative order of the elements less than pivot and the elements greater than pivot is maintained.
     * More formally, consider every pi, pj where pi is the new position of the ith element and pj is the new position of the jth element. If i < j and both elements are smaller (or larger) than pivot, then pi < pj.
     * Return nums after the rearrangement.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [9,12,5,10,14,3,10], pivot = 10
     * Output: [9,5,3,10,10,12,14]
     * Explanation:
     * The elements 9, 5, and 3 are less than the pivot so they are on the left side of the array.
     * The elements 12 and 14 are greater than the pivot so they are on the right side of the array.
     * The relative ordering of the elements less than and greater than pivot is also maintained. [9, 5, 3] and [12, 14] are the respective orderings.
     * Example 2:
     *
     * Input: nums = [-3,4,3,2], pivot = 2
     * Output: [-3,2,4,3]
     * Explanation:
     * The element -3 is less than the pivot so it is on the left side of the array.
     * The elements 4 and 3 are greater than the pivot so they are on the right side of the array.
     * The relative ordering of the elements less than and greater than pivot is also maintained. [-3] and [4, 3] are the respective orderings.
     *
     *
     * Constraints:
     *
     * 1 <= nums.length <= 105
     * -106 <= nums[i] <= 106
     * pivot equals to an element of nums.
     * */
    public static void main(String[] args) {
        int[] nums = {9,12,5,10,14,3,10};
        int pivot = 10;
        int[] result = pivotArray(nums, pivot);
        System.out.println(Arrays.toString(result));
    }

    //Solution 1 : Using 3 Lists
    //Time Complexity : O(n)
    //Space Complexity : O(n)
    public static int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        List<Integer> lower = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> higher = new ArrayList<>();

        for(int i=0; i<n; i++){
            if(nums[i] < pivot){
                lower.add(nums[i]);
            }else if(nums[i] == pivot){
                equal.add(nums[i]);
            }
            else{
                higher.add(nums[i]);
            }
        }

        int[] result = new int[n];
        for(int i = 0; i<lower.size(); i++){
            result[i] = lower.get(i);
        }
        for(int i = 0; i<equal.size(); i++){
            result[lower.size() + i] = equal.get(i);
        }
        for(int i = 0; i<higher.size(); i++){
            result[lower.size() + equal.size() + i] = higher.get(i);
        }
        return result;
    }


    //Solution 2 : Using 3 Pointers
    //Time Complexity : O(n)
    //Space Complexity : O(n)
    public static int[] pivotArray2(int[] nums, int pivot) {
        int n = nums.length;
        int[] result = new int[n];

        int lower = 0;
        int equal = 0;

        for (int i = 0; i<n; i++) {
            if (nums[i] < pivot) {
                lower++;
            }
            if (nums[i] == pivot) {
                equal++;
            }
        }

        int lowerPointer = 0;
        int equalPointer = lower;
        int higherPointer = lower + equal;
        for (int i=0; i<n;i++){
            if (nums[i] < pivot) {
                result[lowerPointer] = nums[i];
                lowerPointer++;
            }
            if (nums[i] == pivot) {
                result[equalPointer] = nums[i];
                equalPointer++;
            }
            if (nums[i] > pivot) {
                result[higherPointer] = nums[i];
                higherPointer++;
            }
        }

        return result;
    }

    //Solution 3 : Using 2 Pointers
    //Time Complexity : O(n)
    //Space Complexity : O(n)
    public static int[] pivotArray3(int[] nums, int pivot) {
        int n = nums.length;
        int[] result = new int[n];

        int i = 0;
        int j = n-1;

        int x = 0;
        int y = n-1;

        while (i < n && j >= 0){
            if (nums[i] < pivot){
                result[x] = nums[i];
                x++;
            }

            if (nums[j] > pivot){
                result[y] = nums[j];
                y--;
            }
            i++;
            j--;
        }

        while(x<=y){
            result[x] = pivot;
            x++;
        }

        return result;
    }


}
