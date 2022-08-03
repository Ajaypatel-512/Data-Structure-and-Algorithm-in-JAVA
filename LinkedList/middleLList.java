package LinkedList;

public class middleLList {
    ListNode tail;
    ListNode head;
    private class ListNode{
        int val;
        ListNode next;
    }
    public ListNode middleNode(ListNode head) {
        ListNode s = head;
        ListNode f = head;
        while (f != null && f.next != null){
            s = s.next;
            f = f.next.next;
        }
        return s;
    }
}
