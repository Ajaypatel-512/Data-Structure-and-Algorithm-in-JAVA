package String;

public class ReverseVowel {
    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(reverseVowels(s));
    }
    public static char[] reverseVowels(String s) {
        char[] ch = s.toLowerCase().toCharArray();
        int start = 0;
        int end = ch.length-1;
        while(start<=end){
            if((ch[start] == 'a' ||ch[start] == 'e'||ch[start] == 'i'||ch[start] == 'o'||ch[start] == 'u')&&
                    (ch[end] == 'a'||ch[end] == 'e'||ch[end] == 'i'||ch[end] == 'o'||ch[end] == 'u')){
                char temp = ch[start];
                ch[start] = ch[end];
                ch[end] = temp;
            }
            start++;
            end--;
        }

        System.out.println(ch.toString());
        return ch;
    }
}
