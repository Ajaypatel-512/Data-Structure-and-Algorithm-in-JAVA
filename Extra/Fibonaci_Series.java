package Extra;

import java.util.Scanner;

public class Fibonaci_Series {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number upto which fibaonacci series you want");
        int num = sc.nextInt();
        int a = 0, b = 1, c, sum = 0;
        System.out.print(a + " " + b + " ");

        for (int i = 2; i < num; i++) {
            c = a + b;
            System.out.print(c + " ");
            a = b;
            b = c;
        }
    }
}
