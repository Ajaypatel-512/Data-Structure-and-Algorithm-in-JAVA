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

    //INSERT AT SPECIFIC POSITION
    public void insertPos(int after,int value){
        Node p = find(after);
        if(p == null){
            System.out.println("Node does not exsists");
            return;
        }
        Node node = new Node(value);
        node.next = p.next;
        p.next = node;
        node.prev = p;
        if (node.next != null)
            node.next.prev = node;
    }

    //INSERT LAST
    public void insertLast(int value){
        Node node = new Node(value);
        Node last = head;
        node.next = null;
        if(head == null) {
            node.prev = null;
            head = node;
            return;
        }
        while(last != null){
            last = last.next;
        }

        last.next = node;
        node.prev = last;
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

    // SEARCH FOR THE VALUE IN LIST
    public Node find(int val) {
        Node node = head;
        while(node != null){
            if(node.value == val){
                return node;
            }
            node = node.next;
        }
        return null;
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
