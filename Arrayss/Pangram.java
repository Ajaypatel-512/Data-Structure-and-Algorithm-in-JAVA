package Arrayss;

public class Pangram {
    public static void main(String[] args) {
        String sentence = "thequickbrownfoxjumpsoverthelazydog";
        System.out.println(checkIfPangram(sentence));
    }

    public static boolean checkIfPangram(String sentence) {
        if(sentence.length()<26){
            return false;
        }
        char ch = 'a';
        for (int i = 0; i < 26; i++) {
            if (sentence.contains(String.valueOf(ch))) {
                ch++;
            } else {
                return false;
            }
        }
        return true;
    }
}
