package String;

public class ReverseOrderOfWordsInAString {
    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
    }
    public static String reverseWords(String s) {
        String[] parts = s.trim().replaceAll(" +", " ").split(" ");
        String rev = "";
        for(int i=parts.length-1; i>=0; i--){
            if(parts[i].length() < 0) continue;
            rev = rev + parts[i] + " ";
        }

        return rev.substring(0, rev.length() - 1);
    }
}
