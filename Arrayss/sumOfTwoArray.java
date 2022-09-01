package Arrayss;

import java.util.Arrays;

public class sumOfTwoArray {
    public static void main(String[] args) {
        int[] arr1 = {2,1,9,6};
        int[] arr2 = {3,1,4,6};
        int[] result = new int[5];
        sumOfArray(arr1,arr2,result);
        System.out.println(Arrays.toString(result));
    }
    public static void sumOfArray(int[] arr1, int[] arr2,int[] op){
//        int[] op = new int[5];
        int i = arr1.length-1;
        int j = arr2.length-1;

        int carry = 0;
//        int[] op = new int[5];
        int k = Math.min(arr1.length,arr2.length);
        while(i>=0 && j>=0) {
            int sum = arr1[i] + arr2[j] + carry;
            op[k] = sum % 10;
            carry /= sum;
            i--;
            j--;
            k--;
        }
        while(i>=0){
            int sum = arr1[i]+carry;
            op[k] = sum%10;
            carry /= sum;
            i--;
            k--;
        }

        while(j>=0){
            int sum = arr2[j] + carry;
            op[k] = sum%10;
            carry /= sum;
            j--;
            k--;
        }
        op[0] = carry;
//        System.out.println(Arrays.toString(op));
    }
}
