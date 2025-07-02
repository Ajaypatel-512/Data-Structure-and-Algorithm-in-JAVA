package Stack;

import java.util.Stack;

public class PreviousSmallerElement {
    /**
     * 739. Previous Smaller Element
     * Given an array of integers, return an array where each element is the previous smaller element of the corresponding element in the input array.
     * If there is no previous smaller element, return -1 for that position.
     *
     * Example:
     * Input: arr = [4, 5, 2, 10, 8]
     * Output: [-1, 4, -1, 2, 2]
     */
    public static void main(String[] args) {

    }

    //Solution 1: Using a stack to find the previous smaller element for each element in the array.
    // Time Complexity: O(n), where n is the number of elements in the array.
    // Space Complexity: O(n) for the stack and result array.
    public static int[] previousSmallerElement(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        int[] stack = new int[n];
        int top = -1;

        for (int i = 0; i < n; i++) {
            while (top != -1 && stack[top] >= arr[i]) {
                top--;
            }
            result[i] = (top == -1) ? -1 : stack[top];
            stack[++top] = arr[i];
        }

        return result;
    }

    //Solution 2: Using Stack
    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public static int[] previousSmallerElementOptimized(int[] arr) {
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }
        return result;
    }
}
