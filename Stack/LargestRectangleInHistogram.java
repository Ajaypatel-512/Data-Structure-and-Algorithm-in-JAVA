package Stack;

import java.util.Stack;

import static Stack.NextSmallerElements.nextSmallerElementsStack;
import static Stack.PreviousSmallerElement.previousSmallerElementOptimized;

public class LargestRectangleInHistogram {
    /**
     * 84. Largest Rectangle in Histogram
     * Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.
     *
     *
     *
     * Example 1:
     *
     *
     * Input: heights = [2,1,5,6,2,3]
     * Output: 10
     * Explanation: The above is a histogram where width of each bar is 1.
     * The largest rectangle is shown in the red area, which has an area = 10 units.
     * Example 2:
     *
     *
     * Input: heights = [2,4]
     * Output: 4
     *
     *
     * Constraints:
     *
     * 1 <= heights.length <= 105
     * 0 <= heights[i] <= 104
     * */
    public static void main(String[] args) {
        LargestRectangleInHistogram solution = new LargestRectangleInHistogram();
        int[] heights = {2, 1, 5, 6, 2, 3};
        int maxArea = solution.largestRectangleArea(heights);
        System.out.println("The area of the largest rectangle in the histogram is: " + maxArea);
    }

    //Solution 1 : Using Next and Previous Smaller Element Indexes
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] nextSmaller = nextSmallerElementIndexes1(heights);
        int[] prevSmaller = previousSmallerElementIndexes1(heights);
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            int height = heights[i];
            int width = nextSmaller[i] - prevSmaller[i] - 1;
            maxArea = Math.max(maxArea, height * width);
        }
        return maxArea;
    }

    // Next Smaller Element Index to the Right
    private int[] nextSmallerElementIndexes1(int[] heights) {
        int n = heights.length;
        int[] nse = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            nse[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        return nse;
    }

    // Previous Smaller Element Index to the Left
    private int[] previousSmallerElementIndexes1(int[] heights) {
        int n = heights.length;
        int[] pse = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            pse[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return pse;
    }

}
