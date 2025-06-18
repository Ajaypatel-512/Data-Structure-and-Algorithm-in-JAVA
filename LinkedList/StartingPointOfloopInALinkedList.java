package LinkedList;

import java.util.HashMap;
import java.util.Map;

public class StartingPointOfloopInALinkedList {
    /**
     * Problem Statement: Given the head of a linked list that may contain a cycle,
     * return the starting point of that cycle. If there is no cycle in the linked list return null.
     *
     * Examples
     *                 Example 1:
     *                 Input: LL: 1  2  3  4  5
     *                 Output: 3
     *
     *                 Explanation: This linked list contains a loop of size 3 starting at node with value 3.
     *
     *                 Example 2:
     *                 Input: LL: LL: 1 -> 2 -> 3 -> 4 -> 9 -> 9

     *                 Output: NULL
     *
     *                 Explanation:  This linked list does not contain  a loop hence has no starting point.
     * */
    public static void main(String[] args) {
        StartingPointOfloopInALinkedList solution = new StartingPointOfloopInALinkedList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = head.next; // Creating a cycle

        ListNode startingPoint = solution.length(head);
        if (startingPoint != null) {
            System.out.println("Starting point of the cycle: " + startingPoint.val); // Output: 2
        } else {
            System.out.println("No cycle detected.");
        }
    }

    //Solution 1: Using hashing to detect cycle
    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public ListNode length(ListNode head) {
        Map<ListNode,Integer> map = new HashMap<>();
        while(head != null){
            if(map.containsKey(head)){
                return head;
            }
            map.put(head, 1);
            head = head.next;
        }
        return null;
    }

    //Solution 2: Using Tortoise and Hare algorithm (Floyd's Cycle Detection Algorithm)
    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public ListNode hasCycle(ListNode head) {
        ListNode f = head;
        ListNode s = head;

        while(f != null && f.next != null){
            f = f.next.next;
            s = s.next;
            if(f == s) {
                // Cycle detected, now find the starting point
                s = head;
                while(f != s) {
                    f = f.next;
                    s = s.next;
                }
                return s; // Starting point of the cycle
            }
        }
        return null; // No cycle found
    }
}
