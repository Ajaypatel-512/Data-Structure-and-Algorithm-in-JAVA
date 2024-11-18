package Arrayss.SlidingWindow;

import java.util.Arrays;

public class DefuseTheBomb {
    public static void main(String[] args) {
        int[] code = {5,7,1,4};
        int k = 3;
        int[] result = decrypt2(code,k);
        System.out.println(Arrays.toString(result));
    }

    //Solution 1 Using Brute Force
    //T.C : O(n*k)
    //S.C : O(n)
    public static int[] decrypt1(int[] code, int k) {
        int n = code.length;
        int[] result = new int[n];

        if (k == 0){
            Arrays.fill(result,0);
            return result;
        }

        for (int i=0; i<n; i++){
            if (k > 0){
                for (int j = i+1; j < i+k+1; j++){
                    result[i] += code[j % n];
                }
            } else {
                for (int j = i - Math.abs(k); j < i; j++){
                    result[i] += code[(j + n) % n];
                }
            }
        }
        return result;
    }

    //Solution 2 Using Sliding Window
    //T.C : O(n*k)
    //S.C : O(n)
    public static int[] decrypt2(int[] code, int k) {
        int n = code.length;
        int[] result = new int[n];

        if (k == 0){
            Arrays.fill(result,0);
            return result;
        }

        int start = 1, end = k, sum = 0;

        if (k < 0) {
            start = n - Math.abs(k);
            end = n - 1;
        }

        for (int i = start; i <= end; i++){
            sum += code[i];
        }

        for (int i = 0; i < n; i++){
            result[i] = sum;
            sum -= code[(start) % code.length];
            sum += code[(end + 1) % code.length];
            start++;
            end++;
        }
        return result;
    }

}
