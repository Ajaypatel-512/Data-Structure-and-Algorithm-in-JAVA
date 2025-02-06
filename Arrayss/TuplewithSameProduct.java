package Arrayss;

import java.util.*;

public class TuplewithSameProduct {
    /**
     * 1726. Tuple with Same Product
     * Given an array nums of distinct positive integers, return the number of tuples (a, b, c, d) such that a * b = c * d where a, b, c, and d are elements of nums, and a != b != c != d.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [2,3,4,6]
     * Output: 8
     * Explanation: There are 8 valid tuples:
     * (2,6,3,4) , (2,6,4,3) , (6,2,3,4) , (6,2,4,3)
     * (3,4,2,6) , (4,3,2,6) , (3,4,6,2) , (4,3,6,2)
     * Example 2:
     *
     * Input: nums = [1,2,4,5,10]
     * Output: 16
     * Explanation: There are 16 valid tuples:
     * (1,10,2,5) , (1,10,5,2) , (10,1,2,5) , (10,1,5,2)
     * (2,5,1,10) , (2,5,10,1) , (5,2,1,10) , (5,2,10,1)
     * (2,10,4,5) , (2,10,5,4) , (10,2,4,5) , (10,2,5,4)
     * (4,5,2,10) , (4,5,10,2) , (5,4,2,10) , (5,4,10,2)
     *
     *
     * Constraints:
     *
     * 1 <= nums.length <= 1000
     * 1 <= nums[i] <= 104
     * All elements in nums are distinct.
     * */
    public static void main(String[] args) {
        int[] nums = {2,3,4,6};
        System.out.println(tupleSameProduct2(nums));
    }

    //Solution 1 : Brute Force
    //Time Complexity : O(n^4)
    //Space Complexity : O(1)
    public static int tupleSameProduct(int[] nums) {
        int n = nums.length;
        int count = 0;
        for(int i=0; i<n; i++){
            for (int j = i+1; j<n; j++){
                for (int k = 0; k<n; k++){
                    for(int l = k+1; l<n; l++){
                        if (i != k && i!= l && j!=k && j!=l) {
                            int p1 = nums[i] * nums[j];
                            int p2 = nums[k] * nums[l];
                            if (p1 == p2) {
                                count++;
                            }
                        }
                    }
                }
            }
        }
        return (count/2)*8;
    }

    //Solution 2 : Brute Force
    //Time Complexity : O(n^4)
    //Space Complexity : O(1)
    public static int tupleSameProduct2(int[] nums) {
        int n = nums.length;
        int count = 0;
        Arrays.sort(nums);
        for(int i=0; i<n; i++){
            for (int j = n-1; j>i; j--){
                for (int k = i+1; k<j; k++){
                    for(int l = j-1; l>k; l--){
                        if (i != k && i!= l && j!=k && j!=l) {
                            int p1 = nums[i] * nums[j];
                            int p2 = nums[k] * nums[l];
                            if (p1 == p2) {
                                count++;
                            }
                        }
                    }
                }
            }
        }
        return (count)*8;
    }

    //Solution 3 : Optimized
    //Time Complexity : O(n^3)
    //Space Complexity : O(n)
    public static int tupleSameProduct3(int[] nums) {
        int n = nums.length;
        int count = 0;
        Arrays.sort(nums);

        for(int i=0; i<n; i++){
            for (int j = n-1; j>i; j--){
                int product = nums[i] * nums[j];
                Set<Integer> st = new HashSet<>();

                for (int k=i+1; k<j; k++){
                    if (product % nums[k] == 0){
                        int div = product / nums[k];
                        if (st.contains(div)){
                            count++;
                        }
                        st.add(nums[k]);
                    }
                }
            }
        }
        return (count)*8;
    }

    //Solution 4 : Optimized
    //Time Complexity : O(n^2)
    //Space Complexity : O(n)
    public static int tupleSameProduct4(int[] nums) {
        int n = nums.length;
        int count = 0;

        Map<Integer,Integer> mp = new HashMap<>();

        for(int i=0; i<n; i++){
            for (int j = i+1; j<n; j++){
                int product = nums[i] * nums[j];
                mp.put(product, mp.getOrDefault(product,0)+1);
            }
        }

        for (int val : mp.values()){
            count += val*(val-1)/2;
        }
        return count*8;
    }
}
