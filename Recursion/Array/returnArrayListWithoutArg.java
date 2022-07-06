package Recursion.Array;

import java.util.ArrayList;

public class returnArrayListWithoutArg {
    public static void main(String[] args) {
        int[] arr = {1,3,4,4,9,18};
        int target = 4;

        System.out.println(lSearch(arr,target,0));
    }

    private static ArrayList<Integer> lSearch(int[] arr, int target, int i) {
        ArrayList<Integer> list = new ArrayList<>();
        if (i == arr.length){
            return list;
        }
        if (arr[i] == target){
            list.add(i);
        }
        ArrayList<Integer> ans = lSearch(arr,target,i+1);
        list.addAll(ans);
        return list;
    }
}
