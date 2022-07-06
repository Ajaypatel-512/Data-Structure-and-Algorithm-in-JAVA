package Recursion.Array;

import jdk.dynalink.beans.StaticClass;

import java.util.ArrayList;

public class linearSearch {
    public static void main(String[] args) {
        int[] arr = {3,3,2,1,9,18};
        int target = 18;
//        System.out.println(lsearch(arr,target,0));
//        System.out.println(lsearchIndex(arr,target,0));
//        System.out.println(lsearchLast(arr,target,arr.length-1));
//        lsearchAllIndex(arr,target,0);
//        System.out.println(list);
        ArrayList<Integer> ans = lsearchAllIndex(arr,target,0,new ArrayList<>());
        System.out.println(ans);
    }

    /*************** Boolean Value ****************************/
    private static boolean lsearch(int[] arr,int target, int i) {
        if (i == arr.length){
            return false;
        }
        return arr[i] == target || lsearch(arr,target,i+1);
    }

    /*************** INDEX VALUE ****************************/
    private static int lsearchIndex(int[] arr,int target, int i) {
        if (i == arr.length){
            return -1;
        }
        if (arr[i] == target){
            return i;
        }else
            return lsearchIndex(arr,target,i+1);
    }

    /*************** SEARCHING FROM LAST INDEX VALUE ****************************/
    private static int lsearchLast(int[] arr,int target, int i) {
        if (i == -1){
            return -1;
        }
        if (arr[i] == target){
            return i;
        }else
            return lsearchLast(arr,target,i-1);
    }

    /***************ADD ALL Element VALUE ****************************/
//    static ArrayList<Integer> list = new ArrayList<>();
//    private static void lsearchAllIndex(int[] arr,int target, int i) {
//        if (i == arr.length){
//            return;
//        }
//        if (arr[i] == target){
//            list.add(i);
//        }
//        lsearchAllIndex(arr,target,i+1);
//    }

    /***************ADD ALL Element VALUE ****************************/
    private static ArrayList<Integer> lsearchAllIndex(int[] arr,int target, int i,ArrayList<Integer> list) {
        if (i == arr.length){
            return list;
        }
        if (arr[i] == target){
            list.add(i);
        }
        return lsearchAllIndex(arr,target,i+1,list);
    }

}
