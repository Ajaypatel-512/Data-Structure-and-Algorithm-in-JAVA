package Stack;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    Queue<Integer> queue1;

    public MyStack() {
        queue1 = new LinkedList<>();
    }

    public void push(int x) {
        queue1.add(x);
        for (int i = 0; i < queue1.size() - 1; i++) {
            queue1.add(queue1.poll());
        }
    }

    public int pop() {
            return queue1.remove();
    }

    public int top() {
        if (queue1.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return queue1.peek();
    }

    public boolean empty() {
        return queue1.isEmpty();
    }
}
