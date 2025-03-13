package Binary_Search;

public class ZeroArrayTransformationII {
    /**
     *  3356. Zero Array Transformation II
     * You are given an integer array nums of length n and a 2D array queries where queries[i] = [li, ri, vali].
     *
     * Each queries[i] represents the following action on nums:
     *
     * Decrement the value at each index in the range [li, ri] in nums by at most vali.
     * The amount by which each value is decremented can be chosen independently for each index.
     * A Zero Array is an array with all its elements equal to 0.
     *
     * Return the minimum possible non-negative value of k, such that after processing the first k queries in sequence, nums becomes a Zero Array. If no such k exists, return -1.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [2,0,2], queries = [[0,2,1],[0,2,1],[1,1,3]]
     *
     * Output: 2
     *
     * Explanation:
     *
     * For i = 0 (l = 0, r = 2, val = 1):
     * Decrement values at indices [0, 1, 2] by [1, 0, 1] respectively.
     * The array will become [1, 0, 1].
     * For i = 1 (l = 0, r = 2, val = 1):
     * Decrement values at indices [0, 1, 2] by [1, 0, 1] respectively.
     * The array will become [0, 0, 0], which is a Zero Array. Therefore, the minimum value of k is 2.
     * Example 2:
     *
     * Input: nums = [4,3,2,1], queries = [[1,3,2],[0,2,1]]
     *
     * Output: -1
     *
     * Explanation:
     *
     * For i = 0 (l = 1, r = 3, val = 2):
     * Decrement values at indices [1, 2, 3] by [2, 2, 1] respectively.
     * The array will become [4, 1, 0, 0].
     * For i = 1 (l = 0, r = 2, val = 1):
     * Decrement values at indices [0, 1, 2] by [1, 1, 0] respectively.
     * The array will become [3, 0, 0, 0], which is not a Zero Array.
     *
     *
     * Constraints:
     *
     * 1 <= nums.length <= 105
     * 0 <= nums[i] <= 5 * 105
     * 1 <= queries.length <= 105
     * queries[i].length == 3
     * 0 <= li <= ri < nums.length
     * 1 <= vali <= 5
     * */
    public static void main(String[] args) {
        int[] nums = {2,0,2};
        int[][] queries = {{0,2,1},{0,2,1},{1,1,3}};
        System.out.println(minZeroArray(nums,queries));
    }

    //Solution 1 - Using Brute Force Approach
    //Time Complexity - O(Q*N) where Q = no of queries, N = length of nums
    //Space Complexity - O(1)
    public static int minZeroArray(int[] nums, int[][] queries) {
        if (isAllZero(nums)) {
            return 0;
        }

        int minOps = 0;

        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            int v = queries[i][2];

            for (int x = l; x <= r; x++) {
                nums[x] = Math.max(0, nums[x] - v);
            }

            if (isAllZero(nums)) {
                return i + 1;
            }

            minOps++;
        }

        return -1;
    }

    private static boolean isAllZero(int[] nums) {
        for (int num : nums) {
            if (num != 0) {
                return false;
            }
        }
        return true;
    }

    //Solution 2 - Using Difference Array Technique
    //Time Complexity - O(Q^2 + Q*N) where Q = no of queries, N = length of nums
    //Space Complexity - O(1)
    public static int minZeroArray2(int[] nums, int[][] queries) {
        int N = nums.length;
        int Q = queries.length;

        if (isAllZero(nums)){
            return 0;
        }

        for (int i=0; i<Q; i++){
            if (checkWithDiffArr(nums,queries,i) == true){
                return i+1;
            }
        }
        return -1;
    }

    private static boolean checkWithDiffArr(int[] nums, int[][] queries, int k) {
        int[] diff = new int[nums.length];
        for (int i=0; i<=k; i++){
            int l = queries[i][0];
            int r = queries[i][1];
            int val = queries[i][2];

            diff[l] += val;
            if (r+1<nums.length){
                diff[r+1] -= val;
            }
        }

        int cumm = 0;
        for (int i=0; i<nums.length; i++){
            cumm += diff[i];
            diff[i] = cumm;

            if (nums[i] -diff[i] > 0){
                return false;
            }
        }
        return true;
    }

    //Solution 3 - Using Difference Array Technique + Binary Search
    //Time Complexity - O( logQ (Q+N)) where Q = no of queries, N = length of nums
    //Space Complexity - O(1)
    public static int minZeroArray3(int[] nums, int[][] queries) {
        int N = nums.length;
        int Q = queries.length;

        if (isAllZero(nums)){
            return 0;
        }

        int l=0;
         int r = Q-1;
         int k=-1;
         while (l<=r){
             int mid = l+ (r-l)/2;
             if (checkWithDiffArr3(nums,queries,mid) == true){
                 k = mid + 1;
                 r = mid - 1;
             } else {
                 l = mid +1;
             }
         }
        return k;
    }

    private static boolean checkWithDiffArr3(int[] nums, int[][] queries, int k) {
        int[] diff = new int[nums.length];
        for (int i=0; i<=k; i++){
            int l = queries[i][0];
            int r = queries[i][1];
            int val = queries[i][2];

            diff[l] += val;
            if (r+1<nums.length){
                diff[r+1] -= val;
            }
        }

        int cumm = 0;
        for (int i=0; i<nums.length; i++){
            cumm += diff[i];
            diff[i] = cumm;

            if (nums[i] -diff[i] > 0){
                return false;
            }
        }
        return true;
    }


}
