package LinkedList;

import java.util.Stack;

public class palindromeLL {
    /**
     * 234. Palindrome Linked List
     * Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
     * Example 1:
     *
     *
     * Input: head = [1,2,2,1]
     * Output: true
     * Example 2:
     *
     *
     * Input: head = [1,2]
     * Output: false
     *
     *
     * Constraints:
     *
     * The number of nodes in the list is in the range [1, 105].
     * 0 <= Node.val <= 9
     *
     *
     * Follow up: Could you do it in O(n) time and O(1) space?
     * */
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    //Helper function to find the middle of the linked list
    //Time Complexity: O(n)
    //Space Complexity: O(1)
  public ListNode middleNode(ListNode head) {
        ListNode s = head;
        ListNode f = head;
        while (f != null && f.next != null){
            s = s.next;
            f = f.next.next;
        }
        return s;
    }

    //Helper function to reverse the linked list
    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public ListNode reverse(ListNode head) {
        if(head ==  null){
            return head;
        }
        ListNode prev = null;
        ListNode present = head;
        ListNode next = present.next;

        while(present != null){
            present.next = prev;
            prev = present;
            present = next;
            if (next != null){
                next = next.next;
            }
        }
        head = prev;
        return head;
    }

    //Solution 2: Using Two Pointer Technique
    //Time Complexity: O(2n)
    //Space Complexity: O(1)
    public boolean isPalindrome(ListNode head) {
        //Find middle
        ListNode mid = middleNode(head);
        ListNode headSec = reverse(mid);
        ListNode reReverseHead = headSec;

        while(head != null && headSec != null){
            if(head.val != headSec.val){
                break;
            }
            head = head.next;
            headSec = headSec.next;
        }
        reverse(reReverseHead);
        return head == null || headSec == null;
    }

    //Solution 1: Using Stack
    //Time Complexity: O(2n)
    //Space Complexity: O(n)
    public static boolean isPalindrome2(ListNode head) {
        Stack<Integer> st = new Stack<>();
        ListNode temp = head;

        while (temp != null) {
            st.push(temp.val);
            temp = temp.next;
        }

        temp = head;

        while (temp != null) {
            if (temp.val != st.pop()) {
                return false;
            }
            temp = temp.next;
        }

        return true;
    }


}
