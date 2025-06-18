package LinkedList;

public class middleLList {
    /**
     * 876. Middle of the Linked List
     * Given the head of a singly linked list, return the middle node of the linked list.
     *
     * If there are two middle nodes, return the second middle node.
     *
     *
     *
     * Example 1:
     *
     *
     * Input: head = [1,2,3,4,5]
     * Output: [3,4,5]
     * Explanation: The middle node of the list is node 3.
     * Example 2:
     *
     *
     * Input: head = [1,2,3,4,5,6]
     * Output: [4,5,6]
     * Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
     *
     *
     * Constraints:
     *
     * The number of nodes in the list is in the range [1, 100].
     * 1 <= Node.val <= 100
     * */

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        middleLList mll = new middleLList();
        ListNode middle = mll.middleNode2(head);
        while (middle != null) {
            System.out.print(middle.val + " ");
            middle = middle.next;
        }
    }

    //Solution 1: Using Brute Force
    //Time Complexity: O(n) + O(n/2)
    //Space Complexity: O(1)
    public ListNode middleNode(ListNode head) {
        ListNode temp = head;
        int count = 0;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        int midNode = (count/2) + 1;
        temp = head;
        while(temp != null){
            midNode = midNode - 1;
            if(midNode == 0) break;
            temp = temp.next;
        }
        return temp;
    }

    //Solution 2: Using Two Pointer Technique (Tortoise and Hare Approach)
    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public ListNode middleNode2(ListNode head) {
        ListNode s = head;
        ListNode f = head;
        while (f != null && f.next != null){
            s = s.next;
            f = f.next.next;
        }
        return s;
    }
}
