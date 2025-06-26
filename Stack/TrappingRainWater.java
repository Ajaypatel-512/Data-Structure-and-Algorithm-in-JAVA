package Stack;

public class TrappingRainWater {
    /**
     * 42. Trapping Rain Water
     * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
     *
     *
     *
     * Example 1:
     *
     *
     * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
     * Output: 6
     * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
     * Example 2:
     *
     * Input: height = [4,2,0,3,2,5]
     * Output: 9
     *
     *
     * Constraints:
     *
     * n == height.length
     * 1 <= n <= 2 * 104
     * 0 <= height[i] <= 105
     * */
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height)); // Output: 6

        int[] height2 = {4, 2, 0, 3, 2, 5};
        System.out.println(trap(height2)); // Output: 9
    }

    //Solution 1: Using Prefix and Suffix Max Arrays
    // Time Complexity: O(2n) + O(n) = O(3n)
    // Space Complexity: O(2n)
    public static int trap(int[] height) {
        int n = height.length;
        int totalWater = 0;

        int[] preFixMax = new int[n];
        preFixMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            preFixMax[i] = Math.max(preFixMax[i - 1], height[i]);
        }

        int[] suffixMax = new int[n];
        suffixMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixMax[i] = Math.max(suffixMax[i + 1], height[i]);
        }

        for (int i=0; i<n; i++){
            int leftMax = preFixMax[i];
            int rightMax = suffixMax[i];
            if (height[i] < leftMax && height[i] < rightMax) {
                totalWater += Math.min(leftMax, rightMax) - height[i];
            }
        }
        return totalWater;
    }

    // Solution 2: Using Two Pointers
    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public static int trapTwoPointers(int[] height) {
        int n = height.length;
        if (n == 0) return 0;

        int left = 0, right = n - 1;
        int leftMax = height[left], rightMax = height[right];
        int totalWater = 0;

        while (left < right) {
            if (leftMax < rightMax) {
                left++;
                leftMax = Math.max(leftMax, height[left]);
                totalWater += leftMax - height[left];
            } else {
                right--;
                rightMax = Math.max(rightMax, height[right]);
                totalWater += rightMax - height[right];
            }
        }
        return totalWater;
    }
}
