package Recursion.MazeProblems;

import java.util.ArrayList;

public class mazeDiagonal {
    public static void main(String[] args) {
        System.out.println(permutRet("",2,2));
    }
    public static ArrayList<String> permutRet(String p, int r, int c) {
        if(r == 1 && c == 1){
            ArrayList<String> ans = new ArrayList<>();
            ans.add(p);
            return ans;
        }
        ArrayList<String> list = new ArrayList<>();

        if (r>1 && c>1){
            list.addAll(permutRet(p+'D',r-1,c-1));
        }
        if(r>1){
            list.addAll(permutRet(p+'V',r-1,c));
        }
        if(c>1){
            list.addAll(permutRet(p+'H',r,c-1));
        }
        return list;
    }
}
