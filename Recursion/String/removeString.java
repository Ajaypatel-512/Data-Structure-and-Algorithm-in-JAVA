package Recursion.String;

public class removeString {
    public static void main(String[] args) {
//        System.out.println(removeS("bacapplefdr"));
        System.out.println(removeAppnotApple("bfappdgapple"));
    }

    /********** METHOD  RECURSION*****************************/
    private static String removeS(String p) {
        if(p.isEmpty()){
            return "";
        }

        if(p.startsWith("apple")){
            return removeS(p.substring(5));
        } else {
            return p.charAt(0) + removeS(p.substring(1));
        }
    }





    private static String removeAppnotApple(String p) {
        if(p.isEmpty()){
            return "";
        }

        if(p.startsWith("app") && !p.startsWith("apple")){
            return removeAppnotApple(p.substring(3));
        } else {
            return p.charAt(0) + removeAppnotApple(p.substring(1));
        }
    }
}
