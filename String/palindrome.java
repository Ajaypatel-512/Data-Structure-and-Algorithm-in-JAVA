package String;

public class palindrome {
    public static void main(String[] args) {
        String s = "madam";
        System.out.println(isPalindrome(s));
    }
    public static boolean isPalindrome(String s1){
        StringBuilder sb = new StringBuilder(s1);
        sb.reverse();
        System.out.println(sb);
        return s1.equals(sb.toString());
    }
}
