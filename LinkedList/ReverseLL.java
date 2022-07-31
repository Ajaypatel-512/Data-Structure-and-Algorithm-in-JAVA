package LinkedList;

public class ReverseLL {
    private class ListNode{
        int val;
        ListNode next;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode temp = null;
        if(head == null)
            return null;

        while(head.next != null){
            temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        head.next = prev;
        return head;
    }
}
