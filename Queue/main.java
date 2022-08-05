package Queue;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class main {
    public static void main(String[] args) throws Exception {
//        Queue<Integer> queue = new LinkedList<>();
//        queue.add(6);
//        queue.add(5);
//        queue.add(19);
//        queue.add(1);
//        System.out.println(queue.peek());
//        System.out.println(queue.remove());
//        System.out.println(queue.remove());
//        System.out.println(queue.remove());
//        System.out.println(queue.remove());

//        customQueue cs = new customQueue(5);
//        cs.insert(10);
//        cs.insert(20);
//        cs.insert(30);
//        cs.insert(40);
//        cs.insert(50);
////        cs.insert(60);
//
//        cs.display();
//        System.out.println(cs.remove());
//        System.out.println(cs.remove());
//        System.out.println(cs.remove());
//        System.out.println(cs.remove());
//        cs.display();
//        System.out.println(cs.front());\

        dynamicQueue cs = new dynamicQueue(5);
        cs.insert(10);
        cs.insert(20);
        cs.insert(30);
        cs.insert(40);
        cs.insert(50);
        cs.insert(60);
        cs.insert(70);

//        cs.insert(60);

        cs.display();
        System.out.println(cs.remove());
        cs.insert(50);
        cs.display();
        System.out.println(cs.remove());
        System.out.println(cs.remove());
        System.out.println(cs.remove());
        cs.display();
        System.out.println(cs.front());
    }
}
