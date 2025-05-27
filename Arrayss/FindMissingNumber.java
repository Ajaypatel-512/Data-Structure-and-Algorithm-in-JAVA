package Arrayss;

import java.util.Arrays;

public class FindMissingNumber {
    /**
     * 268. Missing Number
     * Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
     *
     * Example 1:
     *
     * Input: nums = [3,0,1]
     *
     * Output: 2
     *
     * Explanation:
     *
     * n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
     *
     * Example 2:
     *
     * Input: nums = [0,1]
     *
     * Output: 2
     *
     * Explanation:
     *
     * n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.
     *
     * Example 3:
     *
     * Input: nums = [9,6,4,2,3,5,7,0,1]
     *
     * Output: 8
     *
     * Explanation:
     *
     * n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.
     * Constraints:
     *
     * n == nums.length
     * 1 <= n <= 104
     * 0 <= nums[i] <= n
     * All the numbers of nums are unique.
     *
     * */
    public static void main(String[] args) {
        int[] nums = {1,2,4};
        int n = 4;
        System.out.println(missingNumber2(nums)); // Output: 2
    }

    //Solution 1: Brute force
    //Time Complexity: O(n^2)
    //Space Complexity: O(1)
    private static int missingNumber1(int[] nums) {
        int n = nums.length;
        for (int i=0; i<n; i++){
            int flag = 0;
            for (int j=0; j<n; j++){
                if (i == nums[j]){
                    flag = 1;
                    break;
                }
            }
            if (flag == 0){
                return i;
            }
        }
        return n;
    }

    //Solution 2: Better solution
    //Time Complexity: O(n)
    //Space Complexity: O(n)
    private static int missingNumber2(int[] nums) {
        int n = nums.length;
        Boolean[] visited = new Boolean[n+1];
        Arrays.fill(visited, false);
        for (int i=0; i<n; i++){
            if (nums[i] <= n) {
                visited[nums[i]] = true;
            }
        }

        for (int i=1; i<=n; i++){
            if (!visited[i]){
                return i;
            }
        }
        return 0;
    }

    //Solution 3: Optimal solution using Sum Formula
    //Time Complexity: O(n)
    //Space Complexity: O(1)
    private static int missingNumber3(int[] nums) {
        int n = nums.length;
        int sum = (n * (n + 1) )/2;
        int actualSum = 0;
        for (int i=0; i<n; i++){
            actualSum += nums[i];
        }

        return sum - actualSum;
    }

    //Solution 4: Optimal solution using XOR
    //Time Complexity: O(n)
    //Space Complexity: O(1)
    private static int missingNumber4(int[] nums) {
        int n = nums.length;
        int xor1 = 0;
        int xor2 = 0;

        for (int i=0; i<n; i++){
            xor1 = xor1 ^ (i+1);
            xor2 = xor2 ^ nums[i];
        }

        return xor1 ^ xor2;

    }

}
