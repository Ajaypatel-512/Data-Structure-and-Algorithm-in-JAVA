package Set_Interface;

import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeSet;
// Unique
// order asc
// null not allowed
// for each or iterator

// add, remove, desc, Iterator

public class treeSet {
    public static void main(String[] args) {
        TreeSet<String> trset = new TreeSet<>();
        trset.add("java");
        trset.add("html");
        trset.add("css");
        trset.add("html");
        trset.add("c$");
//        trset.add(null);
        System.out.println("Ascending set : "+trset);
        System.out.println("Descending set : "+trset.descendingSet());

//        for (String s:trset) {
//            System.out.println(s);
//        }

        //Iterator
//        Iterator itr = trset.iterator();
//        while (itr.hasNext()){
//            System.out.println(itr.next());
//        }

        System.out.println(trset.first());
        System.out.println(trset.last());

    }
}
