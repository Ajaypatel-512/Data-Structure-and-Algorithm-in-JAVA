package Map_Interface;

import java.util.HashMap;
import java.util.Map;
//key value pair
// keys are unique
// values may be duplicate and null
// uses hashing concept
// no order maintained
// no inserting order followed
// use map.Entry concept of iterating

//getKey(), getValue(), put(), remove(), Map.Entry,

public class hashMap {
    public static void main(String[] args) {
        HashMap<Integer,String> map = new HashMap<Integer,String>();
        map.put(1,"aman");
        map.put(2,"aman");
        map.put(3,"ritesh");
        map.put(4,"satyam");
        map.put(5,"ajay");
        map.put(5,"null");

        System.out.println(map);

//        for (Map.Entry m:map.entrySet()) {
//            System.out.println(m.getKey()+" "+m.getValue());
//        }

        System.out.println(map.remove(4));
        System.out.println("Removed value printing : "+map.get(4));
        System.out.println(map);

    }
}
