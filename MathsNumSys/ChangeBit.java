package MathsNumSys;

import java.util.Arrays;

public class ChangeBit {
    public static void main(String[] args) {
        int N = 8;
        System.out.println(Arrays.toString(changeBits(N)));
    }
    static int[] changeBits(int N) {
        // code here
        int ans =(1<<((int)(Math.log(N)/Math.log(2)) + 1)) - 1;
        return new int[]{ans-N, ans};

    }
}
