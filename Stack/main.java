package Stack;

import java.util.Stack;

public class main {


    public static void main(String[] args) throws stackException {
//        Stack<Integer> stack = new Stack<>();
//        stack.push(34);
//        stack.push(45);
//        stack.push(2);
//        stack.push(9);
//        stack.push(18);
////        System.out.println(stack.peek());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());

//        dynamicStack cs = new dynamicStack(5);
        customStack cs = new dynamicStack(5);

        cs.push(10);
        cs.push(20);
        cs.push(30);
        cs.push(40);
        cs.push(50);
        cs.push(60);

//        System.out.println(cs.peek());
        System.out.println(cs.pop());
        System.out.println(cs.pop());
        System.out.println(cs.pop());
        System.out.println(cs.pop());
        System.out.println(cs.pop());
        System.out.println(cs.pop());

    }
}
