package Extra;

import java.util.Scanner;

public class Swapping_3v {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int temp;
        System.out.println("Number before swapping");
        System.out.println(n1 + " " + n2);

        temp = n1;
        n1 = n2;
        n2 = temp;
        System.out.println("Number after swapping");
        System.out.println(n1 + " " + n2);
    }
}
