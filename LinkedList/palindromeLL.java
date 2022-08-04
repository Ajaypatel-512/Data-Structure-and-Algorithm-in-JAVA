package LinkedList;

public class palindromeLL {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
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

    public boolean isPalindrome(ListNode head) {
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


}
