package String;

public class palindrome {
    public static void main(String[] args) {
        String s = "madam";
//        System.out.println(isPalindrome(s));
        System.out.println(isPalindrome1(s));
    }
    public static boolean isPalindrome1(String s1){
        char s = s1.charAt(0);
        char e = s1.charAt(s1.length()-1);
        int i=0;
        while(s>e){
            if(s==e){
                s++;
                e--;
            }
            if(s!=e)
                return false;
        }
        return true;
    }


    public static boolean isPalindrome(String s1){
        StringBuilder sb = new StringBuilder(s1);
        sb.reverse();
        System.out.println(sb);
        return s1.equals(sb.toString());
    }
}
