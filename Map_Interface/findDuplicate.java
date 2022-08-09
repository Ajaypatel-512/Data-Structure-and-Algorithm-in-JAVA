package Map_Interface;

import java.util.HashMap;
import java.util.Map;

public class findDuplicate {
    findDuplicate(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        char[] charArray = s.toCharArray();
        for (char c: charArray) {
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }else{
                map.put(c,1);
            }
        }

        for (Map.Entry<Character, Integer> m: map.entrySet()) {
            if (m.getValue() > 1){
                System.out.println(m.getKey() +" "+m.getValue());
            }
        }
    }

    public static void main(String[] args) {
        findDuplicate f = new findDuplicate("geeksforgeeks");
    }
}
