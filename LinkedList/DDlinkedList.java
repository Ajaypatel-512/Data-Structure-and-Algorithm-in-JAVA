package LinkedList;

public class DDlinkedList {
    Node head;

    //INSERT FIRST
    public void insertFirst(int value){
        Node node = new Node(value);
        node.next = head;
        node.prev = null;
        if(head != null) {
            head.prev = node;
        }
        head = node;
    }

    public void display(){
        Node node = head;
        while(node != null){
            System.out.print(node.value+" -> ");
            node = node.next;
        }
        System.out.println("END");
    }

    public void displayRev(){
        Node node = head;
        Node last = null;
        while(node != null){
            System.out.print(node.value+" -> ");
            last = node;
            node = node.next;
        }
        System.out.println("END");
        System.out.println();
        while (last != null){
            System.out.print(last.value +" -> ");
            last =  last.prev;
        }
        System.out.println("START");
    }


    private class Node{
        int value;
        Node next;
        Node prev;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
}
