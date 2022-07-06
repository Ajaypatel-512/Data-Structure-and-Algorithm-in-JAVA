package Arrayss;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayFormOfInteger {
    public static void main(String[] args) {
        int[] num = {9,9,9,9,9,9,9,9,9,9};
        int k = 1;
        System.out.println(addToArrayForm(num,k));

    }
    public static List<Integer> addToArrayForm(int[] num, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        int i = 0;
        long sum = 0;
        int n = num.length;
        while(i<n){
            sum += (num[i] * Math.pow(10,n-1-i));
            i++;
        }
        sum = sum+k;
        while(sum>0){
            int rem = (int) (sum%10);
            ans.add(rem);
            sum = sum/10;
        }
        Collections.reverse(ans);
        return ans;
    }
}
