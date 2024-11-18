package Arrayss.SlidingWindow;

import java.util.Arrays;

public class DefuseTheBomb {
    public static void main(String[] args) {
        int[] code = {5,7,1,4};
        int k = 3;
        int[] result = decrypt(code,k);
        System.out.println(Arrays.toString(result));
    }

    //Solution 1
    //T.C : O(n*k)
    //S.C : O(n)
    public static int[] decrypt(int[] code, int k) {
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
}
