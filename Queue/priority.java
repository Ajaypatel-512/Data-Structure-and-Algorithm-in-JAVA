package Queue;

import java.util.Collections;
import java.util.PriorityQueue;

public class priority {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        pq.offer(12);
        pq.offer(22);
        pq.offer(32);
        pq.offer(42);
        pq.offer(52);
        pq.offer(62);
        pq.offer(02);
        System.out.println(pq);
        System.out.println(pq.poll());
    }
}
