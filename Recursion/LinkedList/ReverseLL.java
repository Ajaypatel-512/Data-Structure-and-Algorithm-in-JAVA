package Recursion.LinkedList;

public class ReverseLL {
    Node head;
    Node tail;
    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;

        if(tail == null){
            tail = head;
        }
    }


    public Node reverseList(Node head) {
        if(head == null || head.next == null)
            return head;

        Node newHead = reverseList(head.next);
        Node headNext = head.next;
        headNext.next = head;
        head.next = null;
        return newHead;
    }



    // DISPLAYING VALUES
    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+" --> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    private class Node{
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

}
