package Recursion.Stack;

import java.util.Stack;

public class ReverseStack {
    public static void main(String[] args) {

    }

    //Solution 1: Using Recursion
    //Time Complexity: O(n^2)
    //Space Complexity: O(n) auxiliary space
    public static void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int top = stack.pop();
        reverseStack(stack);
        Stack<Integer> tempStack = new Stack<>();
        while (!stack.isEmpty()) {
            tempStack.push(stack.pop());
        }
        stack.push(top);
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }

    //Solution 2: Using Recursion with a helper function
    //Time Complexity: O(n^2)
    //Space Complexity: O(1)
    public static void reverseStackHelper(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int top = stack.pop();
        reverseStackHelper(stack);
        insertAtBottom(stack, top);
    }

    private static void insertAtBottom(Stack<Integer> stack, int top) {
        if (stack.isEmpty()) {
            stack.push(top);
            return;
        }
        int temp = stack.pop();
        insertAtBottom(stack, top);
        stack.push(temp);
    }

}
