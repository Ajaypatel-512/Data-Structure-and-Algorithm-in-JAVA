package Set_Interface;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.stream.Collectors;
// Unique values
// unordered
// null allowed
// no insertion order followed
// uses hashing concept
// for each or iterator

// add, remove, isEmpty, clear, size(), contains()
public class hashSet {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,3,5,6};
        HashSet<Integer> set = new HashSet<>();
//        set.add(19);
//        set.add(119);
//        set.add(190);
//        set.add(45);
//        set.add(96);
//        set.add(190);
//        System.out.println(set);

        for (int i:arr) {
            set.add(i);
        }

//        System.out.println(set);
//        Iterator<Integer> i = set.iterator();
//        while (i.hasNext()){
//            System.out.println(i.next()+" ");
//        }

//        System.out.println(Arrays.stream(set).collect(Collectors.toSet()));


//        for (int i:set) {
//            System.out.println(i);
//        }
//        System.out.println(set.contains(11));
//        System.out.println("Check set is empty or not : "+set.isEmpty());
//        System.out.println(set.size());
//        set.clear();
//        System.out.println(set.size());
//        set.remove(190);
//        System.out.println(set);
//        set.add(null);
//        set.add(null);
//        set.add(null);
//        System.out.println(set);
    }
}
