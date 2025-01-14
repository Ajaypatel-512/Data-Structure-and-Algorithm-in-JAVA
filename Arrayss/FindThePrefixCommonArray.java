package Arrayss;

import java.util.Arrays;

public class FindThePrefixCommonArray {
    /**
     * 2657. Find the Prefix Common Array of Two Arrays
     * You are given two 0-indexed integer permutations A and B of length n.
     *
     * A prefix common array of A and B is an array C such that C[i] is equal to the count of numbers that are present at or before the index i in both A and B.
     *
     * Return the prefix common array of A and B.
     *
     * A sequence of n integers is called a permutation if it contains all integers from 1 to n exactly once.
     *
     *
     *
     * Example 1:
     *
     * Input: A = [1,3,2,4], B = [3,1,2,4]
     * Output: [0,2,3,4]
     * Explanation: At i = 0: no number is common, so C[0] = 0.
     * At i = 1: 1 and 3 are common in A and B, so C[1] = 2.
     * At i = 2: 1, 2, and 3 are common in A and B, so C[2] = 3.
     * At i = 3: 1, 2, 3, and 4 are common in A and B, so C[3] = 4.
     * Example 2:
     *
     * Input: A = [2,3,1], B = [3,1,2]
     * Output: [0,1,3]
     * Explanation: At i = 0: no number is common, so C[0] = 0.
     * At i = 1: only 3 is common in A and B, so C[1] = 1.
     * At i = 2: 1, 2, and 3 are common in A and B, so C[2] = 3.
     *
     *
     * Constraints:
     *
     * 1 <= A.length == B.length == n <= 50
     * 1 <= A[i], B[i] <= n
     * It is guaranteed that A and B are both a permutation of n integers.
     * */
    public static void main(String[] args) {
        int[] A = {1,3,2,4};
        int[] B = {3,1,2,4};
        int[] result = findThePrefixCommonArray2(A, B);
        System.out.println(Arrays.toString(result));
    }

    //Solution 1 : Brute Force
    //Time Complexity: O(n^3)
    //Space Complexity: O(1)
    public static int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] result = new int[n];

        for (int i=0; i<n ;i++){
            int count=0;
            for(int A_i=0; A_i<=i; A_i++){
                for(int B_i=0; B_i<=i; B_i++){
                    if(B[B_i] == A[A_i]){
                        count++;
                        break;
                    }
                }
            }
            result[i] = count;
        }

        return result;
    }

    //Solution 2: Better Approach
    //Time Complexity: O(n^2)
    //Space Complexity: O(n)
    public static int[] findThePrefixCommonArray2(int[] A, int[] B) {
        int n = A.length;
        int[] result = new int[n];
        Boolean[] isPresentA = new Boolean[n+1];
        Boolean[] isPresentB = new Boolean[n+1];
        Arrays.fill(isPresentA, false);
        Arrays.fill(isPresentB, false);

        for (int i=0; i<n; i++){
            isPresentA[A[i]] = true;
            isPresentB[B[i]] = true;
            int count=0;
            for (int j=1; j<=n; j++){
                if(isPresentA[j] && isPresentB[j]){
                    count++;
                }
            }
            result[i] = count;
        }

        return result;
    }

}
