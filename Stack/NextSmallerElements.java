package Stack;

import java.util.Stack;

public class NextSmallerElements {

    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 3, 5};
        int[] result = nextSmallerElements(nums);
        for (int num : result) {
            System.out.print(num + " ");
        }
        System.out.println();

        int[] resultStack = nextSmallerElementsStack(nums);
        for (int num : resultStack) {
            System.out.print(num + " ");
        }
    }

    //Solution 1: Brute Force
    //Time Complexity: O(n^2)
    //Space Complexity: O(n)
    public static int[] nextSmallerElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = -1; // Initialize with -1
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[i]) {
                    result[i] = nums[j];
                    break;
                }
            }
        }
        return result;
    }

    //Solution 2: Using Stack
    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public static int[] nextSmallerElementsStack(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
       Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek() > nums[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                result[i] = stack.peek(); // The top of the stack is the next smaller element
            } else {
                result[i] = -1; // No smaller element found
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            result[stack.pop()] = -1; // If no smaller element found
        }

        return result;
    }
}
