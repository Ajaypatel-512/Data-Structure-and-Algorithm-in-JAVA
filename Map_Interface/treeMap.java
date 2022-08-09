package Map_Interface;

import java.util.Map;
import java.util.TreeMap;

// contains multiple null values
// sorting asceding order
// keys are uniuqe
// use map.Entry concept of iterating


public class treeMap {
    public static void main(String[] args) {
        TreeMap<Integer,String> treemap = new TreeMap<>();
        treemap.put(1,"aman");
        treemap.put(2,"aman");
        treemap.put(3,"ritesh");
        treemap.put(4,"satyam");
        treemap.put(5,"ajay");
        treemap.put(5,"null");
        treemap.put(6,"null");
        treemap.put(2,"cdev");


        System.out.println(treemap);

        for (Map.Entry m: treemap.entrySet()) {
            System.out.println(m.getKey()+" "+m.getValue());
        }


    }
}
