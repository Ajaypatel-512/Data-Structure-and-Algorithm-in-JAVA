package Recursion.LinkedList;

public class Main {
    public static void main(String[] args) {
//        ReverseLL ll = new ReverseLL();
//        ll.insertFirst(3);
//        ll.insertFirst(8);
//        ll.insertFirst(2);
//        ll.insertFirst(28);
//        ll.display();
//        ll.reverseList(ll.head);
//        ll.display();

//        LLlist ll = new LLlist();
//        ll.insertFirst(3);
//        ll.insertFirst(8);
//        ll.insertFirst(2);
//        ll.insertFirst(28);
//        ll.display();
//        ll.insertRec(88,2);
//        ll.display();

        LLlist ll = new LLlist();
        ll.insertFirst(3);
        ll.insertFirst(3);
        ll.insertFirst(2);
        ll.insertFirst(1);
        ll.insertFirst(1);
        ll.display();
        ll.duplicates();
        ll.display();
    }
}

