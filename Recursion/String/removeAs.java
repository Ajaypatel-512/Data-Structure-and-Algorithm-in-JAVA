package Recursion.String;

public class removeAs {
    public static void main(String[] args) {
//        String p = "abaccd";
//        removeA("","abaccd");
        System.out.println(removeA("abaccd"));
    }

    /********** METHOD 1 Loop *****************************/
    private static void removeA(String p,String up) {
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        if(ch == 'a'){
            removeA(p, up.substring(1));
        } else {
            removeA(p + ch, up.substring(1));
        }
    }

    /********** METHOD 2 RECURSION*****************************/
    private static String removeA(String p) {
        if(p.isEmpty()){
            return "";
        }
        char ch = p.charAt(0);
        if(ch == 'a'){
            return removeA(p.substring(1));
        } else {
            return ch + removeA(p.substring(1));
        }
    }
}
