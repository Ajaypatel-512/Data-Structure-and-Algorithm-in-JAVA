package String;

public class CircularStatement {
    public static void main(String[] args) {
        System.out.println(isCircularSentence("leetcode exercises sound delightful"));
    }

    //Solution 1 O(n) O(n)
    public static boolean isCircularSentence(String sentence) {
        String[] words = sentence.split(" ");
        boolean flag = true;
        if (words.length == 1){
            String word = words[0];
            if (word.charAt(0) != word.charAt(word.length()-1)){
                return false;
            } else{
                return true;
            }
        } else {


            for (int i=0; i<words.length-1; i++){
                String word = words[i];
                String wd = words[i+1];
                if (word.charAt(word.length()-1) != wd.charAt(0)){
                    return false;
                }
            }

            String last = words[words.length-1];

            if (words[0].charAt(0) != last.charAt(last.length()-1)){
                return false;
            }
            flag = true;
        }

        return flag;
    }
}
