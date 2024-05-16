package Extra;

import java.util.Scanner;

public class Prime_No {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number to check for prime");
        int n = sc.nextInt();
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                count += 1;
                break;
            }
            count = 0;
        }
        if (count != 0) {
            System.out.println(n + " Not a prime");
        } else {
            System.out.println(n + " a prime");
        }
    }
}
