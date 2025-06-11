package LinkedList;

public class OddEvenLinkedList {
    /**
     * 328. Odd Even Linked List
     * Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.
     *
     * The first node is considered odd, and the second node is even, and so on.
     *
     * Note that the relative order inside both the even and odd groups should remain as it was in the input.
     *
     * You must solve the problem in O(1) extra space complexity and O(n) time complexity.
     *
     *
     *
     * Example 1:
     *
     *
     * Input: head = [1,2,3,4,5]
     * Output: [1,3,5,2,4]
     * Example 2:
     *
     *
     * Input: head = [2,1,3,5,6,4,7]
     * Output: [2,3,6,7,1,5,4]
     *
     *
     * Constraints:
     *
     * The number of nodes in the linked list is in the range [0, 104].
     * -106 <= Node.val <= 106
     * */
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = oddEvenList(head);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    //Solution 1: Iterative approach
    //Time Complexity: O(n) where n is the number of nodes in the linked list.
    //Space Complexity: O(1) since we are not using any extra space except for pointers.
    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null) {
            odd.next = odd.next.next; // Link odd nodes
            odd = odd.next; // Move to the next odd node
            even.next = even.next.next; // Link even nodes
            even = even.next; // Move to the next even node
        }

        odd.next = evenHead; // Connect the end of odd list to the head of even list
        return head; // Return the modified list
    }
}
