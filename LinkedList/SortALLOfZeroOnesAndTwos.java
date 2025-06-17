package LinkedList;

public class SortALLOfZeroOnesAndTwos {
    public static void main(String[] args) {
        // Example usage
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(0);
        head.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next = new ListNode(2);

        head = sortListCounting(head);

        // Print sorted list
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }

    //Solution 1: Using three pointers
    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public static ListNode sortList(ListNode head) {
        ListNode zeroHead = new ListNode(-1);
        ListNode oneHead = new ListNode(-1);
        ListNode twoHead = new ListNode(-1);

        ListNode zero = zeroHead;
        ListNode one = oneHead;
        ListNode two = twoHead;

        ListNode temp = head;

        while (temp != null) {
            if (temp.val == 0) {
                zero.next = temp;
                zero = temp;
            } else if (temp.val == 1) {
                one.next = temp;
                one = temp;
            } else {
                two.next = temp;
                two = temp;
            }
            temp = temp.next;
        }

        // Connect the three lists
        zero.next = oneHead.next != null ? oneHead.next : twoHead.next;
        one.next = twoHead.next;
        two.next = null;

        // Set the head to the start of the zero list
        head = zeroHead.next != null ? zeroHead.next : (oneHead.next != null ? oneHead.next : twoHead.next);
        return head;
    }

    //Solution 2: Using counting
    //Time Complexity: O(2n) where n is the number of nodes in the linked list
    //Space Complexity: O(1)
    public static ListNode sortListCounting(ListNode head) {
       int count0 = 0, count1 = 0, count2 = 0;
        ListNode temp = head;
        while (temp != null) {
            if (temp.val == 0) {
                count0++;
            } else if (temp.val == 1) {
                count1++;
            } else {
                count2++;
            }
            temp = temp.next;
        }

        temp = head;
        while (temp != null) {
            if (count0 > 0) {
                temp.val = 0;
                count0--;
            } else if (count1 > 0) {
                temp.val = 1;
                count1--;
            } else {
                temp.val = 2;
                count2--;
            }
            temp = temp.next;
        }
        return head;
    }
}
