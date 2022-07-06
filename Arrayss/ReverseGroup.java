package Arrayss;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 Input:
 N = 5, K = 3
 arr[] = {1,2,3,4,5}
 Output: 3 2 1 5 4
 Explanation: First group consists of elements
 1, 2, 3. Second group consists of 4,5.

 * **/
public class ReverseGroup {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        int n = 5;
        int k = 3;
        reverseInGroups(arr,n,k);
    }
    static void reverseInGroups(ArrayList<Integer> arr, int n, int k) {
        // code here
//        for (int i = k-1; i >= 0; i--) {
//            System.out.print(arr.get(i) + " ");
//        }
//        for (int j= arr.size()-1; j>=k; j--){
//            System.out.print(arr.get(j)+" ");
//        }

        ArrayList<Integer> a = new ArrayList<Integer>();
        int i=0;
        while(i<n){
            for (int j=k-1; j>=0;j--){
                if (i+j>=n){
                    continue;
                }
                a.add(arr.get(i+j));
            }
            i = i+k;
        }
        arr.clear();
        for(int j = 0; j < n; j++){
            arr.add(a.get(j));
        }
    }
}
