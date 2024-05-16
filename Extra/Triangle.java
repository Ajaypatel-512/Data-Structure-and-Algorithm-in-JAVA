package Extra;

import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 3 sides of triangle to find Equilateral, Isosceles or Scalene");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int num3 = sc.nextInt();

        if (num1 == num2 && num2 == num3) {
            System.out.println("This is an equilateral triangle");
        } else if (num1 == num2 || num2 == num3 || num1 == num3)
            System.out.println("This is an isosceles triangle");
        else {
            System.out.println("This is a scalene triangle");
        }
    }
}
