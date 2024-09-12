package String;

import java.util.HashSet;
import java.util.Set;

public class CountConsistentStrings {
    public static void main(String[] args) {
        String allowed = "ab";
        String[] words = {"ad","bd","aaab","baa","badab"};

        int count = countConsistentStrings(allowed,words);
        System.out.println(count);
    }

    public static int countConsistentStrings(String allowed, String[] words) {
        Set<Character> allowedSet = new HashSet<>();

        for(Character c: allowed.toCharArray()){
            allowedSet.add(c);
        }

        int count = 0;

        for(String word: words){
            boolean isConsistent = true;
            for(Character c: word.toCharArray()){
                if(!allowedSet.contains(c)){
                    isConsistent = false;
                    break;
                }
            }

            if(isConsistent){
                count++;
            }
        }
        return count;
    }
}
