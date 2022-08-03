package LinkedList;

public class ReverseLL {
    ListNode tail;
    ListNode head;
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

    public void recursionReverse(ListNode node){
        if(node == tail){
            head = tail;
            return;
        }
        recursionReverse(node.next);
        tail.next = node;
        tail = node;
        tail.next = null;
    }


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

}
