package LinkedList;

public class AddTwoNumbers {
    /**
     * 2. Add Two Numbers

     * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
     *
     * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     *
     *
     *
     * Example 1:
     *
     *
     * Input: l1 = [2,4,3], l2 = [5,6,4]
     * Output: [7,0,8]
     * Explanation: 342 + 465 = 807.
     * Example 2:
     *
     * Input: l1 = [0], l2 = [0]
     * Output: [0]
     * Example 3:
     *
     * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
     * Output: [8,9,9,9,0,0,0,1]
     *
     *
     * Constraints:
     *
     * The number of nodes in each linked list is in the range [1, 100].
     * 0 <= Node.val <= 9
     * It is guaranteed that the list represents a number that does not have leading zeros.
     * */
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode result = addTwoNumbers(l1, l2);

        // Print the result
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    //Solution 1: Iterative approach
    // Time Complexity: O(max(m, n)), where m and n are the lengths of the two linked lists.
    // Space Complexity: O(max(m, n)), for the new linked list that is created to store the result.
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode temp = dummy;
        int carry = 0;
        while( l1 != null || l2 != null || carry == 1) {
            int sum = 0;
            if(l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if(l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            sum += carry;
            carry = sum / 10;
            ListNode node = new ListNode(sum % 10);
            temp.next = node;
            temp = temp.next;
        }
        return dummy.next;
    }
}
