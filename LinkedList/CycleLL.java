package LinkedList;

import java.util.HashMap;
import java.util.Map;

public class CycleLL {
    /**
     * 141. Linked List Cycle
     * Given head, the head of a linked list, determine if the linked list has a cycle in it.
     *
     * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
     *
     * Return true if there is a cycle in the linked list. Otherwise, return false.
     *
     *
     *
     * Example 1:
     *
     *
     * Input: head = [3,2,0,-4], pos = 1
     * Output: true
     * Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
     * Example 2:
     *
     *
     * Input: head = [1,2], pos = 0
     * Output: true
     * Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.
     * Example 3:
     *
     *
     * Input: head = [1], pos = -1
     * Output: false
     * Explanation: There is no cycle in the linked list.
     *
     *
     * Constraints:
     *
     * The number of the nodes in the list is in the range [0, 104].
     * -105 <= Node.val <= 105
     * pos is -1 or a valid index in the linked-list.
     *
     *
     * Follow up: Can you solve it using O(1) (i.e. constant) memory?
     * */

    public static void main(String[] args) {
        CycleLL cycleLL = new CycleLL();
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next; // Creating a cycle

        System.out.println(cycleLL.hasCycle(head)); // Output: true
    }

    //Solution 1: Using Tortoise and Hare algorithm (Floyd's Cycle Detection Algorithm)
    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public boolean hasCycle(ListNode head) {
        ListNode f = head;
        ListNode s = head;

        while(f != null && f.next != null){
            f = f.next.next;
            s = s.next;
            if(f ==  s)
                return true;
        }
        return false;
    }

    //Solution 2: Using Hashing
    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public boolean length(ListNode head) {
        Map<ListNode,Integer> map = new HashMap<>();
        while(head != null){
            if(map.containsKey(head)){
                return true;
            }
            map.put(head, 1);
            head = head.next;
        }
        return false;
    }
}
