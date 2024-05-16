package Extra;

import java.util.Scanner;

public class Swapp_MulDiv {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        System.out.println("values before swapping:");
        System.out.println("x = " + x + " y = " + y);

        x = x * y;
        y = x / y;
        x = x / y;
        System.out.println("values after swapping:");
        System.out.println("x = " + x + " y = " + y);
    }
}
