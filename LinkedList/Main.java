package LinkedList;

public class Main {
    public static void main(String[] args) {
        LLlist ll = new LLlist();
        ll.insertFirst(3);
        ll.insertFirst(8);
        ll.insertFirst(2);
        ll.insertFirst(28);
        ll.insertPos(103,3);
        ll.insertLast(99);
        ll.display();
        System.out.println(ll.deleteFirst());
        ll.display();
        System.out.println(ll.deleteLast());
        ll.display();
        System.out.println(ll.deletePos(2));
        ll.display();
        System.out.println(ll.find(8));
    }
}
