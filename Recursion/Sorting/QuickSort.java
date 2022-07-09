package Recursion.Sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] num = {5,4,3,2,1};
        sort(num,0,num.length-1);
        System.out.println(Arrays.toString(num));
    }
    static void sort(int[] num, int low, int high){
        if (low >= high){
            return;
        }
        int s = low;
        int e = high;
        int m = s + (e-s)/2;
        int pivot = num[m];

        while (s <= e){
            while(num[s] < pivot){
                s++;
            }
            while (num[e] > pivot){
                e--;
            }
            if (s <= e){
                int temp = num[s];
                num[s] = num[e];
                num[e] = temp;
                s++;
                e--;
            }
        }

        sort(num,low,e);
        sort(num,s,high);
    }
}
