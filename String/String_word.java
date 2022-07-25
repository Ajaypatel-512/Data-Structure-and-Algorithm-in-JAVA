package String;

import java.util.Arrays;
import java.util.Collections;

public class String_word {
    public static void main(String[] args) {
        String sentence = "Book is in the table and book is mine";
        String word = "Book";
        sentence = sentence.toLowerCase();
        word = word.toLowerCase();
//        System.out.println(findFrequency(sentence,word));
        System.out.println(Collections.frequency(Arrays.asList(sentence.split("\\s")), word));
    }
//    public static int findFrequency(String sentence, String word){
//        String[] arr = sentence.split(" ");
//        int count = 0;
//        String[] uniqueKeys;
//        uniqueKeys = getUniqueKeys(arr);
//        for(String key: uniqueKeys) {
//            if(null == key) {
//                break;
//            }
//            for(String s : key) {
//                if(key.equals(s)) {
//                    count++;
//                }
//            }
//            count=0;
//        }
//        return count;
//    }
//    private static String[] getUniqueKeys(String[] keys)
//    {
//        String[] uniqueKeys = new String[keys.length];
//        uniqueKeys[0] = keys[0];
//        int uniqueKeyIndex = 1;
//        boolean keyAlreadyExists = false;
//        for(int i=1; i<keys.length ; i++)
//        {
//            for(int j=0; j<=uniqueKeyIndex; j++)
//            {
//                if(keys[i].equals(uniqueKeys[j]))
//                {
//                    keyAlreadyExists = true;
//                }
//            }
//            if(!keyAlreadyExists)
//            {
//                uniqueKeys[uniqueKeyIndex] = keys[i];
//                uniqueKeyIndex++;
//            }
//            keyAlreadyExists = false;
//        }
//        return uniqueKeys;
//    }
}
