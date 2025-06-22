package Recursion;

import java.util.ArrayList;
import java.util.Collections;

public class SumOfAllSubsets {
    /**
     * Problem Statement: Given an array print all the sum of the subset generated from it, in the increasing order.
     *
     * Examples:
     *
     * Example 1:
     *
     * Input: N = 3, arr[] = {5,2,1}
     *
     * Output: 0,1,2,3,5,6,7,8
     *
     * Explanation: We have to find all the subset’s sum and print them.in this case the generated subsets
     * are [ [], [1], [2], [2,1], [5], [5,1], [5,2]. [5,2,1],so the sums we get will be  0,1,2,3,5,6,7,8
     *
     *
     * Input: N=3,arr[]= {3,1,2}
     *
     * Output: 0,1,2,3,3,4,5,6
     *
     * Explanation: We have to find all the subset’s sum and print them.in this case the generated subsets
     * are [ [], [1], [2], [2,1], [3], [3,1], [3,2]. [3,2,1],so the sums we get will be  0,1,2,3,3,4,5,6
     * */
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(5);
        arr.add(2);
        arr.add(1);
        int N = arr.size();
        ArrayList<Integer> result = subsetSums(arr, N);
        System.out.println(result); // Output: [0, 1, 2, 3, 5, 6, 7, 8]
    }

    //Solution 1: Using Recursion
    // Time Complexity: O(2^N) where N is the size of the array
    // Space Complexity: O(N) for the recursion stack
    static ArrayList<Integer> subsetSums(ArrayList < Integer > arr, int N) {
        ArrayList < Integer > sumSubset = new ArrayList < > ();
        subsetSumsHelper(0, 0, arr, N, sumSubset);
        Collections.sort(sumSubset);
        return sumSubset;
    }

    private static void subsetSumsHelper(int ind, int sum, ArrayList<Integer> arr, int N, ArrayList<Integer> sumSubset) {
        if (ind == N) {
            sumSubset.add(sum);
            return;
        }

        // Exclude the current element
        subsetSumsHelper(ind + 1, sum+arr.get(ind), arr, N, sumSubset);
        // Include the current element
        subsetSumsHelper(ind + 1, sum, arr, N, sumSubset);
    }

}
