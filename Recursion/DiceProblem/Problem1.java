package Recursion.DiceProblem;

import java.util.ArrayList;

/**
 * EG. = dice contains - 1 2 3 4 5 6
 * find how many times you want 4 to print. Maximum possible ways to form 4
 *
 * {
 *      [1111], [112], [13], [22], [31], [4], ....
 * }
 *
 *
 *
 * **/
public class Problem1 {
    public static void main(String[] args) {
//        dice("",4);
        System.out.println(diceRe("",4));
    }
    static void dice(String p, int target){
        if (target == 0){
            System.out.println(p);
            return;
        }
        for (int i = 1; i <= 6 && i<=target; i++) {
            dice(p+i,target-i);
        }
    }

    static ArrayList<String> diceRe(String p, int target){
        if (target == 0){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 1; i <= 6 && i<=target; i++) {
            ans.addAll(diceRe(p+i,target-i));
        }
        return ans;
    }
}
