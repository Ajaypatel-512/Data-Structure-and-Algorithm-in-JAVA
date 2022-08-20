package BigInteger;

import java.math.BigInteger;
import java.util.Scanner;

public class fibo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(fibonacci(n));
    }

    private static BigInteger fibonacci(int n) {
        BigInteger a = new BigInteger("0");
        BigInteger b = new BigInteger("1");
        BigInteger c = new BigInteger("1");

        for (int i = 2 ; i <= n ; i++) {
            c = a.add(b);
            a = b;
            b = c;
        }
        return b;
    }
}
