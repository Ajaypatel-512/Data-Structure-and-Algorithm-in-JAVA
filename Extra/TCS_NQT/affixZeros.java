package Extra.TCS_NQT;

import java.util.Scanner;

public class affixZeros {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        affixZero(m,n);
    }

    private static void affixZero(int m, int n) {
        for (int i = m; i <= n; i++) {
            System.out.println("0"+m);
            m++;
        }
    }
}
