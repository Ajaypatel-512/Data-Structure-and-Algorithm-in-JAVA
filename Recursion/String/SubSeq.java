package Recursion.String;

import java.io.Serializable;
import java.util.ArrayList;

public class SubSeq {
    public static void main(String[] args) {
//        subseq("","abc");
//        ArrayList<String> ans = subseq("","abc",new ArrayList<>());
//        System.out.println(ans);

        System.out.println(subseq("","abc"));
    }

//    private static void subseq(String p, String up) {
//        if(up.isEmpty()){
//            System.out.print(p+" ");
//            return;
//        }
//        char ch = up.charAt(0);
//        subseq(p+ch,up.substring(1));
//        subseq(p,up.substring(1));
//    }

//    private static ArrayList<String> subseq(String p, String up, ArrayList<String> list) {
//        if(up.isEmpty()){
//            list.add(p);
//            return list;
//        }
//        char ch = up.charAt(0);
//        return subseq(p+ch,up.substring(1),list);
//        return subseq(p,up.substring(1),list);
//    }

    private static ArrayList<String> subseq(String p, String up) {
        if (up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        ArrayList<String> left = subseq(p+ch,up.substring(1));
        ArrayList<String> right = subseq(p,up.substring(1));

        left.addAll(right);
        return left;
    }
}
