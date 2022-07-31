package LinkedList;

public class CycleLL {

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

    //CHECK FOR CYCLE PRESENT IN LINKEDLIST OR NOT using fast n slow pointer method
    public boolean hasCycle(Node head) {
        Node f = head;
        Node s = head;

        while(f != null && f.next != null){
            f = f.next.next;
            s = s.next;
            if(f == s)
                return true;
        }
        return false;
    }


    //FIND THE LENGTH OF CYCLE PRESENT IN LINKEDLIST OR NOT using fast n slow pointer method
    public int length(Node head) {
        Node f = head;
        Node s = head;

        while(f != null && f.next != null){
            f = f.next.next;
            s = s.next;
            if(f == s){
                //calculate length
                Node temp = s;
                int length = 0;
                do{
                    temp = temp.next;
                    length++;
                }while(temp != s);
                return length;
            }
        }
        return 0;
    }
}
