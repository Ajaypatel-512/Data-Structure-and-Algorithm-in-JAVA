package Recursion.MazeProblems;

import java.util.ArrayList;

public class mazeProblmPermut {
    public static void main(String[] args) {
//        permut("",3,3);
        System.out.println(permutRet("",3,3));
    }

//    public static void permut(String p, int r, int c) {
//        if(r == 1 && c == 1){
//            System.out.println(p);
//            return;
//        }
//        if(r>1){
//            permut(p+'D',r-1,c);
//        }
//        if(c>1){
//            permut(p+'R',r,c-1);
//        }
//    }


    public static ArrayList<String> permutRet(String p, int r, int c) {
        if(r == 1 && c == 1){
            ArrayList<String> ans = new ArrayList<>();
            ans.add(p);
            return ans;
        }
        ArrayList<String> list = new ArrayList<>();

        if(r>1){
            list.addAll(permutRet(p+'D',r-1,c));
        }
        if(c>1){
            list.addAll(permutRet(p+'R',r,c-1));
        }
        return list;
    }
}
