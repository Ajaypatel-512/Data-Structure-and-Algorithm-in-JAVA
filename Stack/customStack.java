package Stack;

import java.util.Stack;

public class customStack {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;

    int ptr = -1;

    public customStack() {
        this(DEFAULT_SIZE);
    }

    public customStack(int size) {
        this.data = new int[size];
    }

    public boolean push(int item) throws stackException {
        if (isFull()) {
            throw new stackException("Cannot push data! Stack is full");
        }
        ptr++;
        data[ptr] = item;
        return true;
    }

    public int pop() throws stackException {
        if (isEmpty()) {
            throw new stackException("cannot pop from an empty stack !");
        }
//        int removed = data[ptr];
//        ptr--;
//        return removed;
        return data[ptr--];
    }

    public int peek() throws stackException {
        if (isEmpty()) {
            throw new stackException("Cannot peek from empty stack1");
        }
        return data[ptr];
    }

    public boolean isFull() {
        return ptr == data.length - 1;
    }

    public boolean isEmpty() {
        return ptr == -1;
    }
}