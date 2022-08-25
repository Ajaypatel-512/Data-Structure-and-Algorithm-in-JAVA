//package Iterator;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.Collections;
//import java.util.Iterator;
//
//public class traversal {
//    public static void main(String[] args) {
//        Collection<Integer> c = new ArrayList<Integer>();
//        c.add(10);
//        c.add(25);
//        c.add(30);
//        c.add(50);
//        removeEven(c);
//    }
//
//    private static void removeEven(Collection<Integer> c) {
//        Iterator it = c.iterator();
//        while (it.hasNext()){
//            int x = (Integer) it.next();
//            if(x%2==0){
//                System.out.println(it.remove());
//            }
//        }
//    }
//}
