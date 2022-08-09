package Map_Interface;

import java.util.HashMap;

public class findOccString {
    public static void main(String[] args) {
        String s = "This is my world world";
        HashMap<String , Integer> map = new HashMap<>();
        String[] words = s.split(" ");

        for (String word: words) {
            if(map.containsKey(word)){
                map.put(word,map.get(word)+1);
            } else{
               map.put(word,1);
            }
        }
        System.out.println(map);
    }
}
