package LinkedList;

public class reverseRangeLL {
    private class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }


    public Node reverseBetween(Node head, int left, int right) {
        if(left == right){
            return head;
        }
        Node present = head;
        Node prev = null;
        for (int i=0;present != null && i<left-1; i++){
            prev = present;
            present = present.next;
        }
        Node last = prev;
        Node newEnd = present;
        Node next = present.next;
        for (int i=0;present != null && i<right-left+1; i++){
            present.next = prev;
            prev = present;
            present = next;
            if (next != null){
                next = next.next;
            }
        }
        if(last!=null){
            last.next = prev;
        }else {
            head = prev;
        }
        newEnd.next = present;
        return head;
    }
}
