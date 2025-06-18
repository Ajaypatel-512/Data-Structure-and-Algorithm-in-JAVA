package LinkedList;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLoopInLL {
    /**
     * Length of Loop in Linked List
     * Problem Statement: Given the head of a linked list, determine the length of a loop present in the linked list; if not present, return 0.
     *
     * Examples
     *
     * Example 1:
     *
     *
     * Input Format:
     *
     *
     * LL: 1  2  3  4  5
     *
     *
     *
     *
     * Output: 3
     * Explanation: A cycle exists in the linked list starting at node 3 -> 4 -> 5 and then back to 3. There are 3 nodes present in this cycle.
     *
     *
     * Example 2:
     *
     *
     * Input Format:
     *
     *
     * LL: 1  2  3  4  9  9
     *
     *
     *
     *
     * Output: 0
     *
     *
     * Explanation: In this example, the linked list is linear and does not have a loop hence return 0.
     * */
    public static void main(String[] args) {
        LengthOfLoopInLL solution = new LengthOfLoopInLL();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = head.next; // Creating a cycle

        int length = solution.length(head);
        System.out.println("Length of the loop: " + length); // Output: 3
    }

    //Solution 1: Using hashing to detect cycle
    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public int length(ListNode head) {
        Map<ListNode,Integer> map = new HashMap<>();
        ListNode temp = head;
        int timer = 1;
        while(temp != null){
            if(map.containsKey(temp)){
                return timer - map.get(temp);
            }
            map.put(temp, timer);
            temp = temp.next;
            timer++;
        }
        return 0; // No cycle found
    }

    //Solution 2: Using Tortoise and Hare algorithm (Floyd's Cycle Detection Algorithm)
    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public int hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next; // Move slow pointer by 1 step
            fast = fast.next.next; // Move fast pointer by 2 steps

            if (slow == fast) { // Cycle detected
                int length = 1;
                ListNode current = slow;
                while (current.next != slow) {
                    current = current.next;
                    length++;
                }
                return length; // Return the length of the cycle
            }
        }
        return 0; // No cycle found
    }

}
