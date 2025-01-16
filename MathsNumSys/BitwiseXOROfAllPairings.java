package MathsNumSys;

import java.util.HashMap;
import java.util.Map;

public class BitwiseXOROfAllPairings {
    /**
     * 2425. Bitwise XOR of All Pairings
     * You are given two 0-indexed arrays, nums1 and nums2, consisting of non-negative integers. There exists another array, nums3, which contains the bitwise XOR of all pairings of integers between nums1 and nums2 (every integer in nums1 is paired with every integer in nums2 exactly once).
     *
     * Return the bitwise XOR of all integers in nums3.
     *
     *
     *
     * Example 1:
     *
     * Input: nums1 = [2,1,3], nums2 = [10,2,5,0]
     * Output: 13
     * Explanation:
     * A possible nums3 array is [8,0,7,2,11,3,4,1,9,1,6,3].
     * The bitwise XOR of all these numbers is 13, so we return 13.
     * Example 2:
     *
     * Input: nums1 = [1,2], nums2 = [3,4]
     * Output: 0
     * Explanation:
     * All possible pairs of bitwise XORs are nums1[0] ^ nums2[0], nums1[0] ^ nums2[1], nums1[1] ^ nums2[0],
     * and nums1[1] ^ nums2[1].
     * Thus, one possible nums3 array is [2,5,1,6].
     * 2 ^ 5 ^ 1 ^ 6 = 0, so we return 0.
     *
     *
     * Constraints:
     *
     * 1 <= nums1.length, nums2.length <= 105
     * 0 <= nums1[i], nums2[j] <= 109
     * */
    public static void main(String[] args) {
        int[] nums1 = {2,1,3};
        int[] nums2 = {10,2,5,0};
        System.out.println(xorAllNums(nums1, nums2));
    }

    //Solution 1 : Brute Force
    //Time Complexity : O(n*m)
    //Space Complexity : O(n*m)
    public static int xorAllNums(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int[] result = new int[n*m];

        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                result[i*m+j] = nums1[i] ^ nums2[j];
            }
        }

        int xor = 0;
        for (int i=0; i<result.length; i++){
            xor ^= result[i];
        }
        return xor;
    }


    //Solution 2 : Using HashMap
    //Time Complexity : O(n+m)
    //Space Complexity : O(n+m)
    public static int xorAllNums2(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums1){
            map.put(num, map.getOrDefault(num, 0)+m);
        }

        for (int num: nums2){
            map.put(num, map.getOrDefault(num, 0)+n);
        }

        int xor = 0;
        for (int num: map.keySet()){
            if (map.get(num) %2 != 0){
                xor ^= num;
            }
        }
        return xor;
    }

    //Solution 3: Optimized
    //Time Complexity : O(n+m)
    //Space Complexity : O(1)
    public static int xorAllNums3(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int xor = 0;

        if (n % 2 != 0){
            for (int num: nums2){
                xor ^= num;
            }
        }

        if (m % 2 != 0){
            for (int num: nums1){
                xor ^= num;
            }
        }
        return xor;
    }
}
