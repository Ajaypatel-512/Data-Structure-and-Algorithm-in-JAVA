package Recursion.LinkedList;

public class LLlist {
    private Node head;
    private Node tail;
    private int size;

    public LLlist() {
        this.size = 0;
    }


    // INSERT VALUE AT FIRST POSITION
    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;

        if(tail == null){
            tail = head;
        }
        size +=1;
    }

    // INSERT VALUE AT FIRST POSITION
    public void insertRec(int val, int index){
        head = insertRec(val,index,head);
    }
    private Node insertRec(int val,int index, Node node){
        if(index == 0){
            Node temp = new Node(val, node);
            size++;
            return temp;
        }
        node.next = insertRec(val,index-1,node.next);
        return node;
    }


    // INSERT VALUE AT SPECIFIC POSITION
    public void insertPos(int val,int index){
        if(index == 0){
            insertFirst(val);
            return;
        }
        if (index == size){
            insertLast(val);
            return;
        }
        int i=1;
        Node temp = head;
        while(i < index){
            temp = temp.next;
            i++;
        }
        Node node = new Node(val,temp.next);
        temp.next = node;
        size +=1;
    }

    // INSERT VALUE AT LAST POSITION
    public void insertLast(int val){
        if(tail == null){
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size +=1;
    }

    // DELETE VALUE FROM FIRST POSITION
    public int deleteFirst(){
        int val = head.data;
        head = head.next;
        if (head == null){
            tail = null;
        }
        size--;
        return val;
    }

    // DELETE VALUE FROM SPECIFIC POSITION
    public int deletePos(int index){
        if(index == 0){
            return deleteFirst();
        }
        if(index == size-1){
            return deleteLast();
        }

        Node prev = get(index-1);
        int val = prev.next.data;
        prev.next = prev.next.next;
        return val;
    }




    // DELETE VALUE FROM LAST POSITION
    public int deleteLast(){
        if(size <= 1){
            return deleteFirst();
        }
        Node secLast = get(size-2);
        int val = tail.data;
        tail = secLast;
        tail.next = null;
        return val;
    }


    // SEARCH FOR THE VALUE IN LIST
    public Node find(int value) {
        Node node = head;
        while(node != null){
            if(node.data == value){
                return node;
            }
            node = node.next;
        }
        return null;
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


    // GET THE SIZE OF LIST
    private Node get(int index) {
        Node node = head;
        for (int j = 0; j < index; j++) {
            node = node.next;
        }
        return node;
    }



    //DUPLICATES REMOVED
    public void duplicates(){
        Node temp = head;
        while (temp != null){
            if (temp.data == temp.next.data){
                temp.next = temp.next.next;
                size--;
            }else{
                temp = temp.next;
            }
        }
        tail = temp;
        tail.next = null;
    }
}
