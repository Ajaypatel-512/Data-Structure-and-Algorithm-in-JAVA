package Stack;

import java.util.Stack;

public class MinStack {
    /**
     * 155. Min Stack
     * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
     *
     * Implement the MinStack class:
     *
     * MinStack() initializes the stack object.
     * void push(int val) pushes the element val onto the stack.
     * void pop() removes the element on the top of the stack.
     * int top() gets the top element of the stack.
     * int getMin() retrieves the minimum element in the stack.
     * You must implement a solution with O(1) time complexity for each function.
     *
     *
     *
     * Example 1:
     *
     * Input
     * ["MinStack","push","push","push","getMin","pop","top","getMin"]
     * [[],[-2],[0],[-3],[],[],[],[]]
     *
     * Output
     * [null,null,null,null,-3,null,0,-2]
     *
     * Explanation
     * MinStack minStack = new MinStack();
     * minStack.push(-2);
     * minStack.push(0);
     * minStack.push(-3);
     * minStack.getMin(); // return -3
     * minStack.pop();
     * minStack.top();    // return 0
     * minStack.getMin(); // return -2
     *
     *
     * Constraints:
     *
     * -231 <= val <= 231 - 1
     * Methods pop, top and getMin operations will always be called on non-empty stacks.
     * At most 3 * 104 calls will be made to push, pop, top, and getMin.
     * */
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        System.out.println(minStack.top());    // return 0
        System.out.println(minStack.getMin()); // return -2
    }

    //Solution 1: Using a Pair class to store both value and minimum
    //Time Complexity: O(1) for push, pop, top, and getMin
    //Space Complexity: O(n) for the stack
    Stack<Pair> stack;
    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(new Pair(val, val));
        } else {
            int min = Math.min(val, stack.peek().y);
            stack.push(new Pair(val, min));
        }
    }

    public void pop() {
        if (!stack.isEmpty()) {
            stack.pop();
        }
    }

    public int top() {
        if (!stack.isEmpty()) {
            return stack.peek().x;
        }
        throw new IllegalStateException("Stack is empty");
    }

    public int getMin() {
        if (!stack.isEmpty()) {
            return stack.peek().y;
        }
        throw new IllegalStateException("Stack is empty");
    }
}
