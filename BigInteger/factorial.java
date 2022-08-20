package BigInteger;

import java.math.BigInteger;
import java.util.Scanner;

public class factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();

        System.out.println(factorialP(a));
    }

    private static BigInteger factorialP(int a) {
        BigInteger b = new BigInteger("1");
        for (int i = 2; i <= a; i++) {
            BigInteger x = BigInteger.valueOf(i);
            b = b.multiply(x);
        }
        return b;
    }
}
