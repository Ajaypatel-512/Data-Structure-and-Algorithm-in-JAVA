package LinkedList;

import java.util.Stack;

public class ReverseLL {
    /**
     * 206. Reverse Linked List

     * Given the head of a singly linked list, reverse the list, and return the reversed list.
     *
     *
     *
     * Example 1:
     *
     *
     * Input: head = [1,2,3,4,5]
     * Output: [5,4,3,2,1]
     * Example 2:
     *
     *
     * Input: head = [1,2]
     * Output: [2,1]
     * Example 3:
     *
     * Input: head = []
     * Output: []
     *
     *
     * Constraints:
     *
     * The number of nodes in the list is the range [0, 5000].
     * -5000 <= Node.val <= 5000
     *
     *
     * Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?
     * */
    public static void main(String[] args) {

    }

    //Solution 1: Using stack
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public ListNode reverseList(ListNode head) {
        ListNode temp = head;
        Stack<Integer> stack = new Stack<>();

        while(temp != null) {
            stack.push(temp.val);
            temp = temp.next;
        }

        temp = head;

        while (temp != null) {
            temp.val = stack.pop();
            temp = temp.next;
        }

        return head;
    }

    //Solution 2: Iterative approach
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public static ListNode reverseList2(ListNode head) {
        ListNode temp = head;
        ListNode prev = null;

        while(temp != null){
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }

        return prev;
    }

    //Solution 3: Recursive approach
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public static ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseList3(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

}
