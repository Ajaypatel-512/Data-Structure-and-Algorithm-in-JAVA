package Linear_Search;

public class lSearch_string {
    public static void main(String[] args) {
        String s = "Ajay";
        char c = 'n';

//        System.out.println(lsearch(s,c));
        System.out.println(lsearch(s.toCharArray(),c));
    }

    static boolean lsearch(char[] s, char target) {
        if(s.length == 0){
            return false;
        }
        for (char ch: s) {
            if(ch == target){
                return true;
            }
        }
        return false;
    }

//    static int lsearch(String s, char target) {
//        if(s.length()==0){
//            return -1;
//        }
//        for (int i = 0; i < s.length(); i++) {
//            if(s.charAt(i) == target){
//                return i;
//            }
//        }
//        return -1;
//    }
}
