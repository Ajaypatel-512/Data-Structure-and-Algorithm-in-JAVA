package Extra;

import java.util.Scanner;

public class Swapp_xor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter two number to swapp");
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println("Number before swapping");
        System.out.println("a = " + a + ", b = " + b);
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("After swapping:");
        System.out.print("a = " + a + ", b = " + b);

    }
}
